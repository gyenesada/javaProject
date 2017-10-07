package szakdolgozat.Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class WFController implements Runnable {
    private ArrayList<String> inDatas, outDatas = new ArrayList<>();
    
    Socket socket;
    PrintWriter pw;
    Scanner sc;
    static WindowFrame wf;
    
    final String host;
    final int port;
    
    public WFController(String host, int port){
        this.host = host;
        this.port = port;
    }
    
    public static void main(String[] args) throws IOException{
        wf = new WindowFrame();
        wf.setVisible(true);
    }

    @Override
    public void run(){
        try {
            socket = new Socket(host, port);
            pw = new PrintWriter(socket.getOutputStream());
            sc = new Scanner(socket.getInputStream());
            
            communicationWithServer(pw, sc);
        } catch (IOException ex) {
            System.out.println("Error: WFC run, socket");
        }
    }
    
    public void getOutDatas(ArrayList<String> out){
        outDatas = out;
    }
    
    //Send to the view
    /*public ArrayList<String> sendInDatas(ArrayList<String> in){
        return in;
    }
    */
    
    private void communicationWithServer(PrintWriter pw, Scanner sc) { //ez kell majd a WorkWindowFrame-be is.
        int index = 0;
        while (true) {
            System.out.println("---------------" + index + "--------------");
            System.out.println("");
            pw.println(outDatas);
            outDatas.clear();
            System.out.println("Output: " + outDatas);
            inDatas.clear();
            inputPreprocess(sc.nextLine());
            if (!inDatas.isEmpty()) {
                outDatas = controller(inDatas);
            }
            System.out.println("Input: " + inDatas);
            index++;
        }
    }
    
    private void inputPreprocess(String input) {
        System.out.println("input: " + input);
        String withoutBrackets = input.replaceAll("[\\[\\]]", "");

        String[] string = withoutBrackets.split(", ");
        inDatas.addAll(Arrays.asList(string));
        System.out.println("Input: " + inDatas);
        
    }
     
    private ArrayList<String> controller(ArrayList<String> in) { //Kell a WorkWindowFrame-be is.
        ArrayList<String> out = new ArrayList<>();

        String answer = "";
        String identifier = in.get(0);

        switch (identifier) {
            case "log:":
                if (Boolean.valueOf(in.get(1))) {
                    try {
                        String username = wf.nameField.getText();
                        WorkWindowFrame wwf = new WorkWindowFrame(pw, sc, username);
                        System.out.println("Username: " + username);

                        wwf.setVisible(true);
                        wwf.run();
                        wf.dispose();
                    } catch (Exception ex) {
                        System.out.println("Error: ");
                    }
                } else {
                    wf.nameField.setText("");
                    wf.passField.setText("");
                    JOptionPane.showMessageDialog(wf, "sikertelen");
                }
                break;
            case "reg:":
                if (Boolean.valueOf(in.get(1))) {
                    JOptionPane.showMessageDialog(wf, "sikeres regisztráció");
                    wf.loginPanel.setVisible(true);
                    wf.regPanel.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(wf, "sikertelen regisztráció.");

                    wf.regNameField.setText("");
                    wf.regMailField.setText("");
                    wf.regPassField.setText("");
                }
                break;
        }
        return out;
    }
}
