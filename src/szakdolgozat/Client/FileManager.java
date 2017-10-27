package szakdolgozat.Client;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileManager implements Runnable {

    JButton open;
    JFileChooser fc;

    public FileManager() {
        open = new JButton();
        fc = new JFileChooser();

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {

        fc.setDialogTitle("Fájl kiválasztása");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("csv files", "csv");
        fc.setFileFilter(filter);
        if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
            //
        }
    }

    public String getAbsoluteFilePath() {
        String returnvalue = "";
        try {
            returnvalue = fc.getSelectedFile().getAbsolutePath();
        } catch (Exception e) {
        }
        return returnvalue;
    }

}
