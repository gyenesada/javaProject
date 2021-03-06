package szakdolgozat.Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MWFController implements Runnable {
    //This class is the controller side of the project. It contains the main settings of the server connections, and the communication and controlling methods.

    private Socket socket;
    private Scanner sc;
    private PrintWriter pw;

    private final String host;
    private final int port;
    private String rawInput;

    private static MainWindowFrame wf;

    public MWFController() throws IOException {
        this.host = "157.181.176.130";
        this.port = 2222;
        
        wf = new MainWindowFrame();
        wf.setVisible(true);
    }

    @Override
    public void run() {
        try {
            socket = new Socket(host, port);
            sc = new Scanner(socket.getInputStream());
            pw = new PrintWriter(socket.getOutputStream(), true);

            communicationWithServer(pw, sc);
        } catch (IOException e) {
            Logger.getLogger(WorkWindowFrame.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "A szerver kapcsolat nem aktív. Kérjük próbálja később.");
            wf.dispose();
        }
    }

    private void communicationWithServer(PrintWriter pw, Scanner sc) { 
        while(true){
            while (wf.model.outDatas.isEmpty()) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(WorkWindowFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            pw.println(wf.model.outDatas);
            wf.model.inDatas.clear();
            rawInput = sc.nextLine();
            inputPreprocess(rawInput);
            if (!wf.model.inDatas.isEmpty()) {
                wf.model.outDatas = controller(wf.model.inDatas);
            }
        }
    }

    private ArrayList<String> controller(ArrayList<String> in) { 
        ArrayList<String> out = new ArrayList<>();

        String identifier = in.get(0);

        switch (identifier) {
            case "log:":
                if (Boolean.valueOf(in.get(1))) {
                    try {
                        String username = wf.nameField.getText();
                        WWFController wwf = new WWFController(pw, sc, username);
                        wf.dispose();
                        wwf.run();
                    } catch (Exception ex) {
                        Logger.getLogger(WorkWindowFrame.class.getName()).log(Level.SEVERE, null, ex);
                       
                       JOptionPane.showMessageDialog(null, "A szerver kapcsolat nem aktív. Kérjük próbálja később.");
                       wf.dispose();
                    }
                } else {
                    wf.model.setDefaultJTextField(wf.nameField, wf.passField);
                    JOptionPane.showMessageDialog(wf, "A bejelentkezés sikertelen. Ellenőrizze helyes adatokat adott-e meg.");
                }
                break;
            case "reg:":
                if (Boolean.valueOf(in.get(1))) {
                    JOptionPane.showMessageDialog(wf, "Sikeres regisztráció.");
                    wf.loginPanel.setVisible(true);
                    wf.regPanel.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(wf, "Sikertelen regisztráció. A felhasználónév/email már foglalt.");
                    wf.model.setDefaultJTextField(wf.regNameField, wf.regPassField, wf.regMailField);
                }
                break;
        }
        return out;
    }

    private void inputPreprocess(String input) {
        String withoutBrackets = input.replaceAll("[\\[\\]]", "");

        String[] string = withoutBrackets.split(", ");
        wf.model.inDatas.addAll(Arrays.asList(string));
    }
    
}
