

package szakdolgozat.Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import szakdolgozat.Client.FileManager;

/*
    Ez az osztály készen van.
*/
public class Server implements Runnable {

    private final int port;

    public Server(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            final ExecutorService service = Executors.newCachedThreadPool();
            ServerSocket ss = new ServerSocket(port);

            while (true) {
                Socket socket = ss.accept();
                Connection conn = connectToDatabase();
                service.submit(new ClientThread(socket, conn));
                System.out.println("The server is up..");
            }
        } catch (Exception ex) {
             Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static Connection connectToDatabase() throws Exception {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/db", "SA", "");
        System.out.println("Connected to database server.");
        return connection;
    }

    public static void main(String[] args) {
        new Server(1995).run();
    }
}
