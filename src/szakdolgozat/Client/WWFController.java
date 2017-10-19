package szakdolgozat.Client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class WWFController implements Runnable{
    private final Scanner sc;
    private final PrintWriter pw;
    private final String loggedUser;
    
    WorkWindowFrame wwf;
    
    public WWFController(PrintWriter pw, Scanner sc, String name) throws Exception{
        this.loggedUser = name;
        this.sc = sc;
        this.pw = pw;
        
         wwf = new WorkWindowFrame();
         wwf.setVisible(true);
    }
    
    @Override
    public void run() {
        wwf.usernameLabel.setText("Üdvözöljük " + loggedUser + "!"); //ezt majd konstruktorba kell tenni.
        communicateWithServer(pw, sc);
    }
    
    private void communicateWithServer(PrintWriter pw, Scanner sc) {
        int index = 0;
        while (!wwf.exit) {
            System.out.println("---------------" + index + "--------------");
            while (wwf.outDatas.isEmpty()) {
                try {
                    Thread.sleep(10); //to prevent dataloss
                } catch (InterruptedException ex) {
                    Logger.getLogger(WorkWindowFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            pw.println(wwf.outDatas);
            wwf.inDatas.clear();
            wwf.rawInput = sc.nextLine();
            inputPreprocess(wwf.rawInput);
            if (!wwf.inDatas.isEmpty()) {
                wwf.outDatas = controller(wwf.inDatas);
            }
            //System.out.println("Input: " + inDatas);
            index++;

        }
    }

    private ArrayList<String> controller(ArrayList<String> in) {
        ArrayList<String> out = new ArrayList<>();

        String identifier = in.get(0);

        switch (identifier) {
            case "csv:":
                if (Boolean.valueOf(in.get(1))) {
                    wwf.loadPanel.setVisible(false);
                    wwf.workPanel.setVisible(true);

                    wwf.sideLoadPanel.setVisible(false);
                    wwf.sideWorkPanel.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(wwf, "Tábla feltöltés sikertelen. Győzödjön meg róla, hogy a tábla nem szerepel-e már a feltöltött táblái között.");
                }
                break;
            case "old:":
                for (int i = 1; i < in.size() - 1; i = i + 2) {
                    wwf.list.add(in.get(i + 1) + "    -    " + in.get(i));
                }
                wwf.getSelectedFile();
                break;
            case "ldt:":
                loadedTablePreprocess();
                wwf.loadPanel.setVisible(false);
                wwf.sideLoadPanel.setVisible(false);

                wwf.workPanel.setVisible(true);
                wwf.sideWorkPanel.setVisible(true);
                break;
        }
        return out;
    }
    
    

    private void loadedTablePreprocess() {
        ArrayList<String[]> items = new ArrayList<>();
        String input = wwf.rawInput.split(":,")[1];
        String[] splitted = input.split(", >>first_line_end_flag<<, ");
        String cols = splitted[0];
        String content = splitted[1];

        String[] colnames = cols.split(",");

        String[] lines = content.split(", >>enter_flag<<,");
        for (String str : lines) {
            String[] temp = str.split("(?!\"),(?!\")");
            items.add(temp);
        }
        wwf.fillPrevTable(colnames, items);
    }


    private void inputPreprocess(String input) {
        String withoutBrackets = input.replaceAll("[\\[\\]]", "");

        String[] string = withoutBrackets.split(", ");
        wwf.inDatas.addAll(Arrays.asList(string));
    }
}
