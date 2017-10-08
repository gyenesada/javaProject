package szakdolgozat.Client;

import java.io.PrintWriter;
import java.util.Scanner;

public class WorkWindowFrame extends javax.swing.JFrame implements Runnable {

    private final String loggedUser;
    private final Scanner sc;
    private final PrintWriter pw;
    
    public WorkWindowFrame(PrintWriter pw, Scanner sc, String name) throws Exception {
        this.loggedUser = name;
        this.sc = sc;
        this.pw = pw;
        
        initComponents();
        
        this.setTitle("CloudBased classifier");
        this.setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        loadPanel = new javax.swing.JPanel();
        oldWorkLabel = new javax.swing.JLabel();
        newWorkLabel = new javax.swing.JLabel();
        separator1 = new javax.swing.JSeparator();
        filepathField = new javax.swing.JTextField();
        uploadButton = new javax.swing.JButton();
        fileUploadLabel = new javax.swing.JLabel();
        choseButton = new javax.swing.JButton();
        oldWorkSPane = new javax.swing.JScrollPane();
        workPanel = new javax.swing.JPanel();
        separator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        csvPreview = new javax.swing.JTable();
        newTablePanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        workPathField = new javax.swing.JTextField();
        workChooseButton = new javax.swing.JButton();
        workUploadButton = new javax.swing.JButton();
        tablesPanel = new javax.swing.JPanel();
        profilePanel = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        sidePanel = new javax.swing.JPanel();
        sideLoadPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        sideWorkPanel = new javax.swing.JPanel();
        classifierCBox = new javax.swing.JComboBox<>();
        classifierLabel = new javax.swing.JLabel();
        paramSPane = new javax.swing.JScrollPane();
        parameterLabel = new javax.swing.JLabel();
        doButton = new javax.swing.JButton();
        operationLabel = new javax.swing.JLabel();
        operationCBox = new javax.swing.JComboBox<>();
        separator = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);

        mainPanel.setLayout(new java.awt.CardLayout());

        oldWorkLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        oldWorkLabel.setForeground(new java.awt.Color(102, 102, 102));
        oldWorkLabel.setText("Korábbi munkafolyamatok");

        newWorkLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        newWorkLabel.setForeground(new java.awt.Color(102, 102, 102));
        newWorkLabel.setText("Új munkafolyamat");

