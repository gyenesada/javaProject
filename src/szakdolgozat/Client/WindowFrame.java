package szakdolgozat.Client;

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

public class WindowFrame extends javax.swing.JFrame implements Runnable {

   // static WFController wfc=null;
    
    private Socket socket;
    private Scanner sc;
    private PrintWriter pw;
    
    private final  String host;
    private final int port;

    private static ArrayList<String> inDatas = new ArrayList<>();
    private static ArrayList<String> outDatas = new ArrayList<>();

    public WindowFrame() throws IOException {
        this.host = "localhost";
        this.port = 2018;
        initComponents();
        
        this.setTitle("CloudBased classifier - Login");
        this.setResizable(false);
    }

    //INIT COMPONENTS
    // <editor-fold defaultstate="collapsed">
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        mainPanel = new javax.swing.JPanel();
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
        regPassLabel = new javax.swing.JLabel();
        regPassField = new javax.swing.JPasswordField();
        regMailLabel = new javax.swing.JLabel();
        regMailField = new javax.swing.JTextField();
        regDoButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new java.awt.CardLayout());

        loginPanel.setPreferredSize(new java.awt.Dimension(500, 500));

        logLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        logLabel.setForeground(new java.awt.Color(102, 102, 102));
        logLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logLabel.setText("Bejelentkezés");

        nameLabel.setText("Felhasználónév");

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
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(logLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(loginPanelLayout.createSequentialGroup()
                                                        .addComponent(logButton)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(regButton))
                                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passLabel)
                                                        .addComponent(nameLabel)
                                                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(288, 288, 288))
        );
        loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(logLabel)
                                .addGap(25, 25, 25)
                                .addComponent(nameLabel)
                                .addGap(18, 18, 18)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(logButton)
                                        .addComponent(regButton))
                                .addContainerGap(89, Short.MAX_VALUE))
        );

        mainPanel.add(loginPanel, "card2");

        regLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        regLabel.setForeground(new java.awt.Color(102, 102, 102));
        regLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        regLabel.setText("Regisztráció");

        regNameLabel.setText("Felhasználónév");

        regPassLabel.setText("Jelszó");

        regMailLabel.setText("E-mail cím");

        regDoButton.setText("Regisztráció");
        regDoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regDoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout regPanelLayout = new javax.swing.GroupLayout(regPanel);
        regPanel.setLayout(regPanelLayout);
        regPanelLayout.setHorizontalGroup(
                regPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(regPanelLayout.createSequentialGroup()
                                .addGap(316, 316, 316)
                                .addGroup(regPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(regPanelLayout.createSequentialGroup()
                                                .addComponent(regNameLabel)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(regPanelLayout.createSequentialGroup()
                                                .addGroup(regPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(regPassField)
                                                        .addComponent(regNameField)
                                                        .addComponent(regLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(regMailLabel)
                                                        .addComponent(regPassLabel)
                                                        .addComponent(regMailField))
                                                .addGap(326, 326, 326))))
                        .addGroup(regPanelLayout.createSequentialGroup()
                                .addGap(363, 363, 363)
                                .addComponent(regDoButton)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        regPanelLayout.setVerticalGroup(
                regPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(regPanelLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(regLabel)
                                .addGap(18, 18, 18)
                                .addComponent(regNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(regNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(regMailLabel)
                                .addGap(9, 9, 9)
                                .addComponent(regMailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(regPassLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(regPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(regDoButton)
                                .addContainerGap(43, Short.MAX_VALUE))
        );

        mainPanel.add(regPanel, "card2");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
        );

        pack();
    }

    // </editor-fold>
    private void logButtonActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    private void regButtonActionPerformed(java.awt.event.ActionEvent evt) {
        loginPanel.setVisible(false);
        regPanel.setVisible(true);
    }

    private void regDoButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            outDatas.clear();
            String username = regNameField.getText();
            String mail = regMailField.getText();
            String password = encrypt(regPassField.getText()); //kell encrypt
            outDatas.add("reg:");
            outDatas.add(username);
            outDatas.add(mail);
            outDatas.add(password);
            
//            wfc.getOutDatas(outDatas);

            System.out.println("outDatas: " + outDatas);
        } catch (Exception ex) {
            System.out.println("Error: regDoButton");
        }
    }

    private static String encrypt(String pass) throws Exception {
        java.security.MessageDigest d = java.security.MessageDigest.getInstance("MD5");
        d.reset();
        d.update(pass.getBytes());
        d.digest();
        return new String(d.digest(), StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws Exception {
//        wfc = new WFController("localhost", 2017);
  //      wfc.run();
  WindowFrame wf = new WindowFrame();
  wf.setVisible(true);
  wf.run();
        //windowframe.run();
    }

    @Override
    public void run() {
        try {
            socket = new Socket(host, port);
            sc = new Scanner(socket.getInputStream());
            pw = new PrintWriter(socket.getOutputStream(), true);

            communicationWithServer(pw, sc);
        } catch (IOException e) {
            System.out.println("Error: Windowframe run");
        }
    }
    

    
    private void communicationWithServer(PrintWriter pw, Scanner sc) { //ez kell majd a WorkWindowFrame-be is.
        int index = 0;
        while (true) {
            System.out.println("---------------" + index + "--------------");
            System.out.println("");
            pw.println(outDatas);
            outDatas.clear();
            System.out.println("Output: " + outDatas);
            inDatas.clear();
            inputPreprocess(sc.nextLine());
            if (!inDatas.isEmpty()) {
                outDatas = controller(inDatas);
            }
            System.out.println("Input: " + inDatas);
            index++;
        }
    }

    private ArrayList<String> controller(ArrayList<String> in) { //Kell a WorkWindowFrame-be is.
        ArrayList<String> out = new ArrayList<>();

        String answer = "";
        String identifier = in.get(0);

        switch (identifier) {
            case "log:":
                if (Boolean.valueOf(in.get(1))) {
                    try {
                        String username = nameField.getText();
                        WorkWindowFrame wwf = new WorkWindowFrame(pw, sc, username);
                        System.out.println("Username: " + username);

                        wwf.setVisible(true);
                        wwf.run();
                        this.dispose();
                    } catch (Exception ex) {
                        Logger.getLogger(WindowFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    nameField.setText("");
                    passField.setText("");
                    JOptionPane.showMessageDialog(this, "sikertelen");
                }
                break;
            case "reg:":
                if (Boolean.valueOf(in.get(1))) {
                    JOptionPane.showMessageDialog(this, "sikeres regisztráció");
                    loginPanel.setVisible(true);
                    regPanel.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "sikertelen regisztráció.");

                    regNameField.setText("");
                    regMailField.setText("");
                    regPassField.setText("");
                }
                break;
        }
        return out;
    }
    
    //ez módosítja a communication fv while() argumentumát.

    
    private void inputPreprocess(String input) {
        System.out.println("input: " + input);
        String withoutBrackets = input.replaceAll("[\\[\\]]", "");

        String[] string = withoutBrackets.split(", ");
        inDatas.addAll(Arrays.asList(string));
        System.out.println("Input: " + inDatas);
    }

    //VARIABLES
    // <editor-fold defaultstate="collapsed">
        protected javax.swing.JComboBox<String> jComboBox1;
        protected javax.swing.JMenu jMenu1;
        protected javax.swing.JMenu jMenu2;
        protected javax.swing.JMenuBar jMenuBar1;
        protected javax.swing.JButton logButton;
        protected javax.swing.JLabel logLabel;
        protected javax.swing.JPanel loginPanel;
        protected javax.swing.JPanel mainPanel;
        protected javax.swing.JTextField nameField;
        protected javax.swing.JLabel nameLabel;
        protected javax.swing.JPasswordField passField;
        protected javax.swing.JLabel passLabel;
        protected javax.swing.JButton regButton;
        protected javax.swing.JButton regDoButton;
        protected javax.swing.JLabel regLabel;
        protected javax.swing.JTextField regMailField;
        protected javax.swing.JLabel regMailLabel;
        protected javax.swing.JTextField regNameField;
        protected javax.swing.JLabel regNameLabel;
        protected javax.swing.JPanel regPanel;
        protected javax.swing.JPasswordField regPassField;
        protected javax.swing.JLabel regPassLabel;
    
    // </editor-fold >
}
