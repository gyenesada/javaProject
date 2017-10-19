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

    private Socket socket;
    private Scanner sc;
    private PrintWriter pw;

    private final String host;
    private final int port;
    private String rawInput;

    private static MainWindowFrame wf; //felület

    public MWFController() throws IOException {
        this.host = "localhost";
        this.port = 2018;
        
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
            JOptionPane.showMessageDialog(wf, "A szerver kapcsolat nem aktív. Kérjük próbálja később.");
        }
    }

    private void communicationWithServer(PrintWriter pw, Scanner sc) { //ez kell majd a WorkWindowFrame-be is.
        int index = 0;
        while (!wf.exit) {

            System.out.println("---------------" + index + "--------------");
            while (wf.outDatas.isEmpty()) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(WorkWindowFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            pw.println(wf.outDatas);
            wf.inDatas.clear();
            rawInput = sc.nextLine();
            inputPreprocess(rawInput);
            if (!wf.inDatas.isEmpty()) {
                wf.outDatas = controller(wf.inDatas);
            }
            System.out.println("Input: " + wf.inDatas);
            index++;

        }
    }

    private ArrayList<String> controller(ArrayList<String> in) { //Kell a WorkWindowFrame-be is.
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
                        JOptionPane.showMessageDialog(wf, "A szerver kapcsolat nem aktív. Kérjük próbálja később.");
                    }
                } else {
                    wf.nameField.setText("");
                    wf.passField.setText("");
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

                    wf.regNameField.setText("");
                    wf.regPassField.setText("");
                    wf.regMailField.setText("");
                }
                break;
        }
        return out;
    }

    private void inputPreprocess(String input) {
        System.out.println("input: " + input);
        String withoutBrackets = input.replaceAll("[\\[\\]]", "");

        String[] string = withoutBrackets.split(", ");
        wf.inDatas.addAll(Arrays.asList(string));
        System.out.println("Input: " + wf.inDatas);
    }

}