        separator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        filepathField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filepathFieldActionPerformed(evt);
            }
        });

        uploadButton.setText("Feltöltés");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        fileUploadLabel.setText("Fájl feltöltés");

        choseButton.setText("Kiválaszt");
        choseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loadPanelLayout = new javax.swing.GroupLayout(loadPanel);
        loadPanel.setLayout(loadPanelLayout);
        loadPanelLayout.setHorizontalGroup(
            loadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadPanelLayout.createSequentialGroup()
                .addGroup(loadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loadPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(loadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filepathField, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fileUploadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(choseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loadPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(loadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newWorkLabel)
                            .addComponent(oldWorkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(loadPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(oldWorkSPane)))))
                .addGap(18, 18, 18)
                .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        loadPanelLayout.setVerticalGroup(
            loadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(newWorkLabel)
                .addGap(25, 25, 25)
                .addComponent(fileUploadLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filepathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uploadButton)
                    .addComponent(choseButton))
                .addGap(45, 45, 45)
                .addComponent(oldWorkLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(oldWorkSPane, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        mainPanel.add(loadPanel, "card3");

        separator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        csvPreview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(csvPreview);

        newTablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel8.setText("Új tábla feltöltése: ");

        workChooseButton.setText("Kiválaszt");

        workUploadButton.setText("Feltöltés");
        workUploadButton.setToolTipText("");
        workUploadButton.setActionCommand("Feltöltés");

        javax.swing.GroupLayout newTablePanelLayout = new javax.swing.GroupLayout(newTablePanel);
        newTablePanel.setLayout(newTablePanelLayout);
        newTablePanelLayout.setHorizontalGroup(
            newTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(workPathField, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(workChooseButton)
                .addGap(16, 16, 16)
                .addComponent(workUploadButton)
                .addContainerGap())
        );
        newTablePanelLayout.setVerticalGroup(
            newTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newTablePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(newTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(workPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(workChooseButton)
                    .addComponent(workUploadButton))
                .addContainerGap())
        );

        tablesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tablesPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout tablesPanelLayout = new javax.swing.GroupLayout(tablesPanel);
        tablesPanel.setLayout(tablesPanelLayout);
        tablesPanelLayout.setHorizontalGroup(
            tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tablesPanelLayout.setVerticalGroup(
            tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout workPanelLayout = new javax.swing.GroupLayout(workPanel);
        workPanel.setLayout(workPanelLayout);
        workPanelLayout.setHorizontalGroup(
            workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, workPanelLayout.createSequentialGroup()
                .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(workPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(workPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tablesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newTablePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        workPanelLayout.setVerticalGroup(
            workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separator2)
            .addGroup(workPanelLayout.createSequentialGroup()
                .addComponent(newTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.add(workPanel, "card3");

        usernameLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setText("Felhasználónév");

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(usernameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addComponent(usernameLabel)
                .addGap(0, 49, Short.MAX_VALUE))
        );

        sidePanel.setLayout(new java.awt.CardLayout());

        jLabel4.setText("Felhasználónév változtatás");

        jLabel5.setText("Jelszó változtatás");

        jLabel6.setText("Profilkép feltöltése");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Profil szerkesztése");

        javax.swing.GroupLayout sideLoadPanelLayout = new javax.swing.GroupLayout(sideLoadPanel);
        sideLoadPanel.setLayout(sideLoadPanelLayout);
        sideLoadPanelLayout.setHorizontalGroup(
            sideLoadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideLoadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sideLoadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(sideLoadPanelLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        sideLoadPanelLayout.setVerticalGroup(
            sideLoadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideLoadPanelLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(346, Short.MAX_VALUE))
        );

        sidePanel.add(sideLoadPanel, "card2");

        classifierCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        classifierLabel.setText("Classifier");

        parameterLabel.setText("Paraméterek");

        doButton.setText("Mehet");
        doButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doButtonActionPerformed(evt);
            }
        });

        operationLabel.setText("Műveletek");

        operationCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout sideWorkPanelLayout = new javax.swing.GroupLayout(sideWorkPanel);
        sideWorkPanel.setLayout(sideWorkPanelLayout);
        sideWorkPanelLayout.setHorizontalGroup(
            sideWorkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideWorkPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sideWorkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paramSPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(classifierCBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideWorkPanelLayout.createSequentialGroup()
                        .addGap(0, 68, Short.MAX_VALUE)
                        .addComponent(doButton))
                    .addComponent(operationCBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(sideWorkPanelLayout.createSequentialGroup()
                        .addGroup(sideWorkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(classifierLabel)
                            .addComponent(parameterLabel)
                            .addComponent(operationLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        sideWorkPanelLayout.setVerticalGroup(
            sideWorkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideWorkPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(operationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(operationCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(classifierLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classifierCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parameterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paramSPane, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(doButton)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        sidePanel.add(sideWorkPanel, "card2");

        fileMenu.setText("File");
        jMenuBar1.add(fileMenu);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(separator)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(profilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filepathFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filepathFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filepathFieldActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        loadPanel.setVisible(false);
        workPanel.setVisible(true);
        
        sideLoadPanel.setVisible(false);
        sideWorkPanel.setVisible(true);
    }//GEN-LAST:event_uploadButtonActionPerformed

    private void choseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choseButtonActionPerformed
       FileManager fm = new FileManager();
       fm.setVisible(true);
    }//GEN-LAST:event_choseButtonActionPerformed

    private void doButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doButtonActionPerformed

    @Override
    public void run() {
        usernameLabel.setText("Üdvözöljük " + loggedUser + "!");
        communicateWithServer(pw, sc);
    }
    
    private void communicateWithServer(PrintWriter pw, Scanner sc) {
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton choseButton;
    private javax.swing.JComboBox<String> classifierCBox;
    private javax.swing.JLabel classifierLabel;
    private javax.swing.JTable csvPreview;
    private javax.swing.JButton doButton;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel fileUploadLabel;
    private javax.swing.JTextField filepathField;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel loadPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel newTablePanel;
    private javax.swing.JLabel newWorkLabel;
    private javax.swing.JLabel oldWorkLabel;
    private javax.swing.JScrollPane oldWorkSPane;
    private javax.swing.JComboBox<String> operationCBox;
    private javax.swing.JLabel operationLabel;
    private javax.swing.JScrollPane paramSPane;
    private javax.swing.JLabel parameterLabel;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JSeparator separator;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSeparator separator2;
    private javax.swing.JPanel sideLoadPanel;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JPanel sideWorkPanel;
    private javax.swing.JPanel tablesPanel;
    private javax.swing.JButton uploadButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JButton workChooseButton;
    private javax.swing.JPanel workPanel;
    private javax.swing.JTextField workPathField;
    private javax.swing.JButton workUploadButton;
    // End of variables declaration//GEN-END:variables
}
