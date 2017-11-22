package szakdolgozat.Client;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public final class WorkWindowFrame extends javax.swing.JFrame {

    protected boolean exit = false;

    protected String rawInput, selectedTable, currentTask, path;
    protected String selectedOperation = "";
    protected String[] columns;

    protected int currentTaskID;

    protected ArrayList<String> loadedTables = new ArrayList<>();
    protected ArrayList<String> csvToTable = new ArrayList<>();

    //buffered output datas.
    protected ArrayList<String> bufferOutput = new ArrayList<>();

    protected ArrayList<String> outDatas = new ArrayList<>();
    protected ArrayList<String> inDatas = new ArrayList();

    protected ButtonGroup nanRadioGroup;
    protected LoadingFrame lf;

    DefaultListModel colModel;
    DefaultListModel dropColModel;
    String loggedUser;

    //FELÜLET
    // <editor-fold defaultstate="collapsed">
    public WorkWindowFrame(String username) throws Exception {
        this.loggedUser = username;
        //initcomponentsbe kellene majd.
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();

        setTitle("CloudBased classifier");
        setResizable(false);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);

        addExitOption();
        changePanels(firstPanel);
        fillOperationsList();
        fillClassifierList();
        setTextFieldNames();
        addColToDrop();
        removeColToDrop();
        setScrollPane();
        setNanRadioButtons();
        editProfil();

        outDatas.add("wrk:");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    protected void initComponents() {

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
        workUploadLabel = new javax.swing.JLabel();
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
        nanPanel = new javax.swing.JPanel();
        zeroRButton = new javax.swing.JRadioButton();
        meanRButton = new javax.swing.JRadioButton();
        delRButton = new javax.swing.JRadioButton();
        medianRButton = new javax.swing.JRadioButton();
        modeRButton = new javax.swing.JRadioButton();
        firstPanel = new javax.swing.JPanel();
        sentimentPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rfcPanel = new javax.swing.JPanel();
        rfs_neLabel = new javax.swing.JLabel();
        rfc_neField = new javax.swing.JTextField();
        rfc_mdLabel = new javax.swing.JLabel();
        rfc_mdField = new javax.swing.JTextField();
        rfc_rsLabel = new javax.swing.JLabel();
        rfc_rsField = new javax.swing.JTextField();
        rfc_njLabel = new javax.swing.JLabel();
        rfc_njField = new javax.swing.JTextField();
        rfc_targetLabel = new javax.swing.JLabel();
        rfc_targetCBox = new javax.swing.JComboBox<>();
        rfc_featLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rfc_fromList = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        rfc_toList = new javax.swing.JList<>();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        rfc_outLabel = new javax.swing.JLabel();
        rfc_outCBox = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        rfc_outList = new javax.swing.JList<>();
        dropcolPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        colList = new javax.swing.JList<>();
        colLabel = new javax.swing.JLabel();
        delColLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        dropColList = new javax.swing.JList<>();
        adaPanel = new javax.swing.JPanel();
        ada_neLabel = new javax.swing.JLabel();
        ada_neField = new javax.swing.JTextField();
        ada_lrLabel = new javax.swing.JLabel();
        ada_lrField = new javax.swing.JTextField();
        ada_rsLabel = new javax.swing.JLabel();
        ada_rsField = new javax.swing.JTextField();
        ada_algLabel = new javax.swing.JLabel();
        ada_targetLabel = new javax.swing.JLabel();
        ada_targetCBox = new javax.swing.JComboBox<>();
        ada_featLabel = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        ada_fromList = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        ada_toList = new javax.swing.JList<>();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        ada_outLabel = new javax.swing.JLabel();
        ada_outCBox = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        ada_outList = new javax.swing.JList<>();
        ada_algCBox = new javax.swing.JComboBox<>();
        dtcPanel = new javax.swing.JPanel();
        dtc_psLabel = new javax.swing.JLabel();
        dtc_psField = new javax.swing.JTextField();
        dtc_mdLabel = new javax.swing.JLabel();
        dtc_mdField = new javax.swing.JTextField();
        dtc_rsLabel = new javax.swing.JLabel();
        dtc_rsField = new javax.swing.JTextField();
        dtc_targetLabel = new javax.swing.JLabel();
        dtc_targetCBox = new javax.swing.JComboBox<>();
        dtc_featLabel = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        dtc_fromList = new javax.swing.JList<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        dtc_toList = new javax.swing.JList<>();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        dtc_outLabel = new javax.swing.JLabel();
        dtc_outCBox = new javax.swing.JComboBox<>();
        jScrollPane12 = new javax.swing.JScrollPane();
        dtc_outList = new javax.swing.JList<>();
        saPanel = new javax.swing.JPanel();
        sa_targetCBox = new javax.swing.JComboBox<>();
        sa_targetLabel = new javax.swing.JLabel();
        newTableCB = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        profilePanel = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        sidePanel = new javax.swing.JPanel();
        sideLoadPanel = new javax.swing.JPanel();
        modifyprofilList = new javax.swing.JList<>();
        sideWorkPanel = new javax.swing.JPanel();
        delSessionButton = new javax.swing.JButton();
        delTableButton = new javax.swing.JButton();
        downloadTableButton = new javax.swing.JButton();
        selectedTableLabel = new javax.swing.JLabel();
        loadedTablesListSPane = new javax.swing.JScrollPane();
        loadedTablesList = new javax.swing.JList<>();
        separator = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        showLoadPanel = new javax.swing.JMenuItem();
        logOut = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        preMenuItem = new javax.swing.JMenuItem();
        classifMenuItem = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);

        mainPanel.setPreferredSize(new java.awt.Dimension(1000, 600));
        mainPanel.setLayout(new java.awt.CardLayout());

        loadPanel.setPreferredSize(new java.awt.Dimension(1000, 600));

        separator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        loadFileUploadPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Új munkafolyamat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        fileUploadLabel.setText("Fájl feltöltés");

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
        csvPrevTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        previewScPane.setViewportView(csvPrevTable);

        newTablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        newTablePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        workUploadLabel.setText("Új tábla feltöltése: ");

        workUploadButton.setText("Feltöltés");
        workUploadButton.setToolTipText("");
        workUploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workUploadButtonActionPerformed(evt);
            }
        });

        workChoseButton.setText("Kiválaszt");
        workChoseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workChoseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newTablePanelLayout = new javax.swing.GroupLayout(newTablePanel);
        newTablePanel.setLayout(newTablePanelLayout);
        newTablePanelLayout.setHorizontalGroup(
            newTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(workUploadLabel)
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
                    .addComponent(workUploadLabel)
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

        zeroRButton.setText("Üres értékek kezelése nulla értékkel");

        meanRButton.setText("Üres értékek kezelése matematikai középpel");

        delRButton.setText("Üres értékek törlése");

        medianRButton.setText("Üres értékek kezelése az értékek mediánjával");

        modeRButton.setText("Üres értékek kezelése az értékek móduszával");

        javax.swing.GroupLayout nanPanelLayout = new javax.swing.GroupLayout(nanPanel);
        nanPanel.setLayout(nanPanelLayout);
        nanPanelLayout.setHorizontalGroup(
            nanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nanPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(nanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modeRButton)
                    .addComponent(medianRButton)
                    .addComponent(zeroRButton)
                    .addComponent(meanRButton)
                    .addComponent(delRButton))
                .addContainerGap(319, Short.MAX_VALUE))
        );
        nanPanelLayout.setVerticalGroup(
            nanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nanPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(zeroRButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(meanRButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delRButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(medianRButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modeRButton)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        parameterMainPanel.add(nanPanel, "card9");

        javax.swing.GroupLayout firstPanelLayout = new javax.swing.GroupLayout(firstPanel);
        firstPanel.setLayout(firstPanelLayout);
        firstPanelLayout.setHorizontalGroup(
            firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );
        firstPanelLayout.setVerticalGroup(
            firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        parameterMainPanel.add(firstPanel, "card2");

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
                .addContainerGap(118, Short.MAX_VALUE))
        );

        parameterMainPanel.add(sentimentPanel, "card2");

        rfs_neLabel.setText("n_estimators:");

        rfc_neField.setText("10");

        rfc_mdLabel.setText("max_depth:");

        rfc_mdField.setText("0");

        rfc_rsLabel.setText("random_state:");

        rfc_rsField.setText("0");

        rfc_njLabel.setText("n_jobs:");

        rfc_njField.setText("1");

        rfc_targetLabel.setText("Target:");

        rfc_targetCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        rfc_featLabel.setText("Features:");

        rfc_fromList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " "};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(rfc_fromList);

        rfc_toList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " "};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(rfc_toList);

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        rfc_outLabel.setText("Kimeneti tábla oszlopai");

        rfc_outCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        rfc_outList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " "};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(rfc_outList);

        javax.swing.GroupLayout rfcPanelLayout = new javax.swing.GroupLayout(rfcPanel);
        rfcPanel.setLayout(rfcPanelLayout);
        rfcPanelLayout.setHorizontalGroup(
            rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rfcPanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rfc_mdLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rfs_neLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rfc_rsLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rfc_njLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(31, 31, 31)
                .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rfc_neField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(rfc_mdField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(rfc_rsField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(rfc_njField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rfc_featLabel)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rfc_targetCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rfc_targetLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rfc_outLabel)
                    .addComponent(rfc_outCBox, 0, 140, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        rfcPanelLayout.setVerticalGroup(
            rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addGroup(rfcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rfcPanelLayout.createSequentialGroup()
                        .addComponent(rfc_targetLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rfs_neLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rfc_neField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rfc_targetCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rfc_mdLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rfc_mdField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rfc_featLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rfcPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rfc_rsLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rfc_rsField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rfc_njLabel)
                                    .addComponent(rfc_njField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(rfcPanelLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20))
                    .addGroup(rfcPanelLayout.createSequentialGroup()
                        .addComponent(rfc_outLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rfc_outCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        parameterMainPanel.add(rfcPanel, "card2");

        jScrollPane3.setViewportView(colList);

        colLabel.setText("Oszlopok");

        delColLabel.setText("Törlendő oszlopok");

        jScrollPane4.setViewportView(dropColList);

        javax.swing.GroupLayout dropcolPanelLayout = new javax.swing.GroupLayout(dropcolPanel);
        dropcolPanel.setLayout(dropcolPanelLayout);
        dropcolPanelLayout.setHorizontalGroup(
            dropcolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropcolPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(dropcolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(colLabel)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addGroup(dropcolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delColLabel))
                .addGap(19, 19, 19))
        );
        dropcolPanelLayout.setVerticalGroup(
            dropcolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropcolPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dropcolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colLabel)
                    .addComponent(delColLabel))
                .addGap(1, 1, 1)
                .addGroup(dropcolPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        parameterMainPanel.add(dropcolPanel, "card2");

        ada_neLabel.setText("n_estimators:");

        ada_neField.setText("10");

        ada_lrLabel.setText("learning_rate:");

        ada_lrField.setText("1.0");

        ada_rsLabel.setText("random_state:");

        ada_rsField.setText("0");

        ada_algLabel.setText("algorithm:");

        ada_targetLabel.setText("Target:");

        ada_targetCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ada_featLabel.setText("Features:");

        ada_fromList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " "};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(ada_fromList);

        ada_toList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " "};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane8.setViewportView(ada_toList);

        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        ada_outLabel.setText("Kimeneti tábla oszlopai");

        ada_outCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ada_outList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " "};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane9.setViewportView(ada_outList);

        ada_algCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SAMME", "SAMME.R" }));

        javax.swing.GroupLayout adaPanelLayout = new javax.swing.GroupLayout(adaPanel);
        adaPanel.setLayout(adaPanelLayout);
        adaPanelLayout.setHorizontalGroup(
            adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adaPanelLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ada_lrLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ada_neLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ada_rsLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adaPanelLayout.createSequentialGroup()
                        .addComponent(ada_algLabel)
                        .addGap(15, 15, 15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adaPanelLayout.createSequentialGroup()
                        .addComponent(ada_algCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adaPanelLayout.createSequentialGroup()
                        .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ada_lrField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ada_rsField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ada_neField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ada_featLabel)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ada_targetCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ada_targetLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ada_outLabel)
                    .addComponent(ada_outCBox, 0, 140, Short.MAX_VALUE)
                    .addComponent(jScrollPane9))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        adaPanelLayout.setVerticalGroup(
            adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addComponent(jSeparator5)
            .addGroup(adaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adaPanelLayout.createSequentialGroup()
                        .addComponent(ada_targetLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ada_neLabel)
                                .addComponent(ada_neField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ada_targetCBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ada_lrLabel)
                                .addComponent(ada_lrField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ada_featLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(adaPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ada_rsLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ada_rsField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ada_algLabel)
                                    .addComponent(ada_algCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(adaPanelLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20))
                    .addGroup(adaPanelLayout.createSequentialGroup()
                        .addComponent(ada_outLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ada_outCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        parameterMainPanel.add(adaPanel, "card2");

        dtc_psLabel.setText("presort:");

        dtc_psField.setText("false");

        dtc_mdLabel.setText("max_depth:");

        dtc_mdField.setText("0");

        dtc_rsLabel.setText("random_state:");

        dtc_rsField.setText("0");

        dtc_targetLabel.setText("Target:");

        dtc_targetCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dtc_featLabel.setText("Features:");

        dtc_fromList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " "};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane10.setViewportView(dtc_fromList);

        dtc_toList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " "};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane11.setViewportView(dtc_toList);

        jSeparator6.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator7.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        dtc_outLabel.setText("Kimeneti tábla oszlopai");

        dtc_outCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        dtc_outList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " "};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane12.setViewportView(dtc_outList);

        javax.swing.GroupLayout dtcPanelLayout = new javax.swing.GroupLayout(dtcPanel);
        dtcPanel.setLayout(dtcPanelLayout);
        dtcPanelLayout.setHorizontalGroup(
            dtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dtcPanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(dtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtc_mdLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dtc_psLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dtc_rsLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(31, 31, 31)
                .addGroup(dtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dtc_psField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(dtc_mdField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(dtc_rsField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dtc_featLabel)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(dtc_targetLabel)
                    .addComponent(dtc_targetCBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(dtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dtc_outLabel)
                    .addComponent(dtc_outCBox, 0, 140, Short.MAX_VALUE)
                    .addComponent(jScrollPane12))
                .addGap(15, 15, 15))
        );
        dtcPanelLayout.setVerticalGroup(
            dtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator6)
            .addComponent(jSeparator7)
            .addGroup(dtcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dtcPanelLayout.createSequentialGroup()
                        .addComponent(dtc_targetLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtc_psLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dtc_psField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dtc_targetCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(dtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtc_mdLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dtc_mdField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtc_featLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(dtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dtcPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(dtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dtc_rsLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dtc_rsField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(dtcPanelLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(dtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20))
                    .addGroup(dtcPanelLayout.createSequentialGroup()
                        .addComponent(dtc_outLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtc_outCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        parameterMainPanel.add(dtcPanel, "card2");

        sa_targetCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        sa_targetCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sa_targetCBoxActionPerformed(evt);
            }
        });

        sa_targetLabel.setText("Elemezni kívánt szöveget tartalmazó oszlop:");

        javax.swing.GroupLayout saPanelLayout = new javax.swing.GroupLayout(saPanel);
        saPanel.setLayout(saPanelLayout);
        saPanelLayout.setHorizontalGroup(
            saPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sa_targetLabel)
                .addGap(18, 18, 18)
                .addComponent(sa_targetCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        saPanelLayout.setVerticalGroup(
            saPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(saPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sa_targetLabel)
                    .addComponent(sa_targetCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        parameterMainPanel.add(saPanel, "card2");

        newTableCB.setText("Új tábla generálás");

        javax.swing.GroupLayout tablesPanelLayout = new javax.swing.GroupLayout(tablesPanel);
        tablesPanel.setLayout(tablesPanelLayout);
        tablesPanelLayout.setHorizontalGroup(
            tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablesPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(classifierLabel)
                    .addComponent(classifierCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(operationCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(operationLabel)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablesPanelLayout.createSequentialGroup()
                        .addComponent(newTableCB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(doButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newTableCB)
                        .addGap(19, 19, 19)
                        .addComponent(classifierLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(classifierCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(doButton)))
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
                .addComponent(previewScPane, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
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
                .addGap(0, 8, Short.MAX_VALUE))
        );

        sidePanel.setLayout(new java.awt.CardLayout());

        modifyprofilList.setBackground(new java.awt.Color(240, 240, 240));
        modifyprofilList.setBorder(javax.swing.BorderFactory.createTitledBorder("Profil szerkesztése"));
        modifyprofilList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Felhasználónév módosítása", "Jelszó módosítása" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });

        javax.swing.GroupLayout sideLoadPanelLayout = new javax.swing.GroupLayout(sideLoadPanel);
        sideLoadPanel.setLayout(sideLoadPanelLayout);
        sideLoadPanelLayout.setHorizontalGroup(
            sideLoadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideLoadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(modifyprofilList, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );
        sideLoadPanelLayout.setVerticalGroup(
            sideLoadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideLoadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(modifyprofilList, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(317, Short.MAX_VALUE))
        );

        sidePanel.add(sideLoadPanel, "card2");

        delSessionButton.setText("Törlés");
        delSessionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delSessionButtonActionPerformed(evt);
            }
        });

        delTableButton.setText("Törlés");
        delTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delTableButtonActionPerformed(evt);
            }
        });

        downloadTableButton.setText("Letöltés");
        downloadTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadTableButtonActionPerformed(evt);
            }
        });

        selectedTableLabel.setText("Kijelölt tábla:");

        loadedTablesListSPane.setBorder(null);

        loadedTablesList.setBackground(new java.awt.Color(240, 240, 240));
        loadedTablesList.setBorder(javax.swing.BorderFactory.createTitledBorder("Betöltött táblák"));
        loadedTablesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " "};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        loadedTablesListSPane.setViewportView(loadedTablesList);

        javax.swing.GroupLayout sideWorkPanelLayout = new javax.swing.GroupLayout(sideWorkPanel);
        sideWorkPanel.setLayout(sideWorkPanelLayout);
        sideWorkPanelLayout.setHorizontalGroup(
            sideWorkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideWorkPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sideWorkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sideWorkPanelLayout.createSequentialGroup()
                        .addComponent(delTableButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(downloadTableButton))
                    .addGroup(sideWorkPanelLayout.createSequentialGroup()
                        .addGroup(sideWorkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(delSessionButton)
                            .addComponent(selectedTableLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(loadedTablesListSPane)
        );
        sideWorkPanelLayout.setVerticalGroup(
            sideWorkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideWorkPanelLayout.createSequentialGroup()
                .addComponent(loadedTablesListSPane, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectedTableLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sideWorkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delTableButton)
                    .addComponent(downloadTableButton))
                .addGap(177, 177, 177)
                .addComponent(delSessionButton)
                .addContainerGap())
        );

        sidePanel.add(sideWorkPanel, "card2");

        fileMenu.setText("Fájl");

        showLoadPanel.setText("Főoldal");
        showLoadPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showLoadPanelActionPerformed(evt);
            }
        });
        fileMenu.add(showLoadPanel);

        logOut.setText("Kijelentkezés");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });
        fileMenu.add(logOut);

        jMenuBar1.add(fileMenu);

        helpMenu.setText("Súgó");

        preMenuItem.setText("Előfeldolgozás");
        preMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(preMenuItem);

        classifMenuItem.setText("Osztályozók");
        classifMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classifMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(classifMenuItem);
        helpMenu.add(jSeparator9);

        jMenuItem1.setText("Névjegy");

        helpMenu.add(jMenuItem1);

        jMenuBar1.add(helpMenu);

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
                .addGap(105, 105, 105)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected void doButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doButtonActionPerformed
        outDatas.clear();
        boolean cansend = false;

        if (selectedTable == null) {
            JOptionPane.showMessageDialog(this, "Kérem válasszon ki egy táblát!");
        } else {
            switch (selectedOperation) {
                case "ada:":
                    if (checkParameters(ada_neField, "Integer") && checkParameters(ada_lrField, "Float") && checkParameters(ada_rsField, "Integer")) {
                        String[] ada_parameters = {ada_neField.getText(), ada_lrField.getText(), ada_algCBox.getSelectedItem().toString(), ada_rsField.getText()};
                        cansend = setClassifierParameters(selectedOperation, ada_parameters, ada_targetCBox, ada_toList, ada_outList);
                    }
                    break;
                case "rfc:":
                    if (checkParameters(rfc_neField, "Integer") && checkParameters(rfc_mdField, "Integer") && checkParameters(rfc_rsField, "Integer") && checkParameters(rfc_njField, "Integer")) {
                        String[] rfc_parameters = {rfc_mdField.getText(), rfc_neField.getText(), rfc_rsField.getText(), rfc_njField.getText()};
                        cansend = setClassifierParameters(selectedOperation, rfc_parameters, rfc_targetCBox, rfc_toList, rfc_outList);
                    }
                    break;
                case "dtc:":
                    if (checkParameters(dtc_psField, "Bool") && checkParameters(dtc_mdField, "Integer") && checkParameters(dtc_rsField, "Integer")) {
                        String[] dtc_parameters = {dtc_psField.getText(), dtc_mdField.getText(), dtc_rsField.getText()};
                        cansend = setClassifierParameters(selectedOperation, dtc_parameters, dtc_targetCBox, dtc_toList, dtc_outList);
                    }
                    break;
                case "san:":
                    String target = sa_targetCBox.getSelectedItem().toString();
                    insertIntoBuffer(selectedOperation, "true", Integer.toString(currentTaskID), selectedTable, target);
                    cansend = true;
                    break;
                case "delc:":
                    String[] colToDel = new String[dropColList.getModel().getSize()];
                    for (int i = 0; i < dropColList.getModel().getSize(); i++) {
                        colToDel[i] = dropColList.getModel().getElementAt(i);
                    }
                    insertIntoBuffer(selectedOperation, Boolean.toString(newTableCB.isSelected()), Integer.toString(currentTaskID), selectedTable, colToDel);
                    cansend = true;
                    break;
                case "nanv:":
                    String mode = getSelectedRButton(nanRadioGroup);
                    insertIntoBuffer(selectedOperation, Boolean.toString(newTableCB.isSelected()), Integer.toString(currentTaskID), selectedTable, mode);
                    cansend = true;
                    break;
                case "fact:":
                    System.out.println(newTableCB.isSelected());
                    insertIntoBuffer(selectedOperation, Boolean.toString(newTableCB.isSelected()), Integer.toString(currentTaskID), selectedTable);
                    cansend = true;
                    break;
                case "norm:":
                    insertIntoBuffer(selectedOperation, Boolean.toString(newTableCB.isSelected()), Integer.toString(currentTaskID), selectedTable);
                    cansend = true;
                    break;
                case "ftsl:":
                    String treshold = JOptionPane.showInputDialog(this, "Küszöbérték: ");
                    try {
                        float temp = Float.parseFloat(treshold);
                        insertIntoBuffer(selectedOperation, Boolean.toString(newTableCB.isSelected()), Integer.toString(currentTaskID), selectedTable, treshold);
                        cansend = true;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "A(z) küszöbérték típusa nem megfelelő. Kérem ellenőrizze, hogy számot adott-e meg.");
                    }
                    break;
                default:
                    break;
            }
            if (cansend) {
                outDatas = bufferOutput;
                lf = new LoadingFrame(this, "pythonCall", null);
                lf.setVisible(true);
            }
        }
    }//GEN-LAST:event_doButtonActionPerformed

    protected void workUploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workUploadButtonActionPerformed
        path = workPathField.getText();

        selectedTable = getFilename(path);
        String extension = getExtension(selectedTable);
        if(extension.equals("csv")){
            if (selectedTable.equals("-1")) {
                JOptionPane.showMessageDialog(this, "Kérem adjon meg feltöltendő file-t!");
            } else {
                outDatas = readFromCsv(path, true);
            }
        }else{
            workPathField.setText("");
            JOptionPane.showMessageDialog(this, "Adjon meg egy csv file-t!");
        }
    }//GEN-LAST:event_workUploadButtonActionPerformed

    protected void showLoadPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showLoadPanelActionPerformed
        operationCBox.setSelectedItem("...");
        classifierCBox.setSelectedItem("...");
        outDatas.add("wrk:");
        //outcolsList kiürítése
        changeMainPanels(loadPanel, sideLoadPanel);
    }//GEN-LAST:event_showLoadPanelActionPerformed

    protected void operationCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operationCBoxActionPerformed
        String chosen = getSelectedOperation();
        if (chosen != null) {
            switch (chosen) {
                case "Faktorizálás":
                    changePanels(firstPanel);
                    selectedOperation = "fact:";
                    break;
                case "Normalizálás":
                    changePanels(firstPanel);
                    selectedOperation = "norm:";
                    break;
                case "Feature kiválasztás":
                    changePanels(firstPanel);
                    selectedOperation = "ftsl:";
                    break;
                case "Oszlopok törlése":
                    changePanels(dropcolPanel);
                    selectedOperation = "delc:";
                    break;
                case "Üres értékek kezelése":
                    changePanels(nanPanel);
                    selectedOperation = "nanv:";
                    break;
            }
        }
    }//GEN-LAST:event_operationCBoxActionPerformed

    protected void classifierCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classifierCBoxActionPerformed
        String chosen = getSelectedClassifier();
        if (chosen == null && selectedTable == null) {
            //  donothing
        } else {
            switch (chosen) {
                case "AdaBoost Classifier":
                    changePanels(adaPanel);
                    getOutCol(ada_outCBox, ada_outList);
                    setFromToList(ada_fromList, ada_toList, ada_targetCBox);
                    selectedOperation = "ada:";
                    break;
                case "Random Forest Classifier":
                    changePanels(rfcPanel);
                    getOutCol(rfc_outCBox, rfc_outList);
                    setFromToList(rfc_fromList, rfc_toList, rfc_targetCBox);
                    selectedOperation = "rfc:";
                    break;
                case "Decision Tree Classifier":
                    changePanels(dtcPanel);
                    getOutCol(dtc_outCBox, dtc_outList);
                    setFromToList(dtc_fromList, dtc_toList, dtc_targetCBox);
                    selectedOperation = "dtc:";
                    break;
                case "Sentiment Analysis":
                    changePanels(saPanel);
                    sa_targetCBox.removeAllItems();
                    for (String c : columns) {
                        sa_targetCBox.addItem(c);
                    }
                    selectedOperation = "san:";
                    break;
                default:
                    changePanels(firstPanel);
                    break;
            }
        }
    }//GEN-LAST:event_classifierCBoxActionPerformed

    protected void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        path = filepathField.getText();
        selectedTable = getFilename(path);
        String extension = getExtension(selectedTable);
        if(extension.equals("csv")){
            System.out.println("selected: " + selectedTable);
            if (selectedTable.equals("-1")) {
                JOptionPane.showMessageDialog(this, "Kérem adjon meg feltöltendő file-t!");
            } else {
                currentTask = (JOptionPane.showInputDialog(this, "Munkafolyamat neve: ")).replaceAll(" ", "_");
                if (currentTask.equals("")) {
                    JOptionPane.showMessageDialog(this, "Adjon meg nevet!");
                } else if(currentTask == null){
                    //do nothing
                }
                outDatas = readFromCsv(path, false);
            }
            filepathField.setText("");

            lf = new LoadingFrame(this, "tableUpload", null);
            lf.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Adjon meg egy .csv file-t!");
        }
    }//GEN-LAST:event_uploadButtonActionPerformed

    protected void choseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choseButtonActionPerformed
        FileManager fm = new FileManager();
        fm.run();
        filepathField.setText(fm.getAbsoluteFilePath());
    }//GEN-LAST:event_choseButtonActionPerformed

    protected void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        outDatas.clear();
        int n = JOptionPane.showConfirmDialog(this, "Biztos ki szeretne jelentkezni?", "Kijelentkezés", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            outDatas.add("bye:");
        }
    }//GEN-LAST:event_logOutActionPerformed

    protected void workChoseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workChoseButtonActionPerformed
        FileManager fm = new FileManager();
        fm.run();
        workPathField.setText(fm.getAbsoluteFilePath());
    }//GEN-LAST:event_workChoseButtonActionPerformed

    protected void delSessionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delSessionButtonActionPerformed
        outDatas.clear();
        int n = JOptionPane.showConfirmDialog(this, "Biztos törli?", "Munkamenet törlés", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            outDatas.add("dels:");
            outDatas.add(Integer.toString(currentTaskID));
            changeMainPanels(loadPanel, sideLoadPanel);
        }
    }//GEN-LAST:event_delSessionButtonActionPerformed

    protected void delTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delTableButtonActionPerformed
        int n = JOptionPane.showConfirmDialog(this, "Biztos törli?", "Törlési megerősítés", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            outDatas.clear();
            outDatas.add("delt:");
            outDatas.add(Integer.toString(currentTaskID));
            outDatas.add(selectedTable);
        }
        changePanels(firstPanel);
    }//GEN-LAST:event_delTableButtonActionPerformed

    protected void downloadTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadTableButtonActionPerformed
        outDatas.clear();
        outDatas.add("tdl:");
        outDatas.add(Integer.toString(currentTaskID));
        outDatas.add(selectedTable);
    }//GEN-LAST:event_downloadTableButtonActionPerformed

    protected void sa_targetCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sa_targetCBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sa_targetCBoxActionPerformed

    protected void preMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preMenuItemActionPerformed

    }//GEN-LAST:event_preMenuItemActionPerformed

    protected void classifMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classifMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classifMenuItemActionPerformed

    protected void informMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informMenuItemActionPerformed
        JOptionPane.showMessageDialog(null, "Készítette Gyenes Adrienn (EP9KP0) \n Eötvös Loránd Tudományegyetem 2017");
    }//GEN-LAST:event_informMenuItemActionPerformed

    protected void addExitOption() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "Biztos ki szeretnél lépni?",
                        "Kilépés", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    outDatas.add("bye:");
                }
            }
        });
    }

    // </editor-fold>
    //Combo-box feltöltő fv-ek
    // <editor-fold defaultstate="collapsed">
    protected void fillOperationsList() {
        ArrayList<String> operations = new ArrayList<>();

        operationCBox.removeAllItems();
        operations.add("..."); //első üres legyen
        operations.add("Üres értékek kezelése");
        operations.add("Faktorizálás");
        operations.add("Normalizálás");
        operations.add("Oszlopok törlése");
        operations.add("Feature kiválasztás");

        operations.forEach((str) -> {
            operationCBox.addItem(str);
        });
    }

    protected void fillClassifierList() {
        ArrayList<String> classifiers = new ArrayList<>();

        classifierCBox.removeAllItems();
        classifiers.add("...");
        classifiers.add("AdaBoost Classifier");
        classifiers.add("Random Forest Classifier");
        classifiers.add("Decision Tree Classifier");
        classifiers.add("Gradient Tree Boost");
        classifiers.add("Sentiment Analysis");

        classifiers.forEach((str) -> {
            classifierCBox.addItem(str);
        });
    }

    //</editor-fold>
    protected void insertIntoBuffer(String identifier, String newtable, String currentTaskID, String selectedTable, String... other) {
        bufferOutput.clear();
        bufferOutput.add(identifier);
        bufferOutput.add(newtable); 
        bufferOutput.add(currentTaskID);
        bufferOutput.add(selectedTable);
        bufferOutput.addAll(Arrays.asList(other));
    }

    protected void fillPrevTable(String[] cols, ArrayList<String[]> items) {
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        items.forEach((str) -> {
            model.addRow(str);
        });
        csvPrevTable.setModel(model);
        columns = new String[cols.length];
        for (int i = 0; i < cols.length; i++) {
            csvPrevTable.getColumnModel().getColumn(i).setMinWidth(75);
            columns[i] = cols[i].replaceAll("\"", "");
        }
        csvPrevTable.setDefaultEditor(Object.class, null);

        colModel = new DefaultListModel<>();
        dropColModel = new DefaultListModel<>();

        colList.setModel(colModel);
        dropColList.setModel(dropColModel);

        for (String c : cols) {
            colModel.addElement(c);
        }

    }

    protected void setScrollPane() {
        csvPrevTable.getParent().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(final ComponentEvent e) {
                if (csvPrevTable.getPreferredSize().width < csvPrevTable.getParent().getWidth()) {
                    csvPrevTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                } else {
                    csvPrevTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                }
            }
        });
    }

    protected ArrayList<String> readFromCsv(String path, boolean work) {
        ArrayList<String> csv = new ArrayList<>();
            if (work) {
                csv.add("wcsv:");
                csv.add(Integer.toString(currentTaskID) + ":");
            } else {
                csv.add("csv:");
                csv.add(currentTask + ":");
            }
               
        String filename;

        BufferedReader br = null;
        try {
            File file = new File(path);
            br = new BufferedReader(new FileReader(file));
            filename = getFilename(path);
            csv.add(filename + ":");
            String line = br.readLine();
            line = line.replaceAll("\"", "");
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
                    csv.add(">>flag<<");
                }
                if (index < 500) {
                    String[] items_temp = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
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

    //GETTEREK-SETTEREK
    // <editor-fold defaultstate="collapsed">
    protected void loadSelectedTask() {
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    try {
                        String selected = list.getComponentAt(e.getPoint()).toString().split("    -    ")[1];
                        currentTaskID = Integer.parseInt((list.getComponentAt(e.getPoint()).toString().split("    -    ")[0]).split("selected=")[1]);
                        currentTask = list.getComponentAt(e.getPoint()).toString().split("    -    ")[1];
                        outDatas.clear();
                        outDatas.add("old:");
                        outDatas.add(Integer.toString(currentTaskID));
                        outDatas.add(selected);

                        DefaultTableModel model = new DefaultTableModel(0, 0);
                        csvPrevTable.setModel(model);
                    } catch (ArrayIndexOutOfBoundsException ex) {
                    }
                }
            }
        });
    }

    protected void editProfil() {
        modifyprofilList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    try {
                        Object value = modifyprofilList.getModel().getElementAt(modifyprofilList.locationToIndex(e.getPoint()));

                        if ("Felhasználónév módosítása".equals(value)) {
                            String newusername = JOptionPane.showInputDialog(null, "Új felhasználónév: ");
                            if (newusername.length() < 3) {
                                JOptionPane.showMessageDialog(null, "Felhasználónév hossza nem megfelelő.(min. 3 karakter)");
                            } else {
                                if (!newusername.equals(loggedUser)) {
                                    outDatas.clear();
                                    outDatas.add("mdu:");
                                    outDatas.add(newusername);
                                }
                            }
                        } else {
                            String temp = JOptionPane.showInputDialog(null, "Új jelszó: ");
                            String passFirst = "", passSecond = "";
                            if (temp != null) {
                                passFirst = encrypt(temp);

                                temp = JOptionPane.showInputDialog(null, "Jelszó újra: ");
                                if (temp != null) {
                                    passSecond = encrypt(temp);
                                }
                            }
                            if (!passFirst.equals(passSecond)) {
                                JOptionPane.showMessageDialog(null, "A két jelszó nem egyezik!");
                            } else if (passFirst.equals(encrypt(""))) {
                                JOptionPane.showMessageDialog(null, "A jelszó nem lehet üres karakter!");
                            } else {
                                outDatas.clear();
                                outDatas.add("mdp:");
                                outDatas.add(passFirst);
                            }
                        }

                    } catch (ArrayIndexOutOfBoundsException ex) {
                    } catch (HeadlessException ex) {
                        Logger.getLogger(WorkWindowFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    protected void addColToDrop() {

        colList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    try {
                        String selected = ((String) colList.getModel().getElementAt(colList.locationToIndex(e.getPoint())));

                        dropColModel.addElement(selected);
                        colModel.removeElement(selected);
                    } catch (ArrayIndexOutOfBoundsException ex) {

                    }
                }
            }
        });
    }

    protected void removeColToDrop() {
        dropColList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    try {
                        String selected = ((String) dropColList.getModel().getElementAt(dropColList.locationToIndex(e.getPoint())));

                        colModel.addElement(selected);
                        dropColModel.removeElement(selected);
                    } catch (ArrayIndexOutOfBoundsException ex) {
                    }
                }
            }
        });
    }

    protected void getSelectedTable() {
        loadedTablesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    try {
                        String selected = ((String) loadedTablesList.getModel().getElementAt(loadedTablesList.locationToIndex(e.getPoint())));

                        classifierCBox.setEnabled(true);
                        operationCBox.setEnabled(true);
                        outDatas.clear();
                        outDatas.add("ldt:");
                        outDatas.add(Integer.toString(currentTaskID));
                        outDatas.add(selected);
                        selectedTable = selected;

                        delTableButton.setEnabled(true);
                        downloadTableButton.setEnabled(true);
                    } catch (ArrayIndexOutOfBoundsException ex) {

                    }
                }
            }
        });
    }

    protected String getFilename(String path) {
        String returnvalue;
        String[] spl = path.split(Pattern.quote("\\"));
        if(spl.length==0){
            returnvalue = "-1";
        }else{
            returnvalue = spl[spl.length - 1].replaceAll(" ", "_");
        }
        return returnvalue;
    }
    
    protected String getExtension(String filename){
        String returnvalue;
        String[] spl = filename.split(Pattern.quote("."));
        if(spl.length ==0){
            returnvalue = "-1";
        }else{
            returnvalue =  spl[spl.length -1];
        }
        return returnvalue;
    }
  
    protected String getSelectedOperation() {
        return operationCBox.getItemAt(operationCBox.getSelectedIndex());
    }

    protected String getSelectedClassifier() {
        return classifierCBox.getItemAt(classifierCBox.getSelectedIndex());
    }

    protected void setNanRadioButtons() {
        nanRadioGroup = new ButtonGroup();
        zeroRButton.setActionCommand("zero");
        nanRadioGroup.add(zeroRButton);
        meanRButton.setActionCommand("mean");
        nanRadioGroup.add(meanRButton);
        delRButton.setActionCommand("del");
        nanRadioGroup.add(delRButton);
        medianRButton.setActionCommand("median");
        nanRadioGroup.add(medianRButton);
        modeRButton.setActionCommand("modusz");
        nanRadioGroup.add(modeRButton);
    }

    protected String getSelectedRButton(ButtonGroup bg) {
        return bg.getSelection().getActionCommand();
    }

    protected void changePanels(JPanel visiblePanel) {
        JPanel[] panels = {firstPanel, adaPanel, sentimentPanel, rfcPanel, dropcolPanel, nanPanel, dtcPanel, saPanel};
        for (JPanel p : panels) {
            if (visiblePanel == p) {
                p.setVisible(true);
            } else {
                p.setVisible(false);
            }
        }
    }

    protected void changeMainPanels(JPanel visiblePanel, JPanel visibleSidePanel) {
        JPanel[] panels = {loadPanel, sideLoadPanel, workPanel, sideWorkPanel};
        for (JPanel p : panels) {
            if (visiblePanel == p || visibleSidePanel == p) {
                p.setVisible(true);
            } else {
                p.setVisible(false);
            }
        }
    }

    protected boolean setClassifierParameters(String classifier, String[] parameters, JComboBox<String> target, JList<String> features, JList<String> outcols) {
        String[] feat = new String[features.getModel().getSize()];
        for (int i = 0; i < features.getModel().getSize(); i++) {
            feat[i] = features.getModel().getElementAt(i);
        }

        String[] out = new String[outcols.getModel().getSize()];
        for (int i = 0; i < outcols.getModel().getSize(); i++) {
            out[i] = outcols.getModel().getElementAt(i);
        }
        if (out.length == 0 || feat.length == 0) {
            JOptionPane.showMessageDialog(null, "A features set vagy a kimeneti tábla oszlopai üresek. Kérjük ellenőrizze.");
            return false;
        } else {
            bufferOutput.clear();
            bufferOutput.add(classifier);
            bufferOutput.add(selectedTable);
            bufferOutput.add(target.getSelectedItem().toString());
            bufferOutput.add(Integer.toString(parameters.length));
            bufferOutput.addAll(Arrays.asList(parameters));
            bufferOutput.add(Integer.toString(feat.length));
            bufferOutput.addAll(Arrays.asList(feat));
            bufferOutput.add(Integer.toString(out.length));
            bufferOutput.addAll(Arrays.asList(out));
            return true;
        }
    }

    protected void getOutCol(JComboBox<String> cb, JList<String> out) {
        DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
        cb.setModel(cbModel);
        cbModel.removeAllElements();
        cbModel.addElement(" ");

        for (String c : columns) {
            cbModel.addElement(c);
        }

        DefaultListModel outlistModel = new DefaultListModel();
        outlistModel.removeAllElements();
        outlistModel.addElement(" ");
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean caninsert = true;
                out.setModel(outlistModel);
                String selected = cb.getSelectedItem().toString();
                if (!" ".equals(selected)) {
                    String[] inlist = outlistModel.toString().replaceAll("[\\[\\]]", "").split(", ");
                    for (String in : inlist) {
                        if (in.equals(selected)) {
                            caninsert = false;
                        }
                    }
                    if (caninsert) {
                        if (" ".equals(outlistModel.getElementAt(0).toString())) {
                            outlistModel.removeElementAt(0);
                        }
                        outlistModel.addElement(selected);
                    }
                }
            }
        });
    }

    protected void setFromToList(JList<String> fromlist, JList<String> tolist, JComboBox<String> target) {

        DefaultListModel fromlistModel = new DefaultListModel();
        DefaultListModel tolistModel = new DefaultListModel();
        DefaultComboBoxModel targetModel = new DefaultComboBoxModel();

        fromlistModel.removeAllElements();
        tolistModel.removeAllElements();
        targetModel.removeAllElements();

        for (String c : columns) {
            targetModel.addElement(c);
        }

        target.setModel(targetModel);
        tolist.setModel(tolistModel);
        fromlist.setModel(fromlistModel);

        target.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = target.getSelectedItem().toString();
                if (selected != null) {
                    fromlistModel.removeAllElements();
                    tolistModel.removeElement(selected);
                    for (String c : columns) {
                        if (!c.equals(selected)) {
                            fromlistModel.addElement(c);
                            fromlistModel.removeElement(selected);
                        }
                    }
                }
            }
        });

        fromlist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boolean caninsert = true;
                if (e.getClickCount() == 1) {
                    try {
                        String selected = ((String) fromlist.getModel().getElementAt(fromlist.locationToIndex(e.getPoint())));

                        String[] inlist = tolistModel.toString().replaceAll("[\\[\\]]", "").split(", ");
                        for (String in : inlist) {
                            if (in.equals(selected)) {
                                caninsert = false;
                            }
                        }
                        if (caninsert) {
                            tolistModel.addElement(selected);
                        }
                        fromlistModel.removeElement(selected);

                    } catch (ArrayIndexOutOfBoundsException ex) {

                    }
                }
            }
        });

        tolist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boolean caninsert = true;
                if (e.getClickCount() == 1) {
                    try {
                        String selected = ((String) tolist.getModel().getElementAt(tolist.locationToIndex(e.getPoint())));
                        String[] inlist = fromlistModel.toString().replaceAll("[\\[\\]]", "").split(", ");
                        for (String in : inlist) {
                            if (in.equals(selected)) {
                                caninsert = false;
                            }
                        }
                        if (caninsert) {
                            fromlistModel.addElement(selected);
                        }
                        tolistModel.removeElement(selected);
                    } catch (ArrayIndexOutOfBoundsException ex) {
                    }
                }
            }
        });
    }

    protected boolean checkParameters(JTextField text, String expectedType) {
        boolean returnvalue = true;
        if (null != expectedType) {
            switch (expectedType) {
                case "String":
                    break;
                case "Integer":
                    try {
                        Integer.parseInt(text.getText());
                    } catch (NumberFormatException e) {
                        returnvalue = false;
                        JOptionPane.showMessageDialog(null, "A(z) " + text.getName() + " típusa nem megfelelő. Kérem ellenőrizze, hogy egész számot adott-e meg.");
                    }
                    break;
                case "Float":
                    try {
                        Float.parseFloat(text.getText());
                    } catch (NumberFormatException e) {
                        returnvalue = false;
                        JOptionPane.showMessageDialog(null, "A(z) " + text.getName() + " típusa nem megfelelő. Kérem ellenőrizze, hogy számot adott-e meg.");
                    }
                    break;
                case "Bool":
                    if (text.getText().equals("True") || text.getText().equals("true") || text.getText().equals("False") || text.getText().equals("false")) {
                        returnvalue = true;
                    } else {
                        returnvalue = false;
                        JOptionPane.showMessageDialog(null, "A(z) " + text.getName() + " típusa nem megfelelő. Kérem ellenőrizze, hogy logikai értéket adott-e meg.");
                    }
                    break;
                default:
                    break;
            }
        }
        return returnvalue;
    }

    protected void setTextFieldNames() {
        ada_neField.setName("n_estimators");
        ada_lrField.setName("learning_rate");
        ada_rsField.setName("random_state");

        rfc_neField.setName("n_estiomators");
        rfc_mdField.setName("max_depth");
        rfc_rsField.setName("random_state");
        rfc_njField.setName("n_jobs");

        dtc_psField.setName("presort");
        dtc_mdField.setName("max_depth");
        dtc_rsField.setName("random_state");
    }

    protected String encrypt(String pass) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digested.length; i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
        }
        return null;
    }
    // </editor-fold>
    //VARIABLES
    // <editor-fold defaultstate="collapsed">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JPanel adaPanel;
    protected javax.swing.JComboBox<String> ada_algCBox;
    protected javax.swing.JLabel ada_algLabel;
    protected javax.swing.JLabel ada_featLabel;
    protected javax.swing.JList<String> ada_fromList;
    protected javax.swing.JTextField ada_lrField;
    protected javax.swing.JLabel ada_lrLabel;
    protected javax.swing.JTextField ada_neField;
    protected javax.swing.JLabel ada_neLabel;
    protected javax.swing.JComboBox<String> ada_outCBox;
    protected javax.swing.JLabel ada_outLabel;
    protected javax.swing.JList<String> ada_outList;
    protected javax.swing.JTextField ada_rsField;
    protected javax.swing.JLabel ada_rsLabel;
    protected javax.swing.JComboBox<String> ada_targetCBox;
    protected javax.swing.JLabel ada_targetLabel;
    protected javax.swing.JList<String> ada_toList;
    protected javax.swing.JButton choseButton;
    protected javax.swing.JMenuItem classifMenuItem;
    protected javax.swing.JComboBox<String> classifierCBox;
    protected javax.swing.JLabel classifierLabel;
    protected javax.swing.JLabel colLabel;
    protected javax.swing.JList<String> colList;
    protected javax.swing.JTable csvPrevTable;
    protected javax.swing.JLabel delColLabel;
    protected javax.swing.JRadioButton delRButton;
    protected javax.swing.JButton delSessionButton;
    protected javax.swing.JButton delTableButton;
    protected javax.swing.JButton doButton;
    protected javax.swing.JButton downloadTableButton;
    protected javax.swing.JList<String> dropColList;
    protected javax.swing.JPanel dropcolPanel;
    protected javax.swing.JPanel dtcPanel;
    protected javax.swing.JLabel dtc_featLabel;
    protected javax.swing.JList<String> dtc_fromList;
    protected javax.swing.JTextField dtc_mdField;
    protected javax.swing.JLabel dtc_mdLabel;
    protected javax.swing.JComboBox<String> dtc_outCBox;
    protected javax.swing.JLabel dtc_outLabel;
    protected javax.swing.JList<String> dtc_outList;
    protected javax.swing.JTextField dtc_psField;
    protected javax.swing.JLabel dtc_psLabel;
    protected javax.swing.JTextField dtc_rsField;
    protected javax.swing.JLabel dtc_rsLabel;
    protected javax.swing.JComboBox<String> dtc_targetCBox;
    protected javax.swing.JLabel dtc_targetLabel;
    protected javax.swing.JList<String> dtc_toList;
    protected javax.swing.JMenu fileMenu;
    protected javax.swing.JLabel fileUploadLabel;
    protected javax.swing.JTextField filepathField;
    protected javax.swing.JPanel firstPanel;
    protected javax.swing.JMenu helpMenu;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JMenuBar jMenuBar1;
    protected javax.swing.JMenuItem jMenuItem1;
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JScrollPane jScrollPane10;
    protected javax.swing.JScrollPane jScrollPane11;
    protected javax.swing.JScrollPane jScrollPane12;
    protected javax.swing.JScrollPane jScrollPane2;
    protected javax.swing.JScrollPane jScrollPane3;
    protected javax.swing.JScrollPane jScrollPane4;
    protected javax.swing.JScrollPane jScrollPane5;
    protected javax.swing.JScrollPane jScrollPane6;
    protected javax.swing.JScrollPane jScrollPane7;
    protected javax.swing.JScrollPane jScrollPane8;
    protected javax.swing.JScrollPane jScrollPane9;
    protected javax.swing.JSeparator jSeparator1;
    protected javax.swing.JSeparator jSeparator2;
    protected javax.swing.JSeparator jSeparator3;
    protected javax.swing.JSeparator jSeparator4;
    protected javax.swing.JSeparator jSeparator5;
    protected javax.swing.JSeparator jSeparator6;
    protected javax.swing.JSeparator jSeparator7;
    protected javax.swing.JPopupMenu.Separator jSeparator9;
    protected javax.swing.JTable jTable1;
    protected java.awt.List list;
    protected javax.swing.JPanel loadFileUploadPanel;
    protected javax.swing.JPanel loadOldWorkPanel;
    protected javax.swing.JPanel loadPanel;
    protected javax.swing.JList<String> loadedTablesList;
    protected javax.swing.JScrollPane loadedTablesListSPane;
    protected javax.swing.JMenuItem logOut;
    protected javax.swing.JPanel mainPanel;
    protected javax.swing.JRadioButton meanRButton;
    protected javax.swing.JRadioButton medianRButton;
    protected javax.swing.JRadioButton modeRButton;
    protected javax.swing.JList<String> modifyprofilList;
    protected javax.swing.JPanel nanPanel;
    protected javax.swing.JCheckBox newTableCB;
    protected javax.swing.JPanel newTablePanel;
    protected javax.swing.JScrollPane oldWorkSPane;
    protected javax.swing.JComboBox<String> operationCBox;
    protected javax.swing.JLabel operationLabel;
    protected javax.swing.JPanel parameterMainPanel;
    protected javax.swing.JMenuItem preMenuItem;
    protected javax.swing.JScrollPane previewScPane;
    protected javax.swing.JPanel profilePanel;
    protected javax.swing.JPanel rfcPanel;
    protected javax.swing.JLabel rfc_featLabel;
    protected javax.swing.JList<String> rfc_fromList;
    protected javax.swing.JTextField rfc_mdField;
    protected javax.swing.JLabel rfc_mdLabel;
    protected javax.swing.JTextField rfc_neField;
    protected javax.swing.JTextField rfc_njField;
    protected javax.swing.JLabel rfc_njLabel;
    protected javax.swing.JComboBox<String> rfc_outCBox;
    protected javax.swing.JLabel rfc_outLabel;
    protected javax.swing.JList<String> rfc_outList;
    protected javax.swing.JTextField rfc_rsField;
    protected javax.swing.JLabel rfc_rsLabel;
    protected javax.swing.JComboBox<String> rfc_targetCBox;
    protected javax.swing.JLabel rfc_targetLabel;
    protected javax.swing.JList<String> rfc_toList;
    protected javax.swing.JLabel rfs_neLabel;
    protected javax.swing.JPanel saPanel;
    protected javax.swing.JComboBox<String> sa_targetCBox;
    protected javax.swing.JLabel sa_targetLabel;
    protected javax.swing.JLabel selectedTableLabel;
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
    protected javax.swing.JButton workChoseButton;
    protected javax.swing.JPanel workPanel;
    protected javax.swing.JTextField workPathField;
    protected javax.swing.JButton workUploadButton;
    protected javax.swing.JLabel workUploadLabel;
    protected javax.swing.JRadioButton zeroRButton;
    // End of variables declaration//GEN-END:variables

    // </editor-fold>
}
