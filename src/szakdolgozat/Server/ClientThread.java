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
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientThread implements Runnable {

    private final Socket s;
    private Scanner sc;
    private PrintWriter pw;
    private final Connection conn;

    String PATH = "C:\\Users\\Adrienn\\Desktop\\szerver minitárhely\\csv\\";

    private String threadName;
    private int threadID;

    private String rawInput;

    private ArrayList<String> inDatas = new ArrayList<>();
    private ArrayList<String> outDatas = new ArrayList<>();

    ClientThread(Socket s, Connection conn) {
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
            System.out.println("---------------" + index + "--------------");
            System.out.println("");
            outDatas.clear();
            inputPreprocess(sc.nextLine());
            outDatas = controller(inDatas);
            inDatas.clear();
            pw.println(outDatas);
            System.out.println("Output: " + outDatas);

            index++;
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
        String answer = "";
        String identifier = in.get(0);

        //feladatok elosztása
        switch (identifier) {
            case "log:":
                answer = Boolean.toString(validateClient(in));

                out.add(identifier);
                out.add(answer);
                break;
            case "reg:":
                answer = Boolean.toString(regClient(in));

                out.add(identifier);
                out.add(answer);
                break;
            case "csv:":
                String filename = in.get(1).replaceAll(":", "");
                answer = Boolean.toString(insertTableIntoDatabase(filename));

                out.add(identifier);
                out.add(answer);
                writeToCsv(filename);
                break;
            case "old:":
                out = getOldWorksFromTables();
                break;
            case "ldt:":
                out = readFromCsv(in.get(1));
                break;
            default:
                break;
        }
        return out;
    }

    private ArrayList<String> readFromCsv(String filename) {
        ArrayList<String> csv = new ArrayList<>();
        csv.add("ldt:");
        System.out.println("LDT:");
        File file = new File(PATH + filename);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            csv.add(line);
            csv.add(">>first_line_end_flag<<"); //első sor végét jelzi.
            while (line != null) {
                line = br.readLine();

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
        String path = PATH; //kell majd username folder
        String fullFilepath = path + filename;

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(fullFilepath);
            bw = new BufferedWriter(fw);
            System.out.println("raw: " + rawInput);
            String withoutID = rawInput.split(":, ")[2];
            String[] lines;
            lines = withoutID.split(", >>enter_flag<<, ");
            for (String line : lines) {
                line = line.replaceAll(", >>enter_flag<<", "");

                bw.write(line);
                bw.newLine();
            }
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
            String query = "select password, user_id from users where username='" + name + "';";
            rs = stat.executeQuery(query);
            while (rs.next()) {
                String password = rs.getString("PASSWORD");
                if (pass.equals(password)) {
                    threadName = name;
                    threadID = rs.getInt("USER_ID");
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
        String returnvalue = "";
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
                Statement idstat = conn.createStatement();
                String insertquery = "insert into users values (?,?,?,?);";
                try {
                    PreparedStatement prepstat = conn.prepareStatement(insertquery);
                    prepstat.setInt(1, id++);
                    prepstat.setString(2, name);
                    prepstat.setString(3, mail);
                    prepstat.setString(4, pass);
                    prepstat.addBatch();

                    conn.setAutoCommit(false);
                    prepstat.executeBatch();
                    conn.setAutoCommit(true);

                } catch (SQLException ex) {
                    System.out.println("Nem sikerült felvinni az adatokat.");
                }
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error: ClientThread regClient");
        }
        return false;
    }

    private boolean insertTableIntoDatabase(String filename) { //ha full egyezés van, akkor ne illesszük be mégegyszer.
        boolean returnvalue = false;
        try {
            String insertQuery = "insert into tables values (?,?,?,?,?,?,?,?);";
            PreparedStatement prep = conn.prepareStatement(insertQuery);
            int id = getTableID();
            prep.setInt(1, id);
            prep.setInt(2, threadID);
            prep.setString(3, filename);
            prep.setBoolean(4, false);
            prep.setBoolean(5, false);
            prep.setBoolean(6, false);
            prep.setBoolean(7, false);
            prep.setDate(8, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            if (!(isTheTableAlreadyInDatabase(id, threadID, filename, false, false, false, false))) {
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

    private boolean isTheTableAlreadyInDatabase(int table_id, int user_id, String tablename, boolean isclassif, boolean isfact, boolean isnorm, boolean isfeatsel) throws SQLException {
        boolean returnvalue = false;
        String query = "select * from tables where name='" + tablename + "';";
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(query);
        while (rs.next()) {
            int tableID = rs.getInt("TABLE_ID");
            int userID = rs.getInt("USER_ID");
            String name = rs.getString("NAME");
            boolean isc = rs.getBoolean("IS_CLASSIFIED");
            boolean isf = rs.getBoolean("IS_FACTORIZED");
            boolean isn = rs.getBoolean("IS_NORMALIZED");
            boolean isfs = rs.getBoolean("IS_FEAUTRE_SELECTED");

            if (table_id == tableID && user_id == userID && name.equals(tablename) && isclassif == isc && isfact == isf && isnorm == isn && isfeatsel == isfs) {
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

    private ArrayList<String> getOldWorksFromTables() {
        ArrayList<String> returnvalue = new ArrayList<>();
        returnvalue.add("old:");

        try {
            Statement stat = conn.createStatement();
            String query = "select name, modified from tables where user_id='" + threadID + "';";
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                returnvalue.add(rs.getString("NAME"));
                returnvalue.add(rs.getDate("MODIFIED").toString());
            }

        } catch (SQLException ex) {
            System.out.println("Error: load old works");
        }

        return returnvalue;
    }

    private void modifyTimestamp(int id, String tablename) { //id: table or user_id  --nincs befejezve
        try {
            //tables és users tábla módosítás
            Statement stat = conn.createStatement();
            if (tablename.equals("users")) {
                String query = "select timestamp from users where user_id = '" + id + "' ;";

            } else if (tablename.equals("tables")) {
                String query = "select modified from tables where table_id = '" + id + "' ;";

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modifyIsClassifiedInTables() {

    }

    private void modifyIsFactorizedInTables() {

    }

    private void modifyIsNormalisedInTables() {

    }

    private void modifyIsFeatureSelectedInTables() {

    }
    // </editor-fold>
}
