package szakdolgozat.Client;

import java.awt.Toolkit;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class MainWindowFrame extends javax.swing.JFrame{

    protected boolean exit = false;
    
    protected ArrayList<String> inDatas = new ArrayList<>();
    protected ArrayList<String> outDatas = new ArrayList<>();

    public MainWindowFrame() throws IOException {
         for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        initComponents();
        setTitle("CloudBased classifier - Login");
        setResizable(false);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    protected void initComponents() {

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

        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });

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

    protected void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
    }//GEN-LAST:event_nameFieldActionPerformed

    protected void logButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logButtonActionPerformed
        try {
            outDatas.clear();
            String username = nameField.getText();
            String password = encrypt(passField.getText());
            if("".equals(username) || "".equals(passField.getText())){
                JOptionPane.showMessageDialog(null, "Nem hagyható üresen mező!");
             }else{
                outDatas.add("log:");
                outDatas.add(username);
                outDatas.add(password);
            }
            System.out.println("outDatas: " + outDatas);
        } catch (Exception ex) {
            System.out.println("Error: logButton");
        }
    }//GEN-LAST:event_logButtonActionPerformed

    protected void regButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regButtonActionPerformed
        regPanel.setVisible(true);
        loginPanel.setVisible(false);
    }//GEN-LAST:event_regButtonActionPerformed

    protected void regCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regCancelButtonActionPerformed
        regNameField.setText("");
        regPassField.setText("");
        regMailField.setText("");

        regPanel.setVisible(false);
        loginPanel.setVisible(true);
    }//GEN-LAST:event_regCancelButtonActionPerformed

    protected void regDoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regDoButtonActionPerformed
        try {
            outDatas.clear();
            String username = regNameField.getText();
            String mail = regMailField.getText();
            String password = encrypt(regPassField.getText());
            if("".equals(username) || "".equals(mail) || "".equals(regPassField.getText())){
                JOptionPane.showMessageDialog(null, "Nem hagyható üresen mező!");
            }else{
                outDatas.add("reg:");
                outDatas.add(username);
                outDatas.add(mail);
                outDatas.add(password);
            }
            System.out.println("outDatas: " + outDatas);
        } catch (Exception ex) {
            System.out.println("Error: regDoButton");
        }
    }//GEN-LAST:event_regDoButtonActionPerformed

    protected void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFieldActionPerformed

    private String encrypt(String pass){
    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] passBytes = pass.getBytes();
        md.reset();
        byte[] digested = md.digest(passBytes);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<digested.length;i++){
            sb.append(Integer.toHexString(0xff & digested[i]));
        }
        return sb.toString();
    } catch (NoSuchAlgorithmException ex) {
    }
        return null;
   }    
        
    protected void setDefaultJTextField(JTextField... textFields){
        for(JTextField jtx: textFields){
            jtx.setText("");
        }
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton logButton;
    protected javax.swing.JLabel logLabel;
    protected javax.swing.JPanel loginPanel;
    protected javax.swing.JTextField nameField;
    protected javax.swing.JLabel nameLabel;
    protected javax.swing.JPasswordField passField;
    protected javax.swing.JLabel passLabel;
    protected javax.swing.JButton regButton;
    protected javax.swing.JButton regCancelButton;
    protected javax.swing.JButton regDoButton;
    protected javax.swing.JLabel regLabel;
    protected javax.swing.JTextField regMailField;
    protected javax.swing.JLabel regMailLabel;
    protected javax.swing.JTextField regNameField;
    protected javax.swing.JLabel regNameLabel;
    protected javax.swing.JPanel regPanel;
    protected javax.swing.JPasswordField regPassField;
    protected javax.swing.JLabel regPassLabel;
    // End of variables declaration//GEN-END:variables
}
