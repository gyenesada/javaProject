package szakdolgozat.Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    // PATH gyenesadrienn\\csv\\;
    // PY_PATH gyenesadrienn\\python\\;
    String PATH = "C:\\Users\\Adrienn\\Desktop\\szerver\\csv\\";
    String PY_PATH = "C:\\Users\\Adrienn\\Desktop\\szerver\\python\\";

    private final Socket s;
    private Scanner sc;
    private PrintWriter pw;
    private final Connection conn;

    private String threadName;
    private int threadID;
    private int currentTableID;
    private int currentTaskID;

    private String rawInput;

    private ArrayList<String> inDatas = new ArrayList<>();
    private ArrayList<String> outDatas = new ArrayList<>();

    public ClientThread(Socket s, Connection conn) {
        this.s = s;
        this.conn = conn;

        System.out.println("A new thread has started..");
    }

    @Override
    public void run() {
        try {
            sc = new Scanner(s.getInputStream());
            pw = new PrintWriter(s.getOutputStream(), true);

            communicationWithClients(pw, sc);
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
            System.out.println("Output: " + outDatas);

            index++;
            System.out.println("Kérés vége.");
        }
    }

    private void inputPreprocess(String input) {
        String withoutBrackets = input.replaceAll("[\\[\\]]", "");
        rawInput = withoutBrackets;

        String[] string = withoutBrackets.split(", ");
        inDatas.addAll(Arrays.asList(string));
    System.out.println("Input: " + inDatas);
    }

    private ArrayList<String> controller(ArrayList<String> in) {
        ArrayList<String> out = new ArrayList<>();
        String answer;
        String identifier = in.get(0);
        String filename;
        boolean newtable;
        //feladatok elosztása
        switch (identifier) {
            case "log:": //log in
                answer = Boolean.toString(validateClient(in));

                out.add(identifier);
                out.add(answer);
                break;
            case "reg:": //registration
                answer = Boolean.toString(regClient(in));

                out.add(identifier);
                out.add(answer);
                break;
            case "csv:": //csv upload on load page
                String taskname = in.get(1).replaceAll(":", "");
                System.out.println("Taskname:: " + taskname);
                int task = insertTaskIntoDatabase(taskname);
                System.out.println("Task: " + task);
              //IsTaskNameValid() értéke kell még ide.
                    currentTaskID = task;
                    filename = in.get(2).replaceAll(":", "");
                    answer = Boolean.toString(insertTableIntoDatabase(filename));

                    out.add(identifier);
                    out.add(answer);
                    out.add(Integer.toString(currentTaskID));
                    writeToCsv(filename);
                
                break;
            case "wcsv:": //csv upload on work page
                filename = in.get(2).replaceAll(":", "");
                currentTaskID = Integer.parseInt(in.get(1).replaceAll(":", ""));
                if(insertTableIntoDatabase(filename)){
                    out = getTasksTable();
                    writeToCsv(filename);
                }else{
                    out.add("err:");
                }
                break;
            case "wrk:": //old task loading 
                out = getTasks();
                break;
            case "old:": //old tables loading
                currentTaskID = Integer.parseInt(in.get(1));
                out = getTasksTable();
                System.out.println("OLD: " + out);
                break;
            case "ldt:": //chosen table loading
                currentTaskID = Integer.parseInt(in.get(1));
                out = readFromCsv("ldt:",in.get(2), true);
                break;
            case "fact:": //factorize
                currentTaskID = Integer.parseInt(in.get(2));
                newtable = Boolean.valueOf(in.get(1));
                
                answer = callingPython(newtable, "factorize.py", in.get(3));
                modifyIsFactorizedInTables(in.get(3));
                out = readFromCsv("done:", answer, true);
                break;
            case "norm:": //normalize
                currentTaskID = Integer.parseInt(in.get(2));
                newtable = Boolean.valueOf(in.get(1));
                
                answer = callingPython(newtable, "normalize.py", in.get(3));
                modifyIsNormalisedInTables(in.get(3));
                out = readFromCsv("done:", answer, true);
                break;
            case "ftsl:": //feature selection
                currentTaskID = Integer.parseInt(in.get(2));
                newtable = Boolean.valueOf(in.get(1));
                
                answer = callingPython(newtable, "variance.py", in.get(3));
                modifyIsFeatureSelectedInTables(in.get(3));
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
                setTaskInactive(in.get(1));
                out = getTasks();
                break;
            case "delt:": //delete tables
                setTableInactive(in.get(1), in.get(2));
                out = getTasksTable("delt:");
                break;
            case "tdl:": //table download
                currentTaskID = Integer.parseInt(in.get(1));
                out = readFromCsv("tdl:", in.get(2), false);
                break;
            case "bye:": //log out
                setIsOnlineFalse();
                setLogStatusNormal();
                out.add("bye:");
                break;
            default:
                break;
        }
        return out;
    }

    private String parametersToString(ArrayList<String> in){
        StringBuilder sb = new StringBuilder();
        
        for(int i=4; i<in.size(); i++){
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
        File file = new File(PATH + getTaskName() +"\\"+filename);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            csv.add(line);
            csv.add(">>first_line_end_flag<<"); 
            int index=0;
            boolean loopcond;
            if(preview){
                loopcond = index<500/2;
            }else{
                loopcond = line != null;
            }
            
            while (loopcond) {
                line = br.readLine();
                index++;
                if (line == null) {
                    break;
                } else {
                    csv.add(line);
                    csv.add(">>enter_flag<<");
                }
            }
        } catch (IOException ex) {
            System.out.println("File not found.");
        }
        return csv;
    }

    private void writeToCsv(String filename) {
         new File(PATH+getTaskName()).mkdir();
         
        String fullFilepath = PATH + getTaskName() + "\\"+ filename;
        System.out.println("Fullpath: " + fullFilepath);
        
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(fullFilepath);
            bw = new BufferedWriter(fw);
            
            //System.out.println("raw: " + rawInput);
            String lines = rawInput.split(":, ")[3];
            
            String line = lines.replaceAll(", >>flag<<, ", "\n").replaceAll(", >>flag<<", "");
            bw.write(line);
            System.out.println("Done with file writing");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println("Error closing bw and fw");
            }
        }

    }

    // DATABASE FUNCTIONS
    // <editor-fold defaultstate="collapsed">
    private boolean validateClient(ArrayList<String> acceptedDatas) { //unknown helyette false kell.
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
                boolean is_online = rs.getBoolean("IS_ONLINE");
                String log_status = rs.getString("LOG_STATUS");
              
                //nem jó.
                if ((pass.equals(password))){// && !is_online) || (pass.equals(password) && "null".equals(log_status))) {
                    threadName = name;
                    threadID = rs.getInt("USER_ID");
                                      
                   String updateQuery = "update users set is_online='"+true+"', log_status = '"+"null"+"' where user_id='"+threadID+"';";
                    Statement updateStat = conn.createStatement();
                    updateStat.executeUpdate(updateQuery);
                    PATH = PATH+threadName+"\\";
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
                    PreparedStatement prepstat = conn.prepareStatement(insertquery);
                    prepstat.setInt(1, id++);
                    prepstat.setString(2, name);
                    prepstat.setString(3, mail);
                    prepstat.setString(4, pass);
                    prepstat.setBoolean(5, false);
                    prepstat.setString(6,"null");
                    prepstat.addBatch();

                    conn.setAutoCommit(false);
                    prepstat.executeBatch();
                    conn.setAutoCommit(true);

                } catch (SQLException ex) {
                    System.out.println("Nem sikerült felvinni az adatokat.");
                }
                new File(PATH+threadName).mkdir();
                System.out.println(threadName + " nevű mappa elkészítve.");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error: ClientThread regClient");
        }
        return false;
    }

    private int insertTaskIntoDatabase(String taskname){
        int returnvalue=0;
        try{
            String insertQuery = "insert into tasks values (?,?,?,?);";
            PreparedStatement prep = conn.prepareStatement(insertQuery);
            
            int id = getTaskID();
            prep.setInt(1, id);
            prep.setString(2, taskname);
            prep.setInt(3, threadID);
            prep.setBoolean(4, true);
            
           if(isTaskNameValid(taskname)){
               System.out.println("Taskname is valid.");
               prep.addBatch();
               conn.setAutoCommit(false);
               prep.executeBatch();
               conn.setAutoCommit(true);
               returnvalue = id;
           }else{
               returnvalue = -1;
           }
            System.out.println("Task bejegyezve: "+returnvalue+" számmal.");
        }catch(SQLException e){
            
        }        
        return returnvalue;
    }
    
    private boolean isTaskNameValid(String taskname){
        boolean returnvalue=true;
        try {
            Statement stat = conn.createStatement();
            String query = "select task_name from tasks where user_id = '"+threadID+"';";
            ResultSet rs = stat.executeQuery(query);
            while(rs.next()){
                String dbtask = rs.getString("TASK_NAME");
                if(taskname.equals(dbtask)){
                    returnvalue = false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnvalue;
    }
    
    private int getTaskID(){
        int returnvalue = 1;
        try {
            ResultSet maxIDrs;

            Statement maxID = conn.createStatement();
            String maxIDquery = "select nvl(max(task_id),0) from tasks;";
            maxIDrs = maxID.executeQuery(maxIDquery);

            if (maxIDrs.next()) {
                returnvalue = maxIDrs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error: Getting task_id");
        }
        return ++returnvalue;
    }
    
    private String getTaskName(){
        String returnvalue="";
        try {
            String query = "select task_name from tasks where task_id = '"+currentTaskID+"';";
            Statement stat = conn.createStatement();
            
            ResultSet rs = stat.executeQuery(query);
            while(rs.next()){
                returnvalue = rs.getString("TASK_NAME");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnvalue;
    }
    
    private boolean insertTableIntoDatabase(String filename) { 
        boolean returnvalue = false;
        try {
            String insertQuery = "insert into tables values (?,?,?,?,?,?,?,?,?);";
            PreparedStatement prep = conn.prepareStatement(insertQuery);
            currentTableID= getTableID();
            prep.setInt(1, currentTableID);
            prep.setInt(2, threadID);
            prep.setString(3, filename);
            prep.setBoolean(4, false);
            prep.setBoolean(5, false);
            prep.setBoolean(6, false);
            prep.setBoolean(7, false);
            prep.setBoolean(8, true);
            prep.setInt(9, currentTaskID);
            
            if(!isTableInTask(filename)){
                prep.addBatch();

                conn.setAutoCommit(false);
                prep.executeBatch();
                conn.setAutoCommit(true);
                returnvalue = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error inserting to database");
        }
        return returnvalue;
    }
    
    private boolean isTableInTask(String tablename) throws SQLException{
        boolean returnvalue = false;
        
        Statement stat = conn.createStatement();
        String query = "select name from tables where user_id = '"+threadID+"'  and task_id = '"+currentTaskID+"';";
       
        ResultSet rs = stat.executeQuery(query);
        while(rs.next()){
            String name = rs.getString("NAME");
            
            if(tablename.equals(name)){
                returnvalue = true;
            }
        }
        return returnvalue;
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
            System.out.println("ID: " + returnvalue);
        } catch (SQLException ex) {
            System.out.println("Error: Getting table_id");
        }
        return ++returnvalue;
    }

    private boolean setTaskInactive(String taskID){
        boolean returnvalue=true;
        try {
            int id = Integer.parseInt(taskID);
            Statement stat = conn.createStatement();
            String query = "update tasks set is_active = false where task_id = '"+id+"';";            
            stat.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnvalue;
    }
    
    private boolean setTableInactive(String task_id, String table_name){
        boolean returnvalue=true;
        try {
            int id = Integer.parseInt(task_id);
            Statement stat = conn.createStatement();
            String query = "update tables set is_active = false, name = '"+"CB_deleted_table"+"' where name = '"+table_name+"' and task_id = '"+id+"';";            
            stat.executeUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnvalue;
    }
    
    private ArrayList<String> getTasksTable(String... other) {
        ArrayList<String> returnvalue = new ArrayList<>();
        if(other.length == 0){
            returnvalue.add("old:");
        }else{
            returnvalue.add(Arrays.toString(other));
        }

        try {
            Statement stat = conn.createStatement();
            String query = "select name from tables where user_id='" + threadID + "' and task_id='"+currentTaskID+"' and is_active= true;";
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                returnvalue.add(rs.getString("NAME"));
            }

        } catch (SQLException ex) {
            System.out.println("Error: load old works");
        }

        return returnvalue;
    }
    
    private ArrayList<String> getTasks(){
        ArrayList<String> returnvalue = new ArrayList<>();
        returnvalue.add("wrk:");
        
        try{
            Statement stat =  conn.createStatement();
            String query = "select task_id, task_name from tasks where user_id='"+threadID+"' and is_active = true;";
            ResultSet rs = stat.executeQuery(query);
            
            while(rs.next()){
                returnvalue.add(Integer.toString(rs.getInt("TASK_ID")));
                returnvalue.add(rs.getString("TASK_NAME"));
            }
            
        }catch(SQLException e){
            System.out.println("Error: load tasks");
        }
        return returnvalue;
    }
    
    private void setIsOnlineFalse(){
        try{
            String updateQuery = "update users set is_online='"+false+"'where user_id = '"+threadID+"';";
            Statement updateStat = conn.createStatement();
            updateStat.executeUpdate(updateQuery);
        }catch(SQLException e){
            System.out.println("Error: logout client");
        }
    }
    
    private void setLogStatusNormal(){
        try{
            String updateQuery = "update users set log_status='"+"normal"+"' where user_id = '"+threadID+"';";
            Statement updateStat = conn.createStatement();
            updateStat.executeUpdate(updateQuery);
        }catch(SQLException e){
            System.out.println("Error: logout client");
        }
    }
           
    private void modifyIsClassifiedInTables(String tablename) {
        try{
            Statement updateStat =  conn.createStatement();
            String updateQuery = "update tables set is_classified = true where name ='"+tablename+"' and task_id = '"+currentTaskID+"'; ";
            updateStat.executeUpdate(updateQuery);
        }catch (SQLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void modifyIsFactorizedInTables(String tablename) {
        try {
            Statement updateStat =  conn.createStatement();
            String updateQuery = "update tables set is_factorized = true where name ='"+tablename+"' and task_id = '"+currentTaskID+"'; ";
            updateStat.executeUpdate(updateQuery);
        } catch (SQLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modifyIsNormalisedInTables(String tablename) {
        try{
            Statement updateStat = conn.createStatement();
            String updateQuery = "update tables set is_normalized = true where name ='"+tablename+"' and task_id = '"+currentTaskID+"';";
            updateStat.executeUpdate(updateQuery);
        }catch(SQLException ex){
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modifyIsFeatureSelectedInTables(String tablename) {
        try{
            Statement updateStat = conn.createStatement();
            String updateQuery = "update tables set is_feautre_selected = true where name = '"+tablename+"' and task_id = '"+currentTaskID+"';";
            updateStat.executeUpdate(updateQuery);
        }catch(SQLException ex){
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // </editor-fold>
    
    private String callingPython(Boolean newtable, String py, String file, String... other){
        System.out.println("Python file: " + file);
        String returnvalue=file;
        String string=Arrays.toString(other).replaceAll("[\\[\\]]", "").replaceAll("\\t", " ");
        
        String cmd = "python "+PY_PATH+py +" "+newtable+" "+PATH+getTaskName()+"\\"+file+" "+string+"";
        System.out.println("cmdl: " + cmd);
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            int exitVal = p.waitFor();
            if(exitVal==0){
                System.out.println("Python script completed successfully.");
            }else{
                System.out.println("Python script finished with an error.");
            }
            
            if(newtable && exitVal == 0){
                String newtablename = prefixedTableName(py, file);
                insertTableIntoDatabase(newtablename);
                returnvalue = newtablename;
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnvalue;
    }

    private String prefixedTableName(String python, String file){
        String prefix = python.replaceAll(".py", "_");
        String fullfilename = prefix+file;
        System.out.println("Full: " + fullfilename);
        return fullfilename;
    }
}