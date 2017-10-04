package szakdolgozat.Server;

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

public class ClientThread implements Runnable {

    private final Socket s;
    private Scanner sc;
    private PrintWriter pw;
    private final Connection conn;

    private ArrayList<String> inDatas = new ArrayList<>();
    private ArrayList<String> outDatas = new ArrayList<>();

    ClientThread(Socket s, Connection conn) {
        this.s = s;
        this.conn = conn;

        System.out.println("A new thread started..");
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

    private  void communicationWithClients(PrintWriter pw, Scanner sc) {
        int index=0;
        while (true) {
            System.out.println("---------------" + index+ "--------------");
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

    //input adatok előfeldolgozása
    private void inputPreprocess(String input) {

        System.out.println("input: " + input);
        String withoutBrackets = input.replaceAll("[\\[\\]]", "");

        String[] string = withoutBrackets.split(", ");
        inDatas.addAll(Arrays.asList(string));
        System.out.println("Input: " + inDatas);
    }

    //Vezérlő kerül majd ide. Visszatérési értéke az outDatas
    private ArrayList<String> controller(ArrayList<String> in) {
        ArrayList<String> out = new ArrayList<>();
        String answer = "";
        String identifier = in.get(0);

        //feladatok elosztása
        switch (identifier) {
            case "log:":
                answer = validateClient(in); //lehet true, false, unkown
                System.out.println("answer: " + answer);
                break;
            case "reg:":
                answer = regClient(in);
                System.out.println("answer: " + answer);
                break;
            default:
                break;
        }
        out.add(identifier);out.add(answer);
        return out;
    }

    // DATABASE FUNCTIONS
    // <editor-fold defaultstate="collapsed">
    private String validateClient(ArrayList<String> acceptedDatas) {
        String name = acceptedDatas.get(1);
        String pass = acceptedDatas.get(2);
        Statement stat = null;
        ResultSet rs = null;

        try {
            stat = conn.createStatement();
            String query = "select password from users where username='" + name + "';";
            System.out.println(query);
            rs = stat.executeQuery(query);
            System.out.println(rs);
            while (rs.next()) {
                String password = rs.getString("PASSWORD");
                System.out.println("pass: " + password);
                System.out.println("password: " + pass);
                if (pass.equals(password)) {
                    return "true";
                } else {
                    return "false";
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: SQL exception in validateClient() function");
        }
        return "unknown";
    }

    private String regClient(ArrayList<String> acceptedDatas) { //String (egyenlőre), mert vissza kell adja h sikerült-e a reg vagy sem.
        String returnvalue = "";
        String name = acceptedDatas.get(1);
        String mail = acceptedDatas.get(2);
        String pass = acceptedDatas.get(3);
        int id = 0;

        try {
            //elsőnek lekérdezzük, van-e ilyen nevű vagy mailcímű felhasználó. ha van, akkor false-t adok vissza.
            Statement stat = conn.createStatement();
            String listquery = "select * from users where username = '" + name + "' or mail='" + mail + "';";
            ResultSet rs = stat.executeQuery(listquery);
            if (!rs.next()) {
                System.out.println("Már van ilyen felh. vagy mail.");
                //pw.println("false"); pw.flush();
            } else {
                Statement idstat = conn.createStatement();
                ResultSet idrs = idstat.executeQuery("select * from users;");

                while (rs.next()) {
                    id++;
                }

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
            }
        } catch (SQLException ex) {
            System.out.println("Error while registration");
        }
        return returnvalue;
    }
    // </editor-fold>

}
