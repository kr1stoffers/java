package Lab8;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class App {
    static JFrame mainFrame;
    static JScrollPane scrollPane;
    static DB myDB;

    private static Component setMenu(String[] buttonNames, HashMap<String, String> mapForTables) {
        Box mainMenu = new Box(BoxLayout.X_AXIS);
        for (int i = 0; i < buttonNames.length; i++) {
            JButton tempButton = new JButton(buttonNames[i]);
            tempButton.addActionListener(e -> {
                JTable tempTable = myDB.getTableWithJoin(mapForTables.get(e.getActionCommand()));
                mainFrame.remove(scrollPane);
                scrollPane = new JScrollPane(tempTable);
                tempTable.setFillsViewportHeight(true);
                mainFrame.add(scrollPane, BorderLayout.CENTER);
                mainFrame.pack();
            });
            mainMenu.add(tempButton);
        }
        return mainMenu;
    }

    public static void main(String[] args) {

        mainFrame = new JFrame("SuperDB_Viewer");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scrollPane = new JScrollPane();
        String curPath = "jdbc:sqlite:C:/Users/kr1stoffers/Documents/java/labs/src/Lab8/t.sqlite";
        myDB = new DB(curPath);
        String buttonNames[] = { "Show Armouries", "Show Edged", "Show Firearm" };
        String tableNames[] = { "Armouries", "Edged", "Firearm" };
        HashMap<String, String> mapForTables = new HashMap<>();
        for (int i = 0; i < buttonNames.length; i++) {
            mapForTables.put(buttonNames[i], tableNames[i]);
        }
        mainFrame.add(setMenu(buttonNames, mapForTables), BorderLayout.NORTH);
        mainFrame.setSize(700, 500);
        mainFrame.setMinimumSize(mainFrame.getSize());
        mainFrame.setVisible(true);
        mainFrame.pack();
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Exit");
                myDB.closeConnection();
                e.getWindow().dispose();
            }
        });
    }
}
