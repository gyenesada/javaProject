package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientThread implements Runnable {
    String PATH = "/mnt/disk4/gyenesadrienn/csv/";
    String PY_PATH = "/mnt/disk4/gyenesadrienn/python/";

    private final Socket s;
    private Scanner sc;
    private PrintWriter pw;
    private final Connection conn;

    private int threadID, currentTableID, currentTaskID;
    private float accuracyScore = Float.valueOf("-1.0");
    private String rawInput, threadName;

    private ArrayList<String> inDatas = new ArrayList<>();
    private ArrayList<String> outDatas = new ArrayList<>();
    private final DBHandler db;
    
    public ClientThread(Socket s, Connection conn) {
        this.s = s;
        this.conn = conn;
        this.db = new DBHandler();
        System.out.println("A new thread has started..");
    }

    @Override
    public void run() {
        try {
            sc = new Scanner(s.getInputStream());
            pw = new PrintWriter(s.getOutputStream(), true);

            communicationWithClients(pw, sc);
            System.out.println(threadName + " logged out. Thread has stopped.");
        } catch (IOException e) {
            System.out.println("Error: ClientThread run");
        }
    }

    private void communicationWithClients(PrintWriter pw, Scanner sc) {
        int index = 0;
        while (true) {
            System.out.println(index + ". kérés: ");
            System.out.println("");
            outDatas.clear();
            inputPreprocess(sc.nextLine());
            outDatas = controller(inDatas);
            inDatas.clear();
            pw.println(outDatas);

            index++;
            System.out.println("Kérés vége.");
            accuracyScore = Float.valueOf("-1.0");
        }
    }

    private void inputPreprocess(String input) {
        String withoutBrackets = input.replaceAll("[\\[\\]]", "");
        rawInput = withoutBrackets;

        String[] string = withoutBrackets.split(", ");
        inDatas.addAll(Arrays.asList(string));
        System.out.println("IN: " + inDatas);
    }

    private ArrayList<String> controller(ArrayList<String> in) { //This method is handling the input datas, and divides the tasks depending the identifier (first member of incoming data)
        ArrayList<String> out = new ArrayList<>();
        String identifier = in.get(0);
        String filename, taskname, answer;
        int task;
        boolean newtable;
        switch (identifier) {
            case "log:": //log in
                answer = Boolean.toString(db.validateClient(in));
                out.add(identifier);
                out.add(answer);
                break;
            case "reg:": //registration
                answer = Boolean.toString(db.regClient(in));
                out.add(identifier);
                out.add(answer);
                break;
            case "csv:": //csv upload on load page
                taskname = in.get(1).replaceAll(":", "");
                task = db.insertTaskIntoDatabase(taskname);
                currentTaskID = task;
                filename = in.get(2).replaceAll(":", "");
                answer = Boolean.toString(db.insertTableIntoDatabase(filename, filename));

                out.add(identifier);
                out.add(answer);
                out.add(Integer.toString(currentTaskID));
                writeToCsv(filename);
                break;
            case "wcsv:": //csv upload on work page
                filename = in.get(2).replaceAll(":", "");
                currentTaskID = Integer.parseInt(in.get(1).replaceAll(":", ""));
                if (db.insertTableIntoDatabase(filename, filename)) {
                    out = db.getTasksTable();
                    writeToCsv(filename);
                } else {
                    out.add("err:");
                }
                break;
            case "wrk:": //old task loading 
                out = db.getTasks();
                break;
            case "old:": //old tables loading
                currentTaskID = Integer.parseInt(in.get(1));
                out = db.getTasksTable();
                break;
            case "ldt:": //chosen table loading
                currentTaskID = Integer.parseInt(in.get(1));
                out = readFromCsv("ldt:", in.get(2), true);
                break;
            case "fact:": //factorize
                currentTaskID = Integer.parseInt(in.get(2));
                newtable = Boolean.valueOf(in.get(1));

                answer = callingPython(newtable, "factorize.py", in.get(3));
                out = readFromCsv("done:", answer, true);
                break;
            case "norm:": //normalize
                currentTaskID = Integer.parseInt(in.get(2));
                newtable = Boolean.valueOf(in.get(1));

                answer = callingPython(newtable, "normalize.py", in.get(3));
                out = readFromCsv("done:", answer, true);
                break;
            case "ftsl:": //feature selection
                currentTaskID = Integer.parseInt(in.get(2));
                newtable = Boolean.valueOf(in.get(1));

                answer = callingPython(newtable, "variance.py", in.get(3), in.get(4));
                out = readFromCsv("done:", answer, true);
                break;
            case "delc:": //delete columns
                currentTaskID = Integer.parseInt(in.get(2));
                newtable = Boolean.valueOf(in.get(1));

                answer = callingPython(newtable, "dropout.py", in.get(3), parametersToString(in));
                out = readFromCsv("done:", answer, true);
                break;
            case "nanv:": //handle nan values
                currentTaskID = Integer.parseInt(in.get(2));
                newtable = Boolean.valueOf(in.get(1));

                answer = callingPython(newtable, "nanvalues.py", in.get(3), in.get(4));
                out = readFromCsv("done:", answer, true);
                break;
            case "dels:": //delete sessions
                db.setTaskInactive(in.get(1));
                out = db.getTasks();
                break;
            case "delt:": //delete tables
                db.setTableInactive(in.get(1), in.get(2));
                out =db.getTasksTable("delt:");
                break;
            case "tdl:": //table download
                currentTaskID = Integer.parseInt(in.get(1));
                out = readFromCsv("tdl:", in.get(2), false);
                break;
            case "ada:":
                answer = callingClassifier(in, "ada.py");
                if(answer.equals("notokay")){
                    out.add("nok:");
                }else{
                    out = readFromCsv("done:", answer, true);
                }
                break;
            case "rfc:":
                answer = callingClassifier(in, "rfc.py");
                if(answer.equals("notokay")){
                    out.add("nok:");
                }else{
                    out = readFromCsv("done:", answer, true);
                }
                break;
            case "dtc:":
                answer = callingClassifier(in, "dtc.py");
                if(answer.equals("notokay")){
                    out.add("nok:");
                }else{
                    out = readFromCsv("done:", answer, true);
                }
                break;
            case "gtb:":
                answer = callingClassifier(in, "gtb.py");
                if(answer.equals("notokay")){
                    out.add("nok:");
                }else{
                    out = readFromCsv("done:", answer, true);
                }
                break;
            case "san:":
                newtable = Boolean.valueOf(in.get(1));
                answer = callingPython(newtable, "sentiment.py", in.get(3), in.get(4));
                out = readFromCsv("done:", answer, true);
                break;
            case "mdu:":
                answer = Boolean.toString(db.modifyUsername(in.get(1)));
                out.add(identifier);
                out.add(answer);
                out.add(in.get(1));
                System.out.println("out: " + out);
                break;
            case "mdp:":
                db.modifyPass(in.get(1));
                out.add(identifier);
                break;
            case "bye:": //log out
                db.setIsOnlineFalse();
                db.setLogStatusNormal();
                out.add("bye:");
                break;
            default:
                break;
        }
        return out;
    }

    private String parametersToString(ArrayList<String> in) {
        StringBuilder sb = new StringBuilder();

        for (int i = 4; i < in.size(); i++) {
            sb.append(in.get(i));
            sb.append(" ");
        }
        return sb.toString();
    }

    private ArrayList<String> readFromCsv(String identifier, String filename, boolean preview) {
        ArrayList<String> csv = new ArrayList<>();
        csv.add(identifier);
        csv.add(filename + ":");
        System.out.println("Loading chosen table: " + filename);
        String path = PATH + db.getTaskName() + "_" + currentTaskID+ "/" + filename;
        csv.add(Float.toString(db.getAccuracy(filename)) + ":");
        File file = new File(path);
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                csv.add(line);
                csv.add(">>flag<<");
                if (preview) {
                    System.out.println("Preview.");
                int index = 0;
                    while ((line != null && index < 250)) {
                        line = br.readLine();
                        if (line == null) {
                            break;
                        } else {
                            csv.add(line);
                            csv.add(">>flag<<");
                        }
                        index += 1;
                    }
                    System.out.println("index: " + index);
                } else {
                    while (line != null) {
                        line = br.readLine();
                        if (line == null) {
                            break;
                        } else {
                            csv.add(line);
                            csv.add(">>flag<<");
                        }
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("PATH: " + path);
            System.out.println("File not found.");
            
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return csv;
    }

    private void writeToCsv(String filename) {
        new File(PATH + db.getTaskName() + "_" + currentTaskID).mkdir();

        String fs = System.getProperty("file.separator");
        String fullFilepath = PATH +db.getTaskName() + "_" + currentTaskID + fs + filename;
        System.out.println("Fullpath: " + fullFilepath);

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(fullFilepath);
            bw = new BufferedWriter(fw);

            String lines = rawInput.split(":, ")[3];
            String line = lines.replaceAll(", >>flag<<, ", "\n").replaceAll(", >>flag<<", "");

            bw.write(line);
            System.out.println("Done with file writing");
        } catch (IOException e) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println("Error closing bw and fw");
            }
        }

    }
    
    private boolean checkIsOkay(String command) throws IOException, InterruptedException{
        boolean returnvalue=true;
        System.out.println("Isokay.py: " + command);
        
        Process p = Runtime.getRuntime().exec(command);
         BufferedReader pythonOutput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String isokay;
            while ((isokay = pythonOutput.readLine()) != null) {
                System.out.println(isokay);
                returnvalue = Boolean.valueOf(isokay);
            }
            System.out.println("Isokay? " + returnvalue);
        return returnvalue;
    }

    private String callingClassifier(ArrayList<String> input, String py) {
        StringBuilder sb = new StringBuilder();
        StringBuilder pre_sb = new StringBuilder();
        String file = input.get(1);
        String original = db.getOriginalTable(file);
        String returnvalue = file;

        String fs = System.getProperty("file.separator");
        String prefix = "python " + PY_PATH + py + " " + PATH +db.getTaskName() + "_" + currentTaskID + fs + file + " " + PATH + db.getTaskName() + "_" + currentTaskID + fs + original + " ";
        sb.append(prefix);
        
        String isokay = "python " + PY_PATH + "isokay.py " + PATH + db.getTaskName() + "_" + currentTaskID + fs + file + " " + PATH + db.getTaskName() + "_" + currentTaskID + fs + original + " ";
        pre_sb.append(isokay);
        for (int i = 2; i < input.size(); i++) {
            sb = sb.append(input.get(i));
            sb.append(" ");
            pre_sb = pre_sb.append(input.get(i));
            pre_sb.append(" ");
        }
        try {
                if(checkIsOkay(pre_sb.toString())){
                    System.out.println("Classifier can start..");
                    Process p = Runtime.getRuntime().exec(sb.toString());
                    
                    int exitVal = p.waitFor();
                    if (exitVal == 0) {
                        
                    BufferedReader pythonOutput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String pot = pythonOutput.readLine();
                    System.out.println("accuracy: " + pot);
                    accuracyScore = Float.parseFloat(pot);
                    
                        System.out.println("Classifier completed successfully.");
                        String newtablename = prefixedTableName(py, file);
                        db.insertTableIntoDatabase(newtablename, original);
                        db.updateAccuracy(newtablename, currentTaskID);
                        returnvalue = newtablename;
                    } else {
                        System.out.println("Classifier finished with an error.");
                    }
                }
            else{
                    System.out.println("Classifier can't start..");
                    returnvalue = "notokay";
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnvalue;

    }

    private String callingPython(Boolean newtable, String py, String file, String... other) {
        System.out.println("Python file: " + file);
        String returnvalue = file;
        String string = Arrays.toString(other).replaceAll("[\\[\\]]", "").replaceAll("\\t", " ");

        String fs = System.getProperty("file.separator");
        String cmd = "python " + PY_PATH + py + " " + newtable + " " + PATH + db.getTaskName() + "_" + currentTaskID + fs + file + " " + string + "";
        System.out.println("cmdl: " + cmd);
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            int exitVal = p.waitFor();
            if (exitVal == 0) {
                System.out.println("Python script completed successfully.");
            } else {
                System.out.println("Python script finished with an error.");
            }

            if (newtable && exitVal == 0) {
                String newtablename = prefixedTableName(py, file);
                String original = db.getOriginalTable(file);
                db.insertTableIntoDatabase(newtablename, original);
                returnvalue = newtablename;
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnvalue;
    }

    private String prefixedTableName(String python, String file) {
        String prefix = python.replaceAll(".py", "_");
        String fullfilename = prefix + file;
        return fullfilename;
    }
    
         
    public class DBHandler{
        
        public DBHandler(){
            
        }
    
        private boolean validateClient(ArrayList<String> acceptedDatas) {
        String name = acceptedDatas.get(1);
        String pass = acceptedDatas.get(2);
        Statement stat;
        ResultSet rs;

        try {
            stat = conn.createStatement();
            String query = "select password, user_id, is_online, log_status from users where username='" + name + "';";
            rs = stat.executeQuery(query);
            while (rs.next()) {
                String password = rs.getString("PASSWORD");
                if ((pass.equals(password))) {
                    threadName = name;
                    threadID = rs.getInt("USER_ID");

                    String updateQuery = "update users set is_online='" + true + "', log_status = '" + "null" + "' where user_id='" + threadID + "';";
                    Statement updateStat = conn.createStatement();
                    updateStat.executeUpdate(updateQuery);
                    
                    String fs = System.getProperty("file.separator");
                    PATH = PATH + threadID + fs;
                    System.out.println("Path: " + PATH);
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: SQL exception in validateClient() function");
        }
        return false;
    }

    private Boolean regClient(ArrayList<String> acceptedDatas) {
        String name = acceptedDatas.get(1);
        String mail = acceptedDatas.get(2);
        String pass = acceptedDatas.get(3);
        int id = 0;

        try {
            ResultSet maxIDrs;

            Statement maxID = conn.createStatement();
            String maxIDquery = "select nvl(max(user_id),0) from users;";
            maxIDrs = maxID.executeQuery(maxIDquery);

            if (maxIDrs.next()) {
                id = maxIDrs.getInt(1);
            }
            id++;
            Statement stat = conn.createStatement();
            String listquery = "select * from users where username = '" + name + "' or mail='" + mail + "';";
            ResultSet rs = stat.executeQuery(listquery);
            if (rs.next()) {
                return false;
            } else {
                String insertquery = "insert into users values (?,?,?,?,?,?);";
                try {
                    threadName = name;
                    threadID = id;
                    PreparedStatement prepstat = conn.prepareStatement(insertquery);
                    prepstat.setInt(1, threadID);
                    prepstat.setString(2, name);
                    prepstat.setString(3, mail);
                    prepstat.setString(4, pass);
                    prepstat.setBoolean(5, false);
                    prepstat.setString(6, "null");
                    prepstat.addBatch();

                    conn.setAutoCommit(false);
                    prepstat.executeBatch();
                    conn.setAutoCommit(true);

                } catch (SQLException ex) {
                    System.out.println("Nem sikerült felvinni az adatokat.");
                }
                new File(PATH + id).mkdir();
                System.out.println(id + " nevű mappa elkészítve.");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private int insertTaskIntoDatabase(String taskname) {
        int returnvalue = 0;
        try {
            String insertQuery = "insert into tasks values (?,?,?,?);";
            PreparedStatement prep = conn.prepareStatement(insertQuery);

            int id = getTaskID();
            prep.setInt(1, id);
            prep.setString(2, taskname);
            prep.setInt(3, threadID);
            prep.setBoolean(4, true);

            if (isTaskNameValid(taskname)) {
                System.out.println("Taskname is valid.");
                prep.addBatch();
                conn.setAutoCommit(false);
                prep.executeBatch();
                conn.setAutoCommit(true);
                returnvalue = id;
            } else {
                returnvalue = -1;
            }
            System.out.println("Task bejegyezve: " + returnvalue + " számmal.");
        } catch (SQLException e) {

        }
        return returnvalue;
    }

    private boolean isTaskNameValid(String taskname) {
        boolean returnvalue = true;
        try {
            Statement stat = conn.createStatement();
            String query = "select task_name from tasks where user_id = '" + threadID + "';";
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                String dbtask = rs.getString("TASK_NAME");
                if (taskname.equals(dbtask)) {
                    returnvalue = false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnvalue;
    }

    private int getTaskID() {
        int returnvalue = 1;
        try {
            ResultSet maxIDrs;

            Statement maxID = conn.createStatement();
            String maxIDquery = "select nvl(max(task_id),0) from tasks;";
            maxIDrs = maxID.executeQuery(maxIDquery);

            if (maxIDrs.next()) {
                returnvalue = maxIDrs.getInt(1)+1;
            }
        } catch (SQLException ex) {
            System.out.println("Error: Getting task_id");
        }
        return returnvalue;
    }

    private String getTaskName() {
        String returnvalue = "";
        try {
            String query = "select task_name from tasks where task_id = '" + currentTaskID + "';";
            Statement stat = conn.createStatement();

            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                returnvalue = rs.getString("TASK_NAME");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnvalue;
    }

    private boolean insertTableIntoDatabase(String filename, String original) {
        boolean returnvalue = false;
        try {
            String insertQuery = "insert into tables values (?,?,?,?,?,?,?);";
            PreparedStatement prep = conn.prepareStatement(insertQuery);
            currentTableID = getTableID();

            prep.setInt(1, currentTableID);
            prep.setInt(2, threadID);
            prep.setString(3, filename);
            prep.setString(4, original);
            prep.setFloat(5, accuracyScore);
            prep.setBoolean(6, true);
            prep.setInt(7, currentTaskID);

            if (!isTableInTask(filename)) {
                prep.addBatch();

                conn.setAutoCommit(false);
                prep.executeBatch();
                conn.setAutoCommit(true);
                returnvalue = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnvalue;
    }

    private boolean isTableInTask(String tablename) throws SQLException {
        boolean returnvalue = false;

        Statement stat = conn.createStatement();
        String query = "select name from tables where user_id = '" + threadID + "'  and task_id = '" + currentTaskID + "';";

        ResultSet rs = stat.executeQuery(query);
        while (rs.next()) {
            String name = rs.getString("NAME");

            if (tablename.equals(name)) {
                returnvalue = true;
            }
        }
        return returnvalue;
    }
    
    private void updateAccuracy(String tablename, int taskid){
        try{
            Statement stat = conn.createStatement();
            String query = "update tables set accuracy = '"+accuracyScore+"' where  name = '"+tablename+"' and task_id = '" + taskid + "';";  
            stat.executeUpdate(query);
        }catch(SQLException ex){
            System.out.println("Error: updateAccuracy");
        }
    }

    private int getTableID() {
        int returnvalue = 1;
        try {
            ResultSet maxIDrs;

            Statement maxID = conn.createStatement();
            String maxIDquery = "select nvl(max(table_id),0) from tables;";
            maxIDrs = maxID.executeQuery(maxIDquery);

            if (maxIDrs.next()) {
                returnvalue = maxIDrs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error: Getting table_id");
        }
        return ++returnvalue;
    }

    private boolean setTaskInactive(String taskID) {
        boolean returnvalue = true;
        try {
            int id = Integer.parseInt(taskID);
            Statement stat = conn.createStatement();
            String query = "update tasks set is_active = false, task_name = '" + "CB_deleted_task" + "' where task_id = '" + id + "';";
            stat.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnvalue;
    }

    private String getOriginalTable(String filename) {
        String returnvalue = "";
        try {
            Statement stat = conn.createStatement();
            String query = "select original from tables where name = '" + filename + "';";
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                returnvalue = rs.getString("ORIGINAL");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Original table: " + returnvalue);
        return returnvalue;
    }

    private boolean setTableInactive(String task_id, String table_name) {
        boolean returnvalue = true;
        try {
            int id = Integer.parseInt(task_id);
            Statement stat = conn.createStatement();
            String query = "update tables set is_active = false, name = '" + "CB_deleted_table" + "' where name = '" + table_name + "' and task_id = '" + id + "';";
            stat.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnvalue;
    }

    private ArrayList<String> getTasksTable(String... other) {
        ArrayList<String> returnvalue = new ArrayList<>();
        if (other.length == 0) {
            returnvalue.add("old:");
        } else {
            //nem kell .add(old:)?
            returnvalue.add(Arrays.toString(other));
        }

        try {
            Statement stat = conn.createStatement();
            String query = "select name from tables where user_id='" + threadID + "' and task_id='" + currentTaskID + "' and is_active= true;";
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                returnvalue.add(rs.getString("NAME"));
            }

        } catch (SQLException ex) {
            System.out.println("Error: load old works");
        }

        return returnvalue;
    }

    private ArrayList<String> getTasks() {
        ArrayList<String> returnvalue = new ArrayList<>();
        returnvalue.add("wrk:");

        try {
            Statement stat = conn.createStatement();
            String query = "select task_id, task_name from tasks where user_id='" + threadID + "' and is_active = true;";
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                returnvalue.add(Integer.toString(rs.getInt("TASK_ID")));
                returnvalue.add(rs.getString("TASK_NAME"));
            }

        } catch (SQLException e) {
            System.out.println("Error: load tasks");
        }
        return returnvalue;
    }

    private void setIsOnlineFalse() {
        try {
            String updateQuery = "update users set is_online='" + false + "'where user_id = '" + threadID + "';";
            Statement updateStat = conn.createStatement();
            updateStat.executeUpdate(updateQuery);
        } catch (SQLException e) {
            System.out.println("Error: logout client");
        }
    }

    private void setLogStatusNormal() {
        try {
            String updateQuery = "update users set log_status='" + "normal" + "' where user_id = '" + threadID + "';";
            Statement updateStat = conn.createStatement();
            updateStat.executeUpdate(updateQuery);
        } catch (SQLException e) {
            System.out.println("Error: logout client");
        }
    }

     private void modifyPass(String newpass) {
        try {
            Statement updatePass = conn.createStatement();
            String updateQuery = "update users set password = '" + newpass + "' where user_id = '" + threadID + "';";
            updatePass.executeUpdate(updateQuery);
        } catch (SQLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean modifyUsername(String newusername) {
        boolean returnvalue = true;
        try {
            Statement stat = conn.createStatement();
            String query = "select user_id from users where username = '" + newusername + "';";
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                returnvalue = false;
            } else {
                Statement updateName = conn.createStatement();
                String updateQuery = "update users set username = '" + newusername + "' where user_id = '" + threadID + "';";
                updateName.executeUpdate(updateQuery);

                threadName = newusername;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnvalue;
    }
    
    private float getAccuracy(String tablename){
        float returnvalue=Float.valueOf("-1.0");
            try {
                Statement stat = conn.createStatement();
                String query = "select accuracy from tables where name= '"+tablename+"' and task_id = '"+currentTaskID+"';";
                ResultSet rs = stat.executeQuery(query);
                while(rs.next()){
                    returnvalue = rs.getFloat("ACCURACY");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        return returnvalue;
    }
}
}
