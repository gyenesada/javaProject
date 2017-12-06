package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
            System.out.println("The server is up on port " + port);
            System.out.println("To shut down, use [CRTL] + [C].");
            while (true) {
                Socket socket = ss.accept();
                Connection conn = connectToDatabase();
                service.submit(new ClientThread(socket, conn));
            }
        } catch (Exception ex) {
        }

    }

    private static Connection connectToDatabase() throws Exception {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/db", "SA", "");
        System.out.println("Connected to database server.");
        return connection;
    }

    public static void main(String[] args) {
        String cmd = "java -classpath ./gyenesadrienn/hsqldb/lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:hsqldb/db --dbname.0 db";
        try {
            System.out.println("Connect to database server...");
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ex) {
            System.out.println("Database server can't start. ");
        }
        System.out.println("Connected on port 9001");
        new Server(2222).run();
    }
}
