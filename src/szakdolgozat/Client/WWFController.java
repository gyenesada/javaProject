package szakdolgozat.Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class WWFController implements Runnable{ 

    private final Scanner sc;
    private final PrintWriter pw;
    private final String loggedUser;

    WorkWindowFrame wwf;

    public WWFController(PrintWriter pw, Scanner sc, String name) throws Exception {
        this.loggedUser = name;
        this.sc = sc;
        this.pw = pw;

        wwf = new WorkWindowFrame();
        wwf.setVisible(true);
        
    }

    @Override
    public void run() {
        wwf.usernameLabel.setText("Üdvözöljük " + loggedUser + "!");
        communicateWithServer(pw, sc);
      
    }

    private void communicateWithServer(PrintWriter pw, Scanner sc) {
        int index = 0;
        do {
            System.out.println("---------------" + index + "--------------");
            try {
                while (wwf.outDatas.isEmpty()) {
                    Thread.sleep(10); //to prevent dataloss
                }
                System.out.println("wwf." +  wwf.outDatas);
                pw.println(wwf.outDatas);
                wwf.inDatas.clear();
                wwf.rawInput = sc.nextLine();
                inputPreprocess(wwf.rawInput);
                if (!wwf.inDatas.isEmpty()) {
                    wwf.outDatas = controller(wwf.inDatas);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(WorkWindowFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.out.println("Input: " + inDatas);
            index++;
        }while (!wwf.exit);
    }

    private ArrayList<String> controller(ArrayList<String> in) throws InterruptedException {
        ArrayList<String> out = new ArrayList<>();

        String identifier = in.get(0);
        switch (identifier) {
            case "csv:":
                if (Boolean.valueOf(in.get(1))) {
                    wwf.currentTaskID = Integer.parseInt(in.get(2));

                    DefaultListModel<String> model = new DefaultListModel<>();
                    wwf.loadedTablesList.setModel(model);
                    model.addElement(wwf.selectedTable);
                    Thread.sleep(10);
                    wwf.lf.dispose();
                    wwf.changeMainPanels(wwf.workPanel, wwf.sideWorkPanel);
                    
                } else {
                    JOptionPane.showMessageDialog(wwf, "Tábla feltöltés sikertelen. Győzödjön meg róla, hogy a tábla nem szerepel-e már a feltöltött táblái között.");
                }
                break;
            case "wcsv:":
                wwf.selectedTable = in.get(1);
                fillLoadedTablesList(in);
                break;
            case "wrk:":
                wwf.list.removeAll();
                for (int i = 1; i < in.size() - 1; i = i + 2) {
                    wwf.list.add(in.get(i) + "    -    " + in.get(i + 1));
                }
                wwf.loadSelectedTask();
                break;
            case "old:":
                fillLoadedTablesList(in);
                Thread.sleep(10);
                wwf.changeMainPanels(wwf.workPanel, wwf.sideWorkPanel);
                wwf.getSelectedTable();
                break;
            case "ldt:":
                loadedTablePreprocess();
                break;
            case "done:":
                loadedTablePreprocess();
                addTableToList(in);
                wwf.lf.dispose();
                break;
            case "delt:":
                
                break;
            case "bye:":
                wwf.dispose();

                MWFController controller;
                try {
                    controller = new MWFController();
                    controller.run();
                } catch (IOException ex) {
                    Logger.getLogger(WWFController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "err:":
                JOptionPane.showMessageDialog(wwf, "A művelet végrehajtása közben probléma lépett fel.");
                break;
        }
        return out;
    }

    protected void fillLoadedTablesList(ArrayList<String> in) {
        DefaultListModel<String> model = new DefaultListModel<>();
            wwf.loadedTablesList.setModel(model);
            for (int i = 1; i < in.size(); i++) {
                model.addElement(in.get(i));
            }
    }

    private void loadedTablePreprocess() {
        ArrayList<String[]> items = new ArrayList<>();
        String input = wwf.rawInput.split(":, ")[2];
        String[] splitted = input.split(", >>first_line_end_flag<<, ");
        String cols = splitted[0];
        String content = splitted[1];

        String[] colnames = cols.split(",");

        String[] lines = content.split(", >>enter_flag<<, ");
        for (String str : lines) {
            String[] temp = str.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            items.add(temp);
        }
        wwf.fillPrevTable(colnames, items);
    }

    private void inputPreprocess(String input) {
        String withoutBrackets = input.replaceAll("[\\[\\]]", "");

        String[] string = withoutBrackets.split(", ");
        wwf.inDatas.addAll(Arrays.asList(string));
    }
    
    private void addTableToList(ArrayList<String> in){
        DefaultListModel dlm = (DefaultListModel) wwf.loadedTablesList.getModel();
        String newTable = in.get(1).replaceAll(":", "");
        boolean canInsert=true;
        String[] oldTables = dlm.toString().replaceAll("[\\[\\]]", "").split(", ");
        
        for(String ot: oldTables){
            if(ot.equals(newTable)){
                System.out.println("Egyezik");
                canInsert = false;
            }
        }
        
        if(canInsert){
            dlm.addElement(in.get(1).replaceAll(":", ""));
        }
    }
}
