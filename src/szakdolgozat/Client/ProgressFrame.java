package szakdolgozat.Client;

import javax.swing.SwingUtilities;

public class ProgressFrame extends javax.swing.JFrame implements Runnable{
    String msg;

    public ProgressFrame(String msg) {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        textLabel = new javax.swing.JLabel();
        progBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        textLabel.setText("Tábla feltöltése folyamatban");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textLabel)
                        .addGap(0, 130, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(textLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }
    
    @Override
    public void run(){
        
        textLabel.setText(msg);
        int min=0;
        int max =50;
        progBar.setMinimum(min);
        progBar.setMaximum(max);
        
            while(true){
    for (int i = min; i <= max; i++) {
      final int percent = i;
      try {
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            progBar.setValue(percent);
          }
        });
        java.lang.Thread.sleep(100);
      } catch (InterruptedException e) {
        ;
      }
    }
  }
    }

    private javax.swing.JProgressBar progBar;
    private javax.swing.JLabel textLabel;
}
