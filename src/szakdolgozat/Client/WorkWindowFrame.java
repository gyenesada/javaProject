package szakdolgozat.Client;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class WorkWindowFrame extends javax.swing.JFrame{
    protected boolean exit = false;

    protected String rawInput;
    protected String selectedOperation="";
    protected String selectedTable; //oldal menü, 1 táblás műveletekhez 

    protected ArrayList<String> loadedTables = new ArrayList<>();
    protected ArrayList<String> csvToTable = new ArrayList<>();

    //buffered output datas.
    protected ArrayList<String> bufferOutput = new ArrayList<>();

    //container to send and receive datas
    protected ArrayList<String> outDatas = new ArrayList<>();
    protected ArrayList<String> inDatas = new ArrayList<>();
   
    //FELÜLET
    // <editor-fold defaultstate="collapsed">
    public WorkWindowFrame() throws Exception {
        initComponents();
   
        setTitle("CloudBased classifier");
        setResizable(false);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);

        addExitOption();
        changePanels(firstPanel);
        fillOperationsList();
        fillClassifierList();
        outDatas.add("old:");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        loadPanel = new javax.swing.JPanel();
        separator1 = new javax.swing.JSeparator();
        loadFileUploadPanel = new javax.swing.JPanel();
        fileUploadLabel = new javax.swing.JLabel();
        filepathField = new javax.swing.JTextField();
        choseButton = new javax.swing.JButton();
        uploadButton = new javax.swing.JButton();
        loadOldWorkPanel = new javax.swing.JPanel();
        oldWorkSPane = new javax.swing.JScrollPane();
        list = new java.awt.List();
        workPanel = new javax.swing.JPanel();
        separator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        previewScPane = new javax.swing.JScrollPane();
        csvPrevTable = new javax.swing.JTable();
        newTablePanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        workPathField = new javax.swing.JTextField();
        workUploadButton = new javax.swing.JButton();
        workChoseButton = new javax.swing.JButton();
        tablesPanel = new javax.swing.JPanel();
        classifierCBox = new javax.swing.JComboBox<>();
        operationCBox = new javax.swing.JComboBox<>();
        classifierLabel = new javax.swing.JLabel();
        operationLabel = new javax.swing.JLabel();
        doButton = new javax.swing.JButton();
        parameterMainPanel = new javax.swing.JPanel();
        votingPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        firstPanel = new javax.swing.JPanel();
        adaPanel = new javax.swing.JPanel();
        ada_beField = new javax.swing.JTextField();
        ada_beLabel = new javax.swing.JLabel();
        ada_neLabel = new javax.swing.JLabel();
        ada_neField = new javax.swing.JTextField();
        ada_lrLabel = new javax.swing.JLabel();
        ada_lrField = new javax.swing.JTextField();
        ada_algorithm = new javax.swing.JLabel();
        ada_algCBox = new javax.swing.JComboBox<>();
        ada_rsLabel = new javax.swing.JLabel();
        ada_rsField = new javax.swing.JTextField();
        sentimentPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rfcPanel = new javax.swing.JPanel();
        rfs_neLabel = new javax.swing.JLabel();
        rfc_neField = new javax.swing.JTextField();
        rfc_mdLabel = new javax.swing.JLabel();
        rfc_mdField = new javax.swing.JTextField();
        rfc_rsLabel = new javax.swing.JLabel();
        rfc_rsField = new javax.swing.JTextField();
        rfc_bsLabel = new javax.swing.JLabel();
        rfc_bsField = new javax.swing.JTextField();
        rfc_critLabel = new javax.swing.JLabel();
        rfc_critCBox = new javax.swing.JComboBox<>();
        rfc_oosLabel = new javax.swing.JLabel();
        rfc_oosField = new javax.swing.JTextField();
        rfc_njLabel = new javax.swing.JLabel();
        rfc_njField = new javax.swing.JTextField();
        baggingPanel = new javax.swing.JPanel();
        bc_beLabel = new javax.swing.JLabel();
        bc_beField = new javax.swing.JTextField();
        bc_neLabel = new javax.swing.JLabel();
        bc_neField = new javax.swing.JTextField();
        bc_bsLabel = new javax.swing.JLabel();
        bc_bsField = new javax.swing.JTextField();
        bc_bsfLabel = new javax.swing.JLabel();
        bc_bsfField = new javax.swing.JTextField();
        bc_oosLabel = new javax.swing.JLabel();
        bc_oosCBox = new javax.swing.JComboBox<>();
        bc_wsLabel = new javax.swing.JLabel();
        bc_wsField = new javax.swing.JTextField();
        bc_njLabel = new javax.swing.JLabel();
        bc_njField = new javax.swing.JTextField();
        bc_verLabel = new javax.swing.JLabel();
        bc_verField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        profilePanel = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        sidePanel = new javax.swing.JPanel();
        sideLoadPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        processBar = new javax.swing.JProgressBar();
        loadingLabel = new javax.swing.JLabel();
        sideWorkPanel = new javax.swing.JPanel();
        loadedTablesList = new javax.swing.JList<>();
        workSave = new javax.swing.JButton();
        separator = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        showLoadPanel = new javax.swing.JMenuItem();
        logOut = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);

        mainPanel.setPreferredSize(new java.awt.Dimension(1000, 600));
        mainPanel.setLayout(new java.awt.CardLayout());

        loadPanel.setPreferredSize(new java.awt.Dimension(1000, 600));

        separator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        loadFileUploadPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Új munkafolyamat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        fileUploadLabel.setText("Fájl feltöltés");

        filepathField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filepathFieldActionPerformed(evt);
            }
        });

        choseButton.setText("Kiválaszt");
        choseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choseButtonActionPerformed(evt);
            }
        });

        uploadButton.setText("Feltöltés");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loadFileUploadPanelLayout = new javax.swing.GroupLayout(loadFileUploadPanel);
        loadFileUploadPanel.setLayout(loadFileUploadPanelLayout);
        loadFileUploadPanelLayout.setHorizontalGroup(
            loadFileUploadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadFileUploadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fileUploadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filepathField, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(choseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(uploadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        loadFileUploadPanelLayout.setVerticalGroup(
            loadFileUploadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadFileUploadPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(loadFileUploadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileUploadLabel)
                    .addComponent(filepathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choseButton)
                    .addComponent(uploadButton))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        loadOldWorkPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Korábbi Munkafolyamat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        oldWorkSPane.setBackground(new java.awt.Color(255, 255, 255));

        list.setBackground(new java.awt.Color(255, 255, 255));
        list.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listActionPerformed(evt);
            }
        });
        oldWorkSPane.setViewportView(list);

        javax.swing.GroupLayout loadOldWorkPanelLayout = new javax.swing.GroupLayout(loadOldWorkPanel);
        loadOldWorkPanel.setLayout(loadOldWorkPanelLayout);
        loadOldWorkPanelLayout.setHorizontalGroup(
            loadOldWorkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadOldWorkPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(oldWorkSPane, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                .addContainerGap())
        );
        loadOldWorkPanelLayout.setVerticalGroup(
            loadOldWorkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadOldWorkPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(oldWorkSPane, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout loadPanelLayout = new javax.swing.GroupLayout(loadPanel);
        loadPanel.setLayout(loadPanelLayout);
        loadPanelLayout.setHorizontalGroup(
            loadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loadFileUploadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadOldWorkPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        loadPanelLayout.setVerticalGroup(
            loadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(loadFileUploadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(loadOldWorkPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(86, 86, 86))
        );

        mainPanel.add(loadPanel, "card3");

        workPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.W_RESIZE_CURSOR));

        separator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        previewScPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Előnézet"));

        csvPrevTable.setModel(new javax.swing.table.DefaultTableModel(
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
        previewScPane.setViewportView(csvPrevTable);

        newTablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        newTablePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel8.setText("Új tábla feltöltése: ");

        workUploadButton.setText("Feltöltés");
        workUploadButton.setToolTipText("");
        workUploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workUploadButtonActionPerformed(evt);
            }
        });

        workChoseButton.setText("Kiválaszt");

        javax.swing.GroupLayout newTablePanelLayout = new javax.swing.GroupLayout(newTablePanel);
        newTablePanel.setLayout(newTablePanelLayout);
        newTablePanelLayout.setHorizontalGroup(
            newTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(workPathField)
                .addGap(18, 18, 18)
                .addComponent(workChoseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(workUploadButton)
                    .addComponent(workChoseButton))
                .addContainerGap())
        );

        tablesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Táblák kezelése"));
        tablesPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        classifierCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "item" }));
        classifierCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classifierCBoxActionPerformed(evt);
            }
        });

        operationCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        operationCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operationCBoxActionPerformed(evt);
            }
        });

        classifierLabel.setText("Classifier");

        operationLabel.setText("Műveletek");

        doButton.setText("Indítás");
        doButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doButtonActionPerformed(evt);
            }
        });

        parameterMainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paraméterek", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12))); // NOI18N
        parameterMainPanel.setLayout(new java.awt.CardLayout());

        jLabel1.setText("Voting panel");

        javax.swing.GroupLayout votingPanelLayout = new javax.swing.GroupLayout(votingPanel);
        votingPanel.setLayout(votingPanelLayout);
        votingPanelLayout.setHorizontalGroup(
            votingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, votingPanelLayout.createSequentialGroup()
                .addContainerGap(256, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(271, 271, 271))
        );
        votingPanelLayout.setVerticalGroup(
            votingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(votingPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        parameterMainPanel.add(votingPanel, "card7");

        javax.swing.GroupLayout firstPanelLayout = new javax.swing.GroupLayout(firstPanel);
        firstPanel.setLayout(firstPanelLayout);
        firstPanelLayout.setHorizontalGroup(
            firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );
        firstPanelLayout.setVerticalGroup(
            firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );

        parameterMainPanel.add(firstPanel, "card2");

        ada_beField.setText("DecisionTreeClassifier");

        ada_beLabel.setText("base_estimator:");

        ada_neLabel.setText("n_estimators:");

        ada_neField.setText("50");
        ada_neField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ada_neFieldActionPerformed(evt);
            }
        });

        ada_lrLabel.setText("learning_rate:");

        ada_lrField.setText("1");

        ada_algorithm.setText("algorithm: ");

        ada_algCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SAMME.R", "SAMME" }));

        ada_rsLabel.setText("random_state:");

        ada_rsField.setText("None");

        javax.swing.GroupLayout adaPanelLayout = new javax.swing.GroupLayout(adaPanel);
        adaPanel.setLayout(adaPanelLayout);
        adaPanelLayout.setHorizontalGroup(
            adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adaPanelLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ada_beLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ada_algorithm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ada_beField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ada_algCBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ada_neLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ada_rsLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ada_neField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ada_rsField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ada_lrLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ada_lrField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        adaPanelLayout.setVerticalGroup(
            adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ada_beField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ada_beLabel)
                    .addComponent(ada_neLabel)
                    .addComponent(ada_neField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ada_lrLabel)
                    .addComponent(ada_lrField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ada_algorithm)
                    .addComponent(ada_algCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ada_rsLabel)
                    .addComponent(ada_rsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        parameterMainPanel.add(adaPanel, "card2");

        jLabel2.setText("Sentiment Panel");

        javax.swing.GroupLayout sentimentPanelLayout = new javax.swing.GroupLayout(sentimentPanel);
        sentimentPanel.setLayout(sentimentPanelLayout);
        sentimentPanelLayout.setHorizontalGroup(
            sentimentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sentimentPanelLayout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel2)
                .addContainerGap(249, Short.MAX_VALUE))
        );
        sentimentPanelLayout.setVerticalGroup(
            sentimentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sentimentPanelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel2)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        parameterMainPanel.add(sentimentPanel, "card2");

        rfs_neLabel.setText("n_estimators:");

        rfc_neField.setText("10");

        rfc_mdLabel.setText("max_depth:");

        rfc_mdField.setText("None");

        rfc_rsLabel.setText("random_state:");

        rfc_rsField.setText("None");

        rfc_bsLabel.setText("bootstrap:");

        rfc_bsField.setText("True");

        rfc_critLabel.setText("criterion: ");

        rfc_critCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "gini", "entropty" }));

        rfc_oosLabel.setText("oob_score:");

        rfc_oosField.setText("True");

        rfc_njLabel.setText("n_jobs:");

        rfc_njField.setText("1");

        javax.swing.GroupLayout rfcPanelLayout = new javax.swing.GroupLayout(rfcPanel);
        rfcPanel.setLayout(rfcPanelLayout);
        rfcPanelLayout.setHorizontalGroup(
            rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rfcPanelLayout.createSequentialGroup()
                .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rfcPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rfc_rsLabel)
                            .addComponent(rfc_bsLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rfc_rsField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rfc_bsField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(rfcPanelLayout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(rfcPanelLayout.createSequentialGroup()
                                .addComponent(rfs_neLabel)
                                .addGap(31, 31, 31)
                                .addComponent(rfc_neField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rfcPanelLayout.createSequentialGroup()
                                .addComponent(rfc_mdLabel)
                                .addGap(31, 31, 31)
                                .addComponent(rfc_mdField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rfcPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(rfc_oosLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rfcPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rfc_critLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rfc_njLabel, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rfc_oosField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rfc_critCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rfc_njField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(269, 269, 269))
        );
        rfcPanelLayout.setVerticalGroup(
            rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rfcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rfs_neLabel)
                    .addComponent(rfc_neField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rfc_critLabel)
                    .addComponent(rfc_critCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rfc_mdLabel)
                    .addComponent(rfc_mdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rfc_oosLabel)
                    .addComponent(rfc_oosField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rfc_rsLabel)
                    .addComponent(rfc_rsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rfc_njLabel)
                    .addComponent(rfc_njField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rfc_bsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rfc_bsLabel))
                .addContainerGap())
        );

        parameterMainPanel.add(rfcPanel, "card2");

        bc_beLabel.setText("base_estimator:");

        bc_beField.setText("None");

        bc_neLabel.setText("n_estimators:");

        bc_neField.setText("10");
        bc_neField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bc_neFieldActionPerformed(evt);
            }
        });

        bc_bsLabel.setText("bootstrap:");

        bc_bsField.setText("True");

        bc_bsfLabel.setText("bootstrap_features:");

        bc_bsfField.setText("False");

        bc_oosLabel.setText("oob_score:");

        bc_oosCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "True", "False" }));

        bc_wsLabel.setText("warm_stat:");

        bc_wsField.setText("False");

        bc_njLabel.setText("n_jobs:");

        bc_njField.setText("1");

        bc_verLabel.setText("verbose:");

        bc_verField.setText("0");

        javax.swing.GroupLayout baggingPanelLayout = new javax.swing.GroupLayout(baggingPanel);
        baggingPanel.setLayout(baggingPanelLayout);
        baggingPanelLayout.setHorizontalGroup(
            baggingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baggingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(baggingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bc_bsfLabel)
                    .addComponent(bc_bsLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bc_neLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bc_beLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(baggingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bc_beField, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(bc_neField)
                    .addComponent(bc_bsField)
                    .addComponent(bc_bsfField))
                .addGap(46, 46, 46)
                .addGroup(baggingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baggingPanelLayout.createSequentialGroup()
                        .addComponent(bc_oosLabel)
                        .addGap(18, 18, 18)
                        .addComponent(bc_oosCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(baggingPanelLayout.createSequentialGroup()
                        .addGroup(baggingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bc_njLabel)
                            .addComponent(bc_wsLabel)
                            .addComponent(bc_verLabel))
                        .addGap(18, 18, 18)
                        .addGroup(baggingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bc_wsField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(bc_njField)
                            .addComponent(bc_verField))
                        .addGap(265, 265, 265))))
        );
        baggingPanelLayout.setVerticalGroup(
            baggingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baggingPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(baggingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bc_beLabel)
                    .addComponent(bc_beField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bc_oosLabel)
                    .addComponent(bc_oosCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(baggingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bc_neLabel)
                    .addComponent(bc_neField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bc_wsLabel)
                    .addComponent(bc_wsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(baggingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bc_bsLabel)
                    .addComponent(bc_bsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bc_njLabel)
                    .addComponent(bc_njField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(baggingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bc_bsfLabel)
                    .addComponent(bc_bsfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bc_verLabel)
                    .addComponent(bc_verField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        parameterMainPanel.add(baggingPanel, "card2");

        cancelButton.setText("Alapértelmezés");

        javax.swing.GroupLayout tablesPanelLayout = new javax.swing.GroupLayout(tablesPanel);
        tablesPanel.setLayout(tablesPanelLayout);
        tablesPanelLayout.setHorizontalGroup(
            tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablesPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(classifierLabel)
                    .addComponent(classifierCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(operationCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(operationLabel)
                    .addGroup(tablesPanelLayout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(doButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(parameterMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        tablesPanelLayout.setVerticalGroup(
            tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablesPanelLayout.createSequentialGroup()
                .addGroup(tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tablesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(parameterMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tablesPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(operationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(operationCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(classifierLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(classifierCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doButton)
                            .addComponent(cancelButton))))
                .addGap(26, 26, 26))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

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
                            .addComponent(previewScPane, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        workPanelLayout.setVerticalGroup(
            workPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separator2)
            .addGroup(workPanelLayout.createSequentialGroup()
                .addComponent(newTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previewScPane, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(workPanel, "card3");
        workPanel.getAccessibleContext().setAccessibleName("");

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
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sideLoadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sideLoadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(processBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(sideLoadPanelLayout.createSequentialGroup()
                        .addComponent(loadingLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 349, Short.MAX_VALUE)
                .addComponent(loadingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(processBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        sidePanel.add(sideLoadPanel, "card2");

        loadedTablesList.setBackground(new java.awt.Color(240, 240, 240));
        loadedTablesList.setBorder(javax.swing.BorderFactory.createTitledBorder("Betöltött táblák"));
        loadedTablesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        workSave.setText("Mentés");

        javax.swing.GroupLayout sideWorkPanelLayout = new javax.swing.GroupLayout(sideWorkPanel);
        sideWorkPanel.setLayout(sideWorkPanelLayout);
        sideWorkPanelLayout.setHorizontalGroup(
            sideWorkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loadedTablesList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideWorkPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(workSave)
                .addContainerGap())
        );
        sideWorkPanelLayout.setVerticalGroup(
            sideWorkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideWorkPanelLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(loadedTablesList, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(workSave)
                .addContainerGap())
        );

        sidePanel.add(sideWorkPanel, "card2");

        fileMenu.setText("File");

        showLoadPanel.setText("Főoldal");
        showLoadPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showLoadPanelActionPerformed(evt);
            }
        });
        fileMenu.add(showLoadPanel);

        logOut.setText("Kijelentkezés");
        fileMenu.add(logOut);

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
        // outDatas.clear();
        String file = filepathField.getText();
        selectedTable = getFilename(file);
        System.out.println("selected: " + selectedTable);
        //selectedTable.add(getFilename(file));
        if (file.equals("")) {
            JOptionPane.showMessageDialog(this, "Kérem adjon meg feltöltendő file-t!");
        } else {
            outDatas = readFromCsv(file);
        }
    }//GEN-LAST:event_uploadButtonActionPerformed

    private void choseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choseButtonActionPerformed
        FileManager fm = new FileManager();
        fm.setVisible(true);
    }//GEN-LAST:event_choseButtonActionPerformed

    private void doButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doButtonActionPerformed
        outDatas.clear();

        switch (selectedOperation) {
            case "ada":
                String[] ada_parameters = {ada_beField.getText(), ada_neField.getText(), ada_lrField.getText(), ada_algCBox.getSelectedItem().toString(), ada_rsField.getText()};
                setClassifierParameters("ada:", ada_parameters);
                break;
            case "rfc":
                System.out.println("selected: " + selectedOperation);
                String[] rfc_parameters = {rfc_mdField.getText(), rfc_neField.getText(), rfc_rsField.getText(), rfc_bsField.getText(), rfc_critCBox.getSelectedItem().toString(), rfc_oosField.getText(), rfc_njField.getText()};
                setClassifierParameters("rfc:", rfc_parameters);
                break;
            case "bag":
                String[] bag_parameters = {bc_beField.getText(), bc_neField.getText(), bc_bsField.getText(), bc_bsfField.getText(), bc_oosCBox.getSelectedItem().toString(), bc_wsField.getText(), bc_njField.getText(), bc_verField.getText()};
                setClassifierParameters("bag:", bag_parameters);
                break;
            case "vot":
                String[] vot_parameters = {};
                setClassifierParameters("vot:", vot_parameters);
                break;
            default:
                break;
        }

        outDatas = bufferOutput;
    }//GEN-LAST:event_doButtonActionPerformed

    private void workUploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workUploadButtonActionPerformed
        outDatas.clear();
        String file = workPathField.getText();
        if (file.equals("")) {
            JOptionPane.showMessageDialog(this, "Kérem adjon meg feltöltendő file-t!");
        } else {
            outDatas = bufferOutput;
        }
    }//GEN-LAST:event_workUploadButtonActionPerformed

    private void listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listActionPerformed

    }//GEN-LAST:event_listActionPerformed

    private void showLoadPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showLoadPanelActionPerformed
        //refreshelni kell majd a korábbi munkalistát
        
        operationCBox.setSelectedItem("...");
        classifierCBox.setSelectedItem("...");
        workPanel.setVisible(false);
        sideWorkPanel.setVisible(false);

        loadPanel.setVisible(true);
        sideLoadPanel.setVisible(true);
    }//GEN-LAST:event_showLoadPanelActionPerformed

    private void operationCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operationCBoxActionPerformed
        String chosen = getSelectedOperation();
        if (chosen == null) {
            //  donothing
        } else {
            switch (chosen) {
                case "Faktorizálás":
                    bufferOutput.clear();
                    bufferOutput.add("fact:");
                    bufferOutput.add(selectedTable);
                    System.out.println("actlist: " + selectedTable);
                 break;
                case "Normalizálás":
                    bufferOutput.clear();
                    bufferOutput.add("norm:");
                    bufferOutput.add(selectedTable);
                 break;
            }
        }
    }//GEN-LAST:event_operationCBoxActionPerformed

    private void classifierCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classifierCBoxActionPerformed
        String chosen = getSelectedClassifier();
        if (chosen == null) {
            //  donothing
        } else {
            switch (chosen) {
                case "...":
                    changePanels(firstPanel);
                    break;
                case "AdaBoost Classifier":
                    changePanels(adaPanel);

                    selectedOperation = "ada";
                    break;
                case "Random Forest Classifier":
                    changePanels(rfcPanel);

                    selectedOperation = "rfc";
                    break;
                case "Bagging Classifier":
                    changePanels(baggingPanel);

                    selectedOperation = "bag";
                    break;
                case "Voting Classifier":
                    changePanels(votingPanel);
                    selectedOperation = "vot";
                    break;
            }
        }
    }//GEN-LAST:event_classifierCBoxActionPerformed

    private void ada_neFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ada_neFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ada_neFieldActionPerformed

    private void bc_neFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bc_neFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bc_neFieldActionPerformed

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
    

    // </editor-fold>
    //Combo-box feltöltő fv-ek
    // <editor-fold defaultstate="collapsed">
    private void fillOperationsList() {
        ArrayList<String> operations = new ArrayList<>();

        operationCBox.removeAllItems();
        operations.add("..."); //első üres legyen
        operations.add("Üres értékek kezelése");
        operations.add("Faktorizálás");
        operations.add("Normalizálás");
        operations.add("Összefűzés");
        operations.add("Oszlopok törlése");
        operations.add("Feature kiválasztás");

        operations.forEach((str) -> {
            operationCBox.addItem(str);
        });
    }

    private void fillClassifierList() {
        ArrayList<String> classifiers = new ArrayList<>();

        classifierCBox.removeAllItems();
        classifiers.add("...");
        classifiers.add("AdaBoost Classifier");
        classifiers.add("Random Forest Classifier");
        classifiers.add("Sentiment Analysis");
        classifiers.add("Bagging Classifier");
        classifiers.add("Voting Classifier");
        classifiers.add("Gradient Tree Boost");

        classifiers.forEach((str) -> {
            classifierCBox.addItem(str);
        });
    }
    //</editor-fold>

    //CSV kezelő fv-ek
    // <editor-fold defaultstate="collapsed">
    
    protected void fillPrevTable(String[] cols, ArrayList<String[]> items) {
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        items.forEach((str) -> {
            model.addRow(str);
        });
        csvPrevTable.setModel(model);
        csvPrevTable.setDefaultEditor(Object.class, null);
    }
    // </editor-fold>

    //GETTEREK-SETTEREK
    // <editor-fold defaultstate="collapsed">
    protected void getSelectedFile() {
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    try {
                        String selected = list.getComponentAt(e.getPoint()).toString().split("    -    ")[1];
                        outDatas.clear();
                        outDatas.add("ldt:");
                        outDatas.add(selected);
                        selectedTable = selected;
                    } catch (ArrayIndexOutOfBoundsException ex) {
                    }
                }
            }
        });
    }

    protected String getFilename(String path) {
        String[] spl = path.split(Pattern.quote("\\"));
        return spl[spl.length - 1];
    }

    private String getSelectedOperation() {
        return operationCBox.getItemAt(operationCBox.getSelectedIndex());
    }

    private String getSelectedClassifier() {
        return classifierCBox.getItemAt(classifierCBox.getSelectedIndex());
    }

    private void changePanels(JPanel visiblePanel) {
        JPanel[] panels = {firstPanel, adaPanel, sentimentPanel, rfcPanel, baggingPanel, votingPanel};
        for (JPanel p : panels) {
            if (visiblePanel == p) {
                p.setVisible(true);
            } else {
                p.setVisible(false);
            }
        }
    }

    private void setClassifierParameters(String classifier, String[] parameters) {
        bufferOutput.clear();
        bufferOutput.add(classifier);
        bufferOutput.addAll(Arrays.asList(parameters));
    }
    
 private ArrayList<String> readFromCsv(String path) {
        ArrayList<String> csv = new ArrayList<>();
        csv.add("csv:");
        String filename;

        BufferedReader br = null;
        try {
            File file = new File(path);
            br = new BufferedReader(new FileReader(file));
            filename = getFilename(path);
            csv.add(filename + ":");
            String line = br.readLine();
            csv.add(line);
            csv.add(">>flag<<");

            String[] cols = line.split(",");
            ArrayList<String[]> items = new ArrayList<>();
            int index = 0;
            while (line != null) {
                line = br.readLine();

                if (line == null) {
                    break;
                } else {
                    csv.add(line);  
                    csv.add(">>flag<<"); //valamiért betesz egy utolsót..
                }
                if (index < 500) {
                    String[] items_temp = line.split(",");
                    items.add(items_temp);
                }
                index++;
            }
            fillPrevTable(cols, items);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Nem létező file.");
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Nem létező file.");
            }
        }
        return csv;
    }
    // </editor-fold>
    //VARIABLES
    // <editor-fold defaultstate="collapsed">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JPanel adaPanel;
    protected javax.swing.JComboBox<String> ada_algCBox;
    protected javax.swing.JLabel ada_algorithm;
    protected javax.swing.JTextField ada_beField;
    protected javax.swing.JLabel ada_beLabel;
    protected javax.swing.JTextField ada_lrField;
    protected javax.swing.JLabel ada_lrLabel;
    protected javax.swing.JTextField ada_neField;
    protected javax.swing.JLabel ada_neLabel;
    protected javax.swing.JTextField ada_rsField;
    protected javax.swing.JLabel ada_rsLabel;
    protected javax.swing.JPanel baggingPanel;
    protected javax.swing.JTextField bc_beField;
    protected javax.swing.JLabel bc_beLabel;
    protected javax.swing.JTextField bc_bsField;
    protected javax.swing.JLabel bc_bsLabel;
    protected javax.swing.JTextField bc_bsfField;
    protected javax.swing.JLabel bc_bsfLabel;
    protected javax.swing.JTextField bc_neField;
    protected javax.swing.JLabel bc_neLabel;
    protected javax.swing.JTextField bc_njField;
    protected javax.swing.JLabel bc_njLabel;
    protected javax.swing.JComboBox<String> bc_oosCBox;
    protected javax.swing.JLabel bc_oosLabel;
    protected javax.swing.JTextField bc_verField;
    protected javax.swing.JLabel bc_verLabel;
    protected javax.swing.JTextField bc_wsField;
    protected javax.swing.JLabel bc_wsLabel;
    protected javax.swing.JButton cancelButton;
    protected javax.swing.JButton choseButton;
    protected javax.swing.JComboBox<String> classifierCBox;
    protected javax.swing.JLabel classifierLabel;
    protected javax.swing.JTable csvPrevTable;
    protected javax.swing.JButton doButton;
    protected javax.swing.JMenu fileMenu;
    protected javax.swing.JLabel fileUploadLabel;
    protected javax.swing.JTextField filepathField;
    protected javax.swing.JPanel firstPanel;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JLabel jLabel4;
    protected javax.swing.JLabel jLabel5;
    protected javax.swing.JLabel jLabel6;
    protected javax.swing.JLabel jLabel7;
    protected javax.swing.JLabel jLabel8;
    protected javax.swing.JMenu jMenu2;
    protected javax.swing.JMenuBar jMenuBar1;
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JSeparator jSeparator1;
    protected javax.swing.JTable jTable1;
    protected java.awt.List list;
    protected javax.swing.JPanel loadFileUploadPanel;
    protected javax.swing.JPanel loadOldWorkPanel;
    protected javax.swing.JPanel loadPanel;
    protected javax.swing.JList<String> loadedTablesList;
    protected javax.swing.JLabel loadingLabel;
    protected javax.swing.JMenuItem logOut;
    protected javax.swing.JPanel mainPanel;
    protected javax.swing.JPanel newTablePanel;
    protected javax.swing.JScrollPane oldWorkSPane;
    protected javax.swing.JComboBox<String> operationCBox;
    protected javax.swing.JLabel operationLabel;
    protected javax.swing.JPanel parameterMainPanel;
    protected javax.swing.JScrollPane previewScPane;
    protected javax.swing.JProgressBar processBar;
    protected javax.swing.JPanel profilePanel;
    protected javax.swing.JPanel rfcPanel;
    protected javax.swing.JTextField rfc_bsField;
    protected javax.swing.JLabel rfc_bsLabel;
    protected javax.swing.JComboBox<String> rfc_critCBox;
    protected javax.swing.JLabel rfc_critLabel;
    protected javax.swing.JTextField rfc_mdField;
    protected javax.swing.JLabel rfc_mdLabel;
    protected javax.swing.JTextField rfc_neField;
    protected javax.swing.JTextField rfc_njField;
    protected javax.swing.JLabel rfc_njLabel;
    protected javax.swing.JTextField rfc_oosField;
    protected javax.swing.JLabel rfc_oosLabel;
    protected javax.swing.JTextField rfc_rsField;
    protected javax.swing.JLabel rfc_rsLabel;
    protected javax.swing.JLabel rfs_neLabel;
    protected javax.swing.JPanel sentimentPanel;
    protected javax.swing.JSeparator separator;
    protected javax.swing.JSeparator separator1;
    protected javax.swing.JSeparator separator2;
    protected javax.swing.JMenuItem showLoadPanel;
    protected javax.swing.JPanel sideLoadPanel;
    protected javax.swing.JPanel sidePanel;
    protected javax.swing.JPanel sideWorkPanel;
    protected javax.swing.JPanel tablesPanel;
    protected javax.swing.JButton uploadButton;
    protected javax.swing.JLabel usernameLabel;
    protected javax.swing.JPanel votingPanel;
    protected javax.swing.JButton workChoseButton;
    protected javax.swing.JPanel workPanel;
    protected javax.swing.JTextField workPathField;
    protected javax.swing.JButton workSave;
    protected javax.swing.JButton workUploadButton;
    // End of variables declaration//GEN-END:variables

    // </editor-fold>
}
