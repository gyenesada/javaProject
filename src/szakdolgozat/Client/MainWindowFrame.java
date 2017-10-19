package szakdolgozat.Client;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MainWindowFrame extends javax.swing.JFrame implements Runnable {

    private Socket socket;
    private Scanner sc;
    private PrintWriter pw;

    private boolean exit = false;

    private final String host;
    private final int port;
    private String rawInput;

    private static ArrayList<String> inDatas = new ArrayList<>();
    private static ArrayList<String> outDatas = new ArrayList<>();

    public MainWindowFrame() throws IOException {
        this.host = "localhost";
        this.port = 2018;
        initComponents();

        setTitle("CloudBased classifier - Login");
        setResizable(false);
        addExitOption();
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        logLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();
        logButton = new javax.swing.JButton();
        regButton = new javax.swing.JButton();
        regPanel = new javax.swing.JPanel();
        regLabel = new javax.swing.JLabel();
        regNameLabel = new javax.swing.JLabel();
        regNameField = new javax.swing.JTextField();
        regMailLabel = new javax.swing.JLabel();
        regMailField = new javax.swing.JTextField();
        regPassLabel = new javax.swing.JLabel();
        regPassField = new javax.swing.JPasswordField();
        regDoButton = new javax.swing.JButton();
        regCancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        logLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        logLabel.setForeground(new java.awt.Color(102, 102, 102));
        logLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logLabel.setText("Bejelentkezés");

        nameLabel.setText("Felhasználónév");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        passLabel.setText("Jelszó");

        logButton.setText("Bejelentkezés");
        logButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logButtonActionPerformed(evt);
            }
        });

        regButton.setText("Regisztráció");
        regButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addComponent(logButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(regButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(passLabel)
                    .addComponent(nameLabel)
                    .addComponent(passField)
                    .addComponent(nameField))
                .addGap(78, 78, 78))
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(logLabel)
                .addGap(36, 36, 36)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logButton)
                    .addComponent(regButton))
                .addGap(54, 54, 54))
        );

        getContentPane().add(loginPanel, "card2");

        regLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        regLabel.setForeground(new java.awt.Color(102, 102, 102));
        regLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        regLabel.setText("Regisztráció");

        regNameLabel.setText("Felhasználónév");

        regMailLabel.setText("E-mail cím");

        regPassLabel.setText("Jelszó");

        regDoButton.setText("Regisztráció");
        regDoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regDoButtonActionPerformed(evt);
            }
        });

        regCancelButton.setText("Mégsem");
        regCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regCancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout regPanelLayout = new javax.swing.GroupLayout(regPanel);
        regPanel.setLayout(regPanelLayout);
        regPanelLayout.setHorizontalGroup(
            regPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(regLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, regPanelLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(regPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(regPassLabel)
                    .addGroup(regPanelLayout.createSequentialGroup()
                        .addComponent(regDoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(regCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(regMailLabel)
                    .addComponent(regNameLabel)
                    .addComponent(regPassField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(regMailField)
                    .addComponent(regNameField))
                .addGap(78, 78, 78))
        );
        regPanelLayout.setVerticalGroup(
            regPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(regPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(regLabel)
                .addGap(16, 16, 16)
                .addComponent(regNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regMailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regMailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regPassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(regPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regDoButton)
                    .addComponent(regCancelButton))
                .addGap(54, 54, 54))
        );

        getContentPane().add(regPanel, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void logButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logButtonActionPerformed
        try {
            outDatas.clear();
            String username = nameField.getText();
            String password = encrypt(passField.getText());
            outDatas.add("log:");
            outDatas.add(username);
            outDatas.add(password);

            //wfc.getOutDatas(outDatas);
            System.out.println("outDatas: " + outDatas);
        } catch (Exception ex) {
            System.out.println("Error: logButton");
        }
    }//GEN-LAST:event_logButtonActionPerformed

    private void regButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regButtonActionPerformed
        regPanel.setVisible(true);
        loginPanel.setVisible(false);
    }//GEN-LAST:event_regButtonActionPerformed

    private void regCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regCancelButtonActionPerformed
        regNameField.setText("");
        regPassField.setText("");
        regMailField.setText("");

        regPanel.setVisible(false);
        loginPanel.setVisible(true);
    }//GEN-LAST:event_regCancelButtonActionPerformed

    private void regDoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regDoButtonActionPerformed
        try {
            outDatas.clear();
            String username = regNameField.getText();
            String mail = regMailField.getText();
            String password = encrypt(regPassField.getText()); //kell encrypt
            outDatas.add("reg:");
            outDatas.add(username);
            outDatas.add(mail);
            outDatas.add(password);

            System.out.println("outDatas: " + outDatas);
        } catch (Exception ex) {
            System.out.println("Error: regDoButton");
        }
    }//GEN-LAST:event_regDoButtonActionPerformed

    private static String encrypt(String pass) throws Exception {
        java.security.MessageDigest d = java.security.MessageDigest.getInstance("MD5");
        d.reset();
        d.update(pass.getBytes());
        d.digest();
        return new String(d.digest(), StandardCharsets.UTF_8);
    }

        private void addExitOption() {
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "Biztos ki szeretnél lépni?",
                        "Kilépés", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    exit = true;
                    dispose();
                }
                if (n == JOptionPane.NO_OPTION) {
                    dispose();
                }
            }
        });
    }
    public static void main(String[] args) throws Exception {
        MainWindowFrame wf = new MainWindowFrame();
        wf.setVisible(true);
        wf.run();
    }

    @Override
    public void run() {
        try {
            socket = new Socket(host, port);
            sc = new Scanner(socket.getInputStream());
            pw = new PrintWriter(socket.getOutputStream(), true);

            communicationWithServer(pw, sc);
        } catch (IOException e) {

            JOptionPane.showMessageDialog(this, "A szerver kapcsolat nem aktív. Kérjük próbálja később.");
        }
    }

    private void communicationWithServer(PrintWriter pw, Scanner sc) { //ez kell majd a WorkWindowFrame-be is.
        int index = 0;
        while (!exit) {

            System.out.println("---------------" + index + "--------------");
            while (outDatas.isEmpty()) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(WorkWindowFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            pw.println(outDatas);
            inDatas.clear();
            rawInput = sc.nextLine();
            inputPreprocess(rawInput);
            if (!inDatas.isEmpty()) {
                outDatas = controller(inDatas);
            }
            System.out.println("Input: " + inDatas);
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
                        String username = nameField.getText();
                        WorkWindowFrame wwf = new WorkWindowFrame(pw, sc, username);
                        wwf.setVisible(true);
                        dispose();
                        wwf.run();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "A szerver kapcsolat nem aktív. Kérjük próbálja később.");
                    }
                } else {
                    nameField.setText("");
                    passField.setText("");
                    JOptionPane.showMessageDialog(this, "A bejelentkezés sikertelen. Ellenőrizze helyes adatokat adott-e meg.");
                }
                break;
            case "reg:":
                if (Boolean.valueOf(in.get(1))) {
                    JOptionPane.showMessageDialog(this, "Sikeres regisztráció.");
                    loginPanel.setVisible(true);
                    regPanel.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Sikertelen regisztráció. A felhasználónév/email már foglalt.");

                    regNameField.setText("");
                    regPassField.setText("");
                    regMailField.setText("");
                }
                break;
        }
        return out;
    }

    private void inputPreprocess(String input) {

        System.out.println("input: " + input);
        String withoutBrackets = input.replaceAll("[\\[\\]]", "");

        String[] string = withoutBrackets.split(", ");
        inDatas.addAll(Arrays.asList(string));
        System.out.println("Input: " + inDatas);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton logButton;
    private javax.swing.JLabel logLabel;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JButton regButton;
    private javax.swing.JButton regCancelButton;
    private javax.swing.JButton regDoButton;
    private javax.swing.JLabel regLabel;
    private javax.swing.JTextField regMailField;
    private javax.swing.JLabel regMailLabel;
    private javax.swing.JTextField regNameField;
    private javax.swing.JLabel regNameLabel;
    private javax.swing.JPanel regPanel;
    private javax.swing.JPasswordField regPassField;
    private javax.swing.JLabel regPassLabel;
    // End of variables declaration//GEN-END:variables
}
