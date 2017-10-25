package szakdolgozat.Client;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileManager implements Runnable{
    JButton open;
    JFileChooser fc;    
    public FileManager(){
        open = new JButton();
        fc = new JFileChooser();
    }
    
    @Override
    public void run(){
        fc.setDialogTitle("Fájl kiválasztása");
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("csv files", "csv", "text");
        fc.setFileFilter(filter);
        if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION){
            //
        }
    }
    
    public String getAbsoluteFilePath(){
        String returnvalue="";
        try{
         returnvalue = fc.getSelectedFile().getAbsolutePath();
        }catch(Exception e){}
        return returnvalue;
    }
    
}
