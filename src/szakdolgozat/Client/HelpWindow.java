package szakdolgozat.Client;

import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class HelpWindow extends javax.swing.JFrame {

    public HelpWindow(String mode) {
        initComponents();
        if(mode.equals("pre")){
            preSidePanel.setVisible(true);
            clfSidePanel.setVisible(false);
        }else if(mode.equals("clf")){
            preSidePanel.setVisible(false);
            clfSidePanel.setVisible(true);
        }
        changePanels(firstPanel);
        
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
        setTitle("CloudBased classifier - Help");
        setResizable(false);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);

        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidePanel = new javax.swing.JPanel();
        clfSidePanel = new javax.swing.JPanel();
        adaButton = new javax.swing.JButton();
        dtcButton = new javax.swing.JButton();
        rfcButton = new javax.swing.JButton();
        gtbButton = new javax.swing.JButton();
        saButton = new javax.swing.JButton();
        preSidePanel = new javax.swing.JPanel();
        factButton = new javax.swing.JButton();
        featButton = new javax.swing.JButton();
        normButton = new javax.swing.JButton();
        nanButton = new javax.swing.JButton();
        dropoutButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        firstPanel = new javax.swing.JPanel();
        factPanel = new javax.swing.JPanel();
        factText = new javax.swing.JLabel();
        featPanel = new javax.swing.JPanel();
        featText = new javax.swing.JLabel();
        nanPanel = new javax.swing.JPanel();
        nanText = new javax.swing.JLabel();
        dropPanel = new javax.swing.JPanel();
        dropText = new javax.swing.JLabel();
        normPanel = new javax.swing.JPanel();
        normText = new javax.swing.JLabel();
        adaPanel = new javax.swing.JPanel();
        adaText = new javax.swing.JLabel();
        dtcPanel = new javax.swing.JPanel();
        dtcText = new javax.swing.JLabel();
        rfcPanel = new javax.swing.JPanel();
        rfcText = new javax.swing.JLabel();
        saPanel = new javax.swing.JPanel();
        saText = new javax.swing.JLabel();
        gtbPanel = new javax.swing.JPanel();
        gtbText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidePanel.setLayout(new java.awt.CardLayout());

        clfSidePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        adaButton.setText("AdaBoost");
        adaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaButtonActionPerformed(evt);
            }
        });

        dtcButton.setText("DecisionTree");
        dtcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtcButtonActionPerformed(evt);
            }
        });

        rfcButton.setText("RandomForest");
        rfcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rfcButtonActionPerformed(evt);
            }
        });

        gtbButton.setText("GradientBoost");
        gtbButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gtbButtonActionPerformed(evt);
            }
        });

        saButton.setText("Sentiment Analysis");
        saButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout clfSidePanelLayout = new javax.swing.GroupLayout(clfSidePanel);
        clfSidePanel.setLayout(clfSidePanelLayout);
        clfSidePanelLayout.setHorizontalGroup(
            clfSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clfSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clfSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dtcButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rfcButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gtbButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        clfSidePanelLayout.setVerticalGroup(
            clfSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clfSidePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(adaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtcButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rfcButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gtbButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saButton)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        sidePanel.add(clfSidePanel, "card2");

        preSidePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        factButton.setText("Faktorizálás");
        factButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                factButtonActionPerformed(evt);
            }
        });

        featButton.setText("FeatureSelection");
        featButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                featButtonActionPerformed(evt);
            }
        });

        normButton.setText("Normalizálás");
        normButton.setToolTipText("");
        normButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normButtonActionPerformed(evt);
            }
        });

        nanButton.setText("Üres értékek kezelése");
        nanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nanButtonActionPerformed(evt);
            }
        });

        dropoutButton.setText("Oszlop törlés");
        dropoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout preSidePanelLayout = new javax.swing.GroupLayout(preSidePanel);
        preSidePanel.setLayout(preSidePanelLayout);
        preSidePanelLayout.setHorizontalGroup(
            preSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(preSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(preSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(factButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(featButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(normButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nanButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dropoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        preSidePanelLayout.setVerticalGroup(
            preSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(preSidePanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(factButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(featButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(normButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nanButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dropoutButton)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        sidePanel.add(preSidePanel, "card2");

        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mainPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout firstPanelLayout = new javax.swing.GroupLayout(firstPanel);
        firstPanel.setLayout(firstPanelLayout);
        firstPanelLayout.setHorizontalGroup(
            firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        firstPanelLayout.setVerticalGroup(
            firstPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
        );

        mainPanel.add(firstPanel, "card2");

        factText.setText("Faktorizálás");

        javax.swing.GroupLayout factPanelLayout = new javax.swing.GroupLayout(factPanel);
        factPanel.setLayout(factPanelLayout);
        factPanelLayout.setHorizontalGroup(
            factPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(factPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(factText)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        factPanelLayout.setVerticalGroup(
            factPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(factPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(factText)
                .addContainerGap(347, Short.MAX_VALUE))
        );

        mainPanel.add(factPanel, "card2");

        featText.setText("Faktorizálás");

        javax.swing.GroupLayout featPanelLayout = new javax.swing.GroupLayout(featPanel);
        featPanel.setLayout(featPanelLayout);
        featPanelLayout.setHorizontalGroup(
            featPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(featPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(featText)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        featPanelLayout.setVerticalGroup(
            featPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(featPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(featText)
                .addContainerGap(347, Short.MAX_VALUE))
        );

        mainPanel.add(featPanel, "card2");

        nanText.setText("Faktorizálás");

        javax.swing.GroupLayout nanPanelLayout = new javax.swing.GroupLayout(nanPanel);
        nanPanel.setLayout(nanPanelLayout);
        nanPanelLayout.setHorizontalGroup(
            nanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nanText)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        nanPanelLayout.setVerticalGroup(
            nanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nanText)
                .addContainerGap(347, Short.MAX_VALUE))
        );

        mainPanel.add(nanPanel, "card2");

        dropText.setText("Faktorizálás");

        javax.swing.GroupLayout dropPanelLayout = new javax.swing.GroupLayout(dropPanel);
        dropPanel.setLayout(dropPanelLayout);
        dropPanelLayout.setHorizontalGroup(
            dropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dropText)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        dropPanelLayout.setVerticalGroup(
            dropPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dropText)
                .addContainerGap(347, Short.MAX_VALUE))
        );

        mainPanel.add(dropPanel, "card2");

        normText.setText("Faktorizálás");

        javax.swing.GroupLayout normPanelLayout = new javax.swing.GroupLayout(normPanel);
        normPanel.setLayout(normPanelLayout);
        normPanelLayout.setHorizontalGroup(
            normPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(normPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(normText)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        normPanelLayout.setVerticalGroup(
            normPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(normPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(normText)
                .addContainerGap(347, Short.MAX_VALUE))
        );

        mainPanel.add(normPanel, "card2");

        adaText.setText("Faktorizálás");

        javax.swing.GroupLayout adaPanelLayout = new javax.swing.GroupLayout(adaPanel);
        adaPanel.setLayout(adaPanelLayout);
        adaPanelLayout.setHorizontalGroup(
            adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adaText)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        adaPanelLayout.setVerticalGroup(
            adaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adaText)
                .addContainerGap(347, Short.MAX_VALUE))
        );

        mainPanel.add(adaPanel, "card2");

        dtcText.setText("Faktorizálás");

        javax.swing.GroupLayout dtcPanelLayout = new javax.swing.GroupLayout(dtcPanel);
        dtcPanel.setLayout(dtcPanelLayout);
        dtcPanelLayout.setHorizontalGroup(
            dtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dtcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dtcText)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        dtcPanelLayout.setVerticalGroup(
            dtcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dtcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dtcText)
                .addContainerGap(347, Short.MAX_VALUE))
        );

        mainPanel.add(dtcPanel, "card2");

        rfcText.setText("Faktorizálás");

        javax.swing.GroupLayout rfcPanelLayout = new javax.swing.GroupLayout(rfcPanel);
        rfcPanel.setLayout(rfcPanelLayout);
        rfcPanelLayout.setHorizontalGroup(
            rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rfcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rfcText)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        rfcPanelLayout.setVerticalGroup(
            rfcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rfcPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rfcText)
                .addContainerGap(347, Short.MAX_VALUE))
        );

        mainPanel.add(rfcPanel, "card2");

        saText.setText("Faktorizálás");

        javax.swing.GroupLayout saPanelLayout = new javax.swing.GroupLayout(saPanel);
        saPanel.setLayout(saPanelLayout);
        saPanelLayout.setHorizontalGroup(
            saPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saText)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        saPanelLayout.setVerticalGroup(
            saPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saText)
                .addContainerGap(347, Short.MAX_VALUE))
        );

        mainPanel.add(saPanel, "card2");

        gtbText.setText("Faktorizálás");

        javax.swing.GroupLayout gtbPanelLayout = new javax.swing.GroupLayout(gtbPanel);
        gtbPanel.setLayout(gtbPanelLayout);
        gtbPanelLayout.setHorizontalGroup(
            gtbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gtbPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gtbText)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        gtbPanelLayout.setVerticalGroup(
            gtbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gtbPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gtbText)
                .addContainerGap(347, Short.MAX_VALUE))
        );

        mainPanel.add(gtbPanel, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adaButtonActionPerformed
        changePanels(adaPanel);
        adaText.setText("<html><font size=\"6\">AdaBoost Classifier</font><br> <br> Az AdaBoost osztályozó egy meta-becslő algoritmus ami első lépésben felépíti az osztályozót az eredeti adathalmazra, és azután ennek az osztályozónak a további másolatait is lefuttatja ugyanarra az adathalmazra. Alapját több algoritmussal dolgozik együtt, ezzel javítva a teljesítményt. Ezeknek az algoritmusoknak a kimenete egy súlyozott összegben adják az eredeti algoritmus kimenetét. Az algoritmus adaptív, így a gyengébb felépítő tanulóalgoritmusok jobb értékekre cserélik a korábbi classifierek esetén félrekezelt adatokat. Az AdaBoost érzékeny a kiugró és zajos adatokra. <br> Paraméterei: <ul><li>n_estimators: a maximum becslő szám, amit az algoritmus használ. </li> <li>learning_rate: a felépítő elemek együttműködését adja meg.</li> <li>algorithm: SAMME esetén diszkrét, SAMME.R esetén folytonos algoritmust használ.</li></ul></html>");
    }//GEN-LAST:event_adaButtonActionPerformed

    private void factButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_factButtonActionPerformed
       changePanels(factPanel);
       factText.setText("<html><font size=\"6\">Faktorizálás</font><br> <br> A faktorizálás lényegében a szöveges és logikai mezők számszerűsítése. Ez az algoritmus segít a táblát előfeldolgozni az osztályozók és a feature selection használatához ahol követelmény, hogy a feature halmazba válogatott oszlopok számszerűek legyenek. A számszerűsítés lényegében egy kategorizálás, tehát ha egy oszlop csak nő és férfi nemet tartalmaz, akkor a faktorizálás után már csak 0 és 1 érték található majd meg benne. </html>");
    }//GEN-LAST:event_factButtonActionPerformed

    private void featButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_featButtonActionPerformed
        changePanels(featPanel);
        featText.setText("<html><font size=\"6\">Feature Selection</font><br> <br> A Feature Selection egy olyan algoritmus, ami a Variance Threshold módszert alkalmazza a nem hasznos oszlopok kiszűrésére. Ehhez szükséges a táblát faktorizálni, ha annak szerkezete nem megfelelő, vagyis tartalmaz a számszerű mezőktől eltérő mezőt. A felhasználó az algoritmus kiválasztása során megad egy <b> threshold</b> paramétert. Ez a paraméter egy <b>float</b> érték. Az algoritmus ezt használja fel, az oszlopok kiszűrése esetén. Ha az bizonyos oszlop értékeinek szórása kisebb, mint a megadott küszöbérték, az oszlop nem kerül bele a kimeneti táblába. <br> <br> Ez az algoritmus segíti az osztályozókat abban, hogy felesleges attribútumokat, amik nem viszik előre az osztályozás menetét,  ne kelljen kezelniük.  </html>");
    }//GEN-LAST:event_featButtonActionPerformed

    private void normButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normButtonActionPerformed
        changePanels(normPanel);
        normText.setText("<html><font size=\"6\">Normalizálás</font><br> <br> A normalizálás algoritmus hatására a tábla számszerű mezői egységes, standard skálázási módra váltanak. Ehhez a Standard Scaler módszert használja fel. Lényege, hogy az standardizálja az attribútumokat a középérték eltávolíásával, és egy egységes szórású adatokat tartalmazó oszlopot kreál belőle.    </html>");
    }//GEN-LAST:event_normButtonActionPerformed

    private void nanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nanButtonActionPerformed
        changePanels(nanPanel);
        nanText.setText("<html><font size=\"6\">Üres értékek kezelése</font><br> <br> Az osztályozók számára fontos kikötés, hogy az osztályozni kívánt tábla attribútumai ne tartalmazzanak NaN, vagyis üres értékeket. Ezeket az értékeket több módon is ki tudjuk játszani. Ezek például:<br> <ul><li>Üres értékek helyettesítése mediánnal</li> <li>Üres értékek helyettesítése módusszal </li> <li>Üres értékek mértani középpel való helyettesítése </li> <li>Üres értékek nullával való helyettesítése </li> <li>Üres értékeket tartalmazó sorok törlése</li></ul><br> Ezen módszerek közül az első három megvizsgálja az üres érték oszlopában lévő többi értéket, és a megfelelő módszerrel helyettesíti az oszlopban található összes üresértéket. A nullával való helyettesítés pedig egyszerűen nullát helyettesít az üres érték helyére. Ez csak annyiban oldja meg a problémát, hogy nem kell sorokat törölni, de később ez eltorzíthatja az osztályozó eredményét. Az utolsó módszer pedig egyszerűen törli azokat a sorokat, amik üres értékeket tartalmaznak. </html>");
    }//GEN-LAST:event_nanButtonActionPerformed

    private void dropoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropoutButtonActionPerformed
        changePanels(dropPanel);
        dropText.setText("<html><font size=\"6\">Oszlopok törlése</font><br> <br> A Feature Selection algoritmussal ellentétben itt a felhasználó dönti el, hogy melyik oszlopot szeretné törölni a betöltött adattáblából. Ennek segítségével például az id-t tartalmazó oszlopokat, amik nem segítenek be jelentősen az osztályozó működésébe, vagy a haszontalan, helyet foglaló oszlopokat manuálisan törölni tudjuk. A menüpont kiválasztása után a felhasználó lát két listát, egy üreset és egyet, amiben minden oszlopnév fel van sorolva. Ha a listában lévő elemekre kattintunk, a listából eltűnik és a másikban megjelenik. Ezzel tudja megadni az oszlopok halmazát. Lefutás után már ezen oszlopok nem kerülnek bele az új vagy módosított táblába. </html>");
    }//GEN-LAST:event_dropoutButtonActionPerformed

    private void dtcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtcButtonActionPerformed
        changePanels(dtcPanel);
        dtcText.setText("<html><font size=\"6\">Decision Tree Classifier</font><br> <br>Ez az osztályozó algoritmus döntési fákat vesz alapul. A döntési fák olyan struktúrák, amikben az optimális tevékenységnek több választási lehetősége is megjelenik. Kimenetele bizonytalak. Szerkezetét tekintve gráf, csúcsai egy döntéshelyzetet reprezentálnak, élei pedig maga a döntés. A tanulóhalmaz hibáira, kiugró adataira érzékeny. Kombinálható más tanítási algoritmusokkal is, ezzel javítva a teljesítményét. <br> Megadható paraméterei: <ul><li>max_depth: a fa maximális mélysége. (Ha None: a fa addig nő, amíg ameddig az algoritmusnak szükséges.) </li><li>random_state: a randomszám generáláshoz használt seed érték. </li><li>presort: bool érték, ha igazra állítjuk, az adatot előszortírozza, ezzel gyorsítva a legjobb vágás megtalálását fittelés esetén.</li></ul>   </html>");
    }//GEN-LAST:event_dtcButtonActionPerformed

    private void rfcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rfcButtonActionPerformed
       changePanels(rfcPanel);
        rfcText.setText("<html><font size=\"6\">Random Forest Classifier</font><br> <br> Ez egy meta-becslő algoritmus ami több Decision Tree-t használ az adathalmaz több almintáján, majd átlagolást használ hogy a becslési pontosságot növelje, és kontrollálja az over-fitting jelenséget. Az al-adathalmaz mérete mindig ugyanaz mint az eredeti adathalmazé, de a minták cserélődnek, ha a boostrap igazra van állítva. <br> Paraméterei: <ul><li>n_estimators: a fák száma, amivel az 'erdő' dolgozik</li> <li>max_depth: a fák maximum mélysége.  </li> <li>bootstrap: boolean érték, ha igaz, boostrap értékek kerülnek a fa felépítése közben az adathalmazba </li> <li>random_state: a randomszám generáláshoz használt seed érték </li> <li>n_jobs: a párhuzamosan futtatható folyamatok száma a fittelés és becslés közben </li></ul>  </html>");
    }//GEN-LAST:event_rfcButtonActionPerformed

    private void gtbButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gtbButtonActionPerformed
        changePanels(gtbPanel);
        gtbText.setText("<html><font size=\"6\">Gradient Boosting Classifier</font><br> <br>A Gradient Boosting algoritmus modelfelépítése hasonló, mint a többi boosting algoritmusnak, tehát ez is állapotról állapotra építi fel a modellt és általánosítja őket úgy, hogy megengedi egy bármennyiszer differenciállható függvény optimálását. <br> Paraméterei: <ul><li>learning_rate: az egyes felépítő osztályozók együttműködését adja meg.</li> <li>n_estimators: a boosting állapotok száma. Minél nagyobb, annál pontosabb eredményt ad.</li><li>max_depth: egyes regresszor becslők mélységének maximuma</li><li>random_state: a randomszám generáláshoz használt seed érték</li></ul> </html>");
    }//GEN-LAST:event_gtbButtonActionPerformed

    private void saButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saButtonActionPerformed
        changePanels(saPanel);
        saText.setText("<html><font size=\"6\">Sentiment Analysis</font><br> <br> A Sentiment Analysis, vagy magyarul az érzelmi analízis egy olyan módszer, amivel szöveges alapú mezők érzelmi töltetét tudjuk megbecsülni, célzott osztályzással. Az algoritmus alapja egy LinearRegressor, ami a már tokenizált és súlyozott szöveg-előfordulás és érzelmi töltet értkeket kapja bemenetnek. Az algoritmus <b>angol</b> nyelvre lett megírva, így ha magyar vagy másnyelvű szöveget kap bemenetnek, akkor az nem ad reális eredményt. Az eredmény szintén függ a train halmaztól, de ebben az algoritmusban az egy előre megadott adathalmaz, ezzel a felhasználónak nem kell foglalkoznia. <br> Paraméterezni a regressort nem kell, csupán a feltöltött adattábla egy oszlopát várja bemenetnek, aminek fontos a típusa. Szám és logikai típusra az algoritmus nem indul el. </html>");
    }//GEN-LAST:event_saButtonActionPerformed

    private void changePanels(JPanel visiblePanel){
        JPanel[] panels = {firstPanel, factPanel, featPanel, normPanel, nanPanel, dropPanel, adaPanel, rfcPanel, dtcPanel, gtbPanel, saPanel};
        for(JPanel p:panels){
            if (p==visiblePanel){
                 p.setVisible(true);
            }else{
                p.setVisible(false);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adaButton;
    private javax.swing.JPanel adaPanel;
    private javax.swing.JLabel adaText;
    private javax.swing.JPanel clfSidePanel;
    private javax.swing.JPanel dropPanel;
    private javax.swing.JLabel dropText;
    private javax.swing.JButton dropoutButton;
    private javax.swing.JButton dtcButton;
    private javax.swing.JPanel dtcPanel;
    private javax.swing.JLabel dtcText;
    private javax.swing.JButton factButton;
    private javax.swing.JPanel factPanel;
    private javax.swing.JLabel factText;
    private javax.swing.JButton featButton;
    private javax.swing.JPanel featPanel;
    private javax.swing.JLabel featText;
    private javax.swing.JPanel firstPanel;
    private javax.swing.JButton gtbButton;
    private javax.swing.JPanel gtbPanel;
    private javax.swing.JLabel gtbText;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton nanButton;
    private javax.swing.JPanel nanPanel;
    private javax.swing.JLabel nanText;
    private javax.swing.JButton normButton;
    private javax.swing.JPanel normPanel;
    private javax.swing.JLabel normText;
    private javax.swing.JPanel preSidePanel;
    private javax.swing.JButton rfcButton;
    private javax.swing.JPanel rfcPanel;
    private javax.swing.JLabel rfcText;
    private javax.swing.JButton saButton;
    private javax.swing.JPanel saPanel;
    private javax.swing.JLabel saText;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}
