package szakdolgozat.Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Ez az osztály hozza létre a portot, Serversocketet, és az adatbáziskapcsolatot. Innen minden kliens esetén egy új ClientThread jön létre. A kliensek kezelése ott zajlik.
*/

public class Server implements Runnable {
    private int port;
    
    public Server(int port){
        this.port=port;
    }
    
    @Override
    public void run(){
                try {
                    final ExecutorService service = Executors.newCachedThreadPool();
                    ServerSocket ss = new ServerSocket(port);
                    
            while(true){
                    Socket socket = ss.accept();
                    Connection conn=null;
                    
                    //Connection conn = connectToDatabase();
                    service.submit(new ClientThread(socket, conn));
                    System.out.println("The server is up..");
            }
                } catch (Exception ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            
}
    
     private static Connection connectToDatabase() throws Exception{
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/db", "SA", "");
        System.out.println("Connected to database server.");
        return connection;
    }
     
     public static void main(String[] args){
       new Server(00001).run();
    }
     
private class ClientThread implements Runnable{
    private final Socket s;
    private Scanner sc;
    private PrintWriter pw;
    private final Connection conn;
    
    private ArrayList<String> inDatas = new ArrayList<>();
    private ArrayList<String> outDatas = new ArrayList<>();

    ClientThread(Socket s, Connection conn){
        this.s = s;
        this.conn = conn;
        
        System.out.println("A new thread started..");
    }

    @Override
    public void run() {
        try{
            sc = new Scanner(s.getInputStream());
            pw = new PrintWriter(s.getOutputStream(), true);
            
            communicationWithClients(pw, sc);
        }catch(IOException e){
            System.out.println("Error: ClientThread run");
        }
    }

    public void communicationWithClients(PrintWriter pw, Scanner sc){
        while(true){ 
                    String input = sc.nextLine();
                    System.out.println("Input: " + input);
                    inDatas.add(input);
                outDatas.clear();
                outDatas.add("fo");
                pw.println(outDatas);
                System.out.println("Output: " + outDatas);
            }
    }

 
     // DATABASE FUNCTIONS
   // <editor-fold defaultstate="collapsed">
     private String validateClient(ArrayList<String> acceptedDatas){
        String name = acceptedDatas.get(0);
        String pass = acceptedDatas.get(1);
        Statement stat = null;
        ResultSet rs = null;
        
        try{
            stat = conn.createStatement();
            String query = "select password from users where username='"+name+"';";
            System.out.println(query);
            rs = stat.executeQuery(query); 
            System.out.println(rs);
            while(rs.next()){
                String password = rs.getString("PASSWORD");
                System.out.println("pass: " + password);
                System.out.println("password: " + pass);
                if(pass.equals(password)){
                    return "true";
                }
                else{
                    return "false";
                }
            }
            
        }catch(SQLException e){
            System.out.println("Error: SQL exception in validateClient() function");
        }
        return "unknown";
    }
     
  private void regClient(ArrayList<String> acceptedDatas){
        String name = acceptedDatas.get(0);
        String mail = acceptedDatas.get(1);
        String pass = acceptedDatas.get(2);
        int id=0;
        
        try {
            //elsőnek lekérdezzük, van-e ilyen nevű vagy mailcímű felhasználó. ha van, akkor false-t adok vissza.
            Statement stat = conn.createStatement();
            String listquery = "select * from users where username = '"+name+"' or mail='"+mail+"';";
            ResultSet rs = stat.executeQuery(listquery);
            if(!rs.next()){
                System.out.println("Már van ilyen felh. vagy mail.");
                //pw.println("false"); pw.flush();
            }else{
                Statement idstat = conn.createStatement();
                ResultSet idrs = idstat.executeQuery("select * from users;");
                
                while(rs.next()){
                    id++;
                }
                
                String insertquery = "insert into users values (?,?,?,?);";
                try {
                    PreparedStatement prepstat = conn.prepareStatement(insertquery);
                    prepstat.setInt(1, id++);
                    prepstat.setString(2, name);
                    prepstat.setString(3,mail);
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
    }
    // </editor-fold>
         
}
}
