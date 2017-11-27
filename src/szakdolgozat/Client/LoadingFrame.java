package szakdolgozat.Client;

import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LoadingFrame extends javax.swing.JFrame {

    private String mode;
    Process p;
    WorkWindowFrame wwf;
    
    public LoadingFrame(WorkWindowFrame wwf, String mode, Process p) {
        this.mode = mode;
        this.wwf = wwf;
        this.p = p;
        initComponents();
        setTitle("Információ");
        
       switch (mode) {
            case "tableUpload":
                informLabel.setText("Kiválasztott tábla feltöltése folyamatban van.");
                break;
            case "pythonCall":
                informLabel.setText("A kiválasztott művelet végrehajtása folyamatban van.");
                break;
            case "download":
                informLabel.setText("A kiválasztott tábla letöltése folyamatban van.");
                break;
        }
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         setResizable(false);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        informLabel = new javax.swing.JLabel();
        pleaseWaitLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        informLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        informLabel.setForeground(new java.awt.Color(51, 51, 51));
        informLabel.setText("A kérés teljesítése folyamatban van.");

        pleaseWaitLabel.setText("Kérjük várjon!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informLabel)
                    .addComponent(pleaseWaitLabel))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(informLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pleaseWaitLabel)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel informLabel;
    private javax.swing.JLabel pleaseWaitLabel;
    // End of variables declaration//GEN-END:variables
}
