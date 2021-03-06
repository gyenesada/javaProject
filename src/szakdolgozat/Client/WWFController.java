package szakdolgozat.Client;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class WWFController implements Runnable {

    private final Scanner sc;
    private final PrintWriter pw;

    WorkWindowFrame wwf;

    public WWFController(PrintWriter pw, Scanner sc, String name) throws Exception {
        this.sc = sc;
        this.pw = pw;

        wwf = new WorkWindowFrame(name);
        wwf.setVisible(true);
    }

    @Override
    public void run() {
        wwf.usernameLabel.setText("Üdvözöljük " + wwf.loggedUser + "!");
        communicateWithServer(pw, sc);
    }

    private void communicateWithServer(PrintWriter pw, Scanner sc) {
        int index = 0;

        while (!wwf.exit) {
            System.out.println(index + ".kérés indítása");
            try {
                while (wwf.outDatas.isEmpty()) {
                    Thread.sleep(10);
                }
                pw.println(wwf.outDatas);
                wwf.inDatas.clear();
                wwf.rawInput = sc.nextLine();
                inputPreprocess(wwf.rawInput);
                if (!wwf.inDatas.isEmpty()) {
                    wwf.outDatas = controller(wwf.inDatas);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(WorkWindowFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "A szerver kapcsolat megszakadt.");
                wwf.dispose();
            }
            index++;
        }
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
                    Thread.sleep(100);
                    wwf.lf.dispose();
                    wwf.operationCBox.setEnabled(true);
                    wwf.classifierCBox.setEnabled(true);
                    wwf.changeMainPanels(wwf.workPanel, wwf.sideWorkPanel);
                    wwf.downloadTableButton.setEnabled(true);
                    wwf.delTableButton.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(wwf, "Tábla feltöltés sikertelen. Győzödjön meg róla, hogy a tábla nem szerepel-e már a feltöltött táblái között.");
                }
                break;
            case "wcsv:":
                if(in.get(1).equals("err")){
                    JOptionPane.showMessageDialog(wwf, "Tábla feltöltés sikertelen. Győzödjön meg róla, hogy a tábla nem szerepel-e már a feltöltött táblái között.");
                }else{
                    wwf.selectedTable = in.get(1);
                    fillLoadedTablesList(in);
                    wwf.changePanels(wwf.firstPanel);
                    Thread.sleep(100);
                }
                wwf.lf.dispose();
                
                wwf.workPathField.setText("");
                wwf.downloadTableButton.setEnabled(true);
                wwf.delTableButton.setEnabled(true);
                break;
            case "wrk:":
                wwf.list.removeAll();
                for (int i = 1; i < in.size() - 1; i = i + 2) {
                    wwf.list.add(in.get(i) + "    -    " + in.get(i + 1));
                }
                wwf.loadSelectedTask();
                wwf.operationCBox.setEnabled(false);
                wwf.classifierCBox.setEnabled(false);
                break;
            case "old:":
                fillLoadedTablesList(in);
                Thread.sleep(10);
                wwf.changeMainPanels(wwf.workPanel, wwf.sideWorkPanel);
                
                wwf.delTableButton.setEnabled(false);
                wwf.downloadTableButton.setEnabled(false);
                wwf.getSelectedTable();
                break;
            case "ldt:":
                wwf.changePanels(wwf.firstPanel);
                loadedTablePreprocess();
                wwf.classifierCBox.setSelectedIndex(0);
                wwf.operationCBox.setSelectedIndex(0);
                break;
            case "done:":
                loadedTablePreprocess();
                addTableToList(in);
                Thread.sleep(100);
                wwf.lf.dispose();
                break;
            case "delt:":
                fillLoadedTablesList(in);
                wwf.selectedTable = null;
                DefaultTableModel model = new DefaultTableModel(0, 0);
                wwf.csvPrevTable.setModel(model);

                wwf.delTableButton.setEnabled(false);
                wwf.downloadTableButton.setEnabled(false);
                wwf.getSelectedTable();
                break;
            case "tdl:":
                writeToCsv(in.get(1));
                break;
            case "mdu:":
                if (Boolean.valueOf(in.get(1))) {
                    JOptionPane.showMessageDialog(wwf, "A felhasználónév megváltozott.");
                    wwf.loggedUser = in.get(2);
                    wwf.usernameLabel.setText("Üdvözöljük " + wwf.loggedUser + "!");
                } else {
                    JOptionPane.showMessageDialog(wwf, "Már szerepel ilyen felhasználónév!");
                }
                break;
            case "mdp:":
                JOptionPane.showMessageDialog(wwf, "A jelszava sikeresen megváltozott.");
                break;
            case "nok:":
                JOptionPane.showMessageDialog(wwf, "A tábla nem megfelelő formátumú az osztályozó algoritmus lefuttatására. Kérjük ellenőrizze!");
                wwf.lf.dispose();
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
        String input;
        try {
            String[] temp = wwf.rawInput.split(":, ");
            input = temp[3];
            String accuracy = temp[2];
            System.out.println("temp[2] " + temp[2]);
            if(!accuracy.equals("-1.0")){
                wwf.accuracyLabel.setText("Accuracy: " + temp[2] );
            }else{
                wwf.accuracyLabel.setText("Accuracy: -");
            }
            String[] splitted = input.split(", >>flag<<, ");
            String[] cols = splitted[0].split(",");
            for (int i = 1; i < splitted.length; i++) {
                String[] tmp = splitted[i].split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                items.add(tmp);
            }
            wwf.fillPrevTable(cols, items);
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(wwf, "A kért tábla betöltése nem sikerült!");
        }
    }
    
    private void writeToCsv(String filename) {
        filename = filename.replaceAll(":", "");
        String fs = System.getProperty("file.separator");
        String fullFilepath = System.getProperty("user.home") + fs + "Desktop" + fs + filename;

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(fullFilepath);
            bw = new BufferedWriter(fw);

            String lines = wwf.rawInput.split(":, ")[3];
            String line = (lines.replaceAll(", >>flag<<, ", "\n")).replaceAll(", >>flag<<]", "");

            bw.write(line);
            Thread.sleep(500);
            wwf.lf.dispose();
            JOptionPane.showMessageDialog(wwf, "A kiválasztott tábla lementve: " + fullFilepath + ". ");
        } catch (IOException e) {
        } catch (InterruptedException ex) {
            Logger.getLogger(WWFController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println("Error closing bw and fw");
            }
        }

    }

    private void inputPreprocess(String input) {
        String withoutBrackets = input.replaceAll("[\\[\\]]", "");

        String[] string = withoutBrackets.split(", ");
        wwf.inDatas.addAll(Arrays.asList(string));
    }

    private void addTableToList(ArrayList<String> in) {
        DefaultListModel dlm = (DefaultListModel) wwf.loadedTablesList.getModel();
        String newTable = in.get(1).replaceAll(":", "");
        wwf.selectedTable = newTable;
        boolean canInsert = true;
        String[] oldTables = dlm.toString().replaceAll("[\\[\\]]", "").split(", ");

        for (String ot : oldTables) {
            if (ot.equals(newTable)) {
                canInsert = false;
            }
        }

        if (canInsert) {
            dlm.addElement(in.get(1).replaceAll(":", ""));
        }

    }
}
