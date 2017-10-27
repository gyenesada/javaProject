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

public class WWFController implements Runnable {

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
        while (!wwf.exit) {
            System.out.println("---------------" + index + "--------------");
            try {
                while (wwf.outDatas.isEmpty()) {
                    Thread.sleep(10); //to prevent dataloss
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
            }
            //System.out.println("Input: " + inDatas);
            index++;

        }
    }

    private ArrayList<String> controller(ArrayList<String> in) throws InterruptedException {
        ArrayList<String> out = new ArrayList<>();

        String identifier = in.get(0);

        switch (identifier) {
            case "csv:":
                if (Boolean.valueOf(in.get(1))) {
                    wwf.currentTaskId = Integer.parseInt(in.get(2));

                    DefaultListModel<String> model = new DefaultListModel<>();
                    wwf.loadedTablesList.setModel(model);
                    model.addElement(wwf.selectedTable);
                    //Csv table = new Csv(Integer.parseInt(in.get(2)), in.get(3), Integer.parseInt(in.get(4)), loggedUser, Integer.parseInt(in.get(5)), false, false, false, false);
                    Thread.sleep(10);

                    wwf.changeMainPanels(wwf.workPanel, wwf.sideWorkPanel);
                } else {
                    JOptionPane.showMessageDialog(wwf, "Tábla feltöltés sikertelen. Győzödjön meg róla, hogy a tábla nem szerepel-e már a feltöltött táblái között.");
                }
                break;
            case "wcsv:":
                System.out.println("w: " + in.get(2));
                wwf.selectedTable = in.get(2);
                fillLoadedTablesList(in, true);
                break;
            case "wrk:":
                for (int i = 1; i < in.size() - 1; i = i + 2) {
                    wwf.list.add(in.get(i) + "    -    " + in.get(i + 1));
                }
                wwf.getSelectedTask();
                break;
            case "old:":
                fillLoadedTablesList(in, false);
                Thread.sleep(10);
                wwf.changeMainPanels(wwf.workPanel, wwf.sideWorkPanel);
                wwf.getSelectedTable();
                break;
            case "ldt:":
                loadedTablePreprocess();
                break;
            case "done:":
                System.out.println("Load fact.table");
                loadedTablePreprocess();
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
        }
        return out;
    }

    //add: van-e már tábla benne?
    protected void fillLoadedTablesList(ArrayList<String> in, boolean add) {
        
        DefaultListModel<String> model = new DefaultListModel<>();
        
            wwf.loadedTablesList.setModel(model);
            for (int i = 1; i < in.size(); i++) {
                model.addElement(in.get(i));
            }
    }

    private void loadedTablePreprocess() {
        ArrayList<String[]> items = new ArrayList<>();
        String input = wwf.rawInput.split(":, ")[1];
        String[] splitted = input.split(", >>first_line_end_flag<<, ");
        String cols = splitted[0];
        String content = splitted[1];

        String[] colnames = cols.split(",");

        String[] lines = content.split(", >>enter_flag<<, ");
        for (String str : lines) {
            String[] temp = str.split("(?!\"),(?! \")"); //titanic csv-ben nem jól split-el.
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
