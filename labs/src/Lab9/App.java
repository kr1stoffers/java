package Lab9;

import java.io.File;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FileDialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.TableModel;

public class App {
    static JFrame mainFrame;
    static JScrollPane scrollPane;
    static DB myDB;
    static FileDialog fdlg;
    static String curTableName = "";

    private static Component setMenu(String[] buttonNames, HashMap<String, String> mapForTables,
            HashMap<String, String> mapForTablesRus) {
        Box mainMenu = new Box(BoxLayout.X_AXIS);
        for (int i = 1; i < buttonNames.length; i++) {
            final String currButton = buttonNames[i];
            JButton tempButton = new JButton(currButton);
            tempButton.addActionListener(e -> {
                JFrame newFrame = new JFrame(currButton);

                JTable tempTable = myDB.getTableWithJoin(mapForTables.get(e.getActionCommand()));
                curTableName = mapForTablesRus.get(e.getActionCommand());
                scrollPane = new JScrollPane(tempTable);
                tempTable.setFillsViewportHeight(true);
                newFrame.add(scrollPane, BorderLayout.CENTER);
                newFrame.setSize(700, 500);
                newFrame.setMinimumSize(mainFrame.getSize());
                newFrame.add(setBottom(), BorderLayout.SOUTH);

                newFrame.setVisible(true);
                newFrame.pack();
                // BorderLayout layout = (BorderLayout) newFrame.getContentPane().getLayout();
                // Box southBox = (Box) layout.getLayoutComponent(BorderLayout.SOUTH);
                // for (int j = 0; j < southBox.getComponentCount(); j++) {
                // southBox.getComponent(j).setEnabled(true);
                // }

            });
            mainMenu.add(tempButton);
        }
        JTable mainTable = myDB.getTableWithJoin(mapForTables.get(buttonNames[0]));
        scrollPane = new JScrollPane(mainTable);
        mainTable.setFillsViewportHeight(true);
        mainFrame.add(scrollPane, BorderLayout.CENTER);
        mainFrame.pack();
        return mainMenu;
    }

    private static Component setBottom() {
        Box bottom = new Box(BoxLayout.X_AXIS);
        JButton toWord = new JButton("toWord");
        toWord.addActionListener(e -> {
            String[] columnNames = getTableHeader();
            String[][] data = getTableData();
            File file = getFile("Save to Word file", "docx");

            if (!file.getName().contains("nullnull"))
                ToOffice.toWordDocx(columnNames, data, file,
                        curTableName);
        });
        // toWord.setEnabled(false);
        bottom.add(toWord);
        bottom.add(Box.createHorizontalGlue());
        JButton toExcel = new JButton("toExcel");
        toExcel.addActionListener(e -> {
            String[] columnNames = getTableHeader();
            String[][] data = getTableData();
            File file = getFile("Save to Excel file", "xls");
            if (!file.getName().contains("nullnull"))
                ToOffice.toExcel(columnNames, data, file,
                        curTableName);
        });
        // toExcel.setEnabled(false);
        bottom.add(toExcel);
        return bottom;
    }

    private static File getFile(String caption, String ext) {
        // System.out.println(caption);
        fdlg.setTitle(caption);
        fdlg.setFile("*." + ext);
        fdlg.setVisible(true);
        String fileName = fdlg.getDirectory() + fdlg.getFile();
        if (!fileName.contains("." + ext))
            fileName = fileName.concat("." + ext);
        File file = new File(fileName);
        // System.out.println("file = " + file);
        return file;
    }

    private static String[] getTableHeader() {
        JViewport viewPort = (JViewport) scrollPane.getComponent(0);
        JTable tempTable = (JTable) viewPort.getComponent(0);
        TableModel tableModel = tempTable.getModel();
        int colCount = tableModel.getColumnCount();
        String[] columnNames = new String[colCount];
        for (int i = 0; i < colCount; i++) {
            columnNames[i] = tableModel.getColumnName(i);
        }
        // System.out.println(" " + Arrays.asList(columnNames));
        return columnNames;
    }

    private static String[][] getTableData() {
        JViewport viewPort = (JViewport) scrollPane.getComponent(0);
        JTable tempTable = (JTable) viewPort.getComponent(0);
        TableModel tableModel = tempTable.getModel();
        int colCount = tableModel.getColumnCount();
        int rowCount = tableModel.getRowCount();
        String[][] data = new String[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i][j] = (String) tableModel.getValueAt(i, j);
            }
        }
        return data;
    }

    public static void main(String[] args) {

        mainFrame = new JFrame("Armouries");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scrollPane = new JScrollPane();
        String curPath = "jdbc:sqlite:C:/Users/kr1stoffers/Documents/java/labs/src/Lab9/t.sqlite";
        myDB = new DB(curPath);
        String buttonNames[] = { "Show Armouries", "Show Edged", "Show Firearm" };
        String tableNames[] = { "Armouries", "Edged", "Firearm" };
        String tableNamesRus[] = { "Арсенал", "Холодное оружие", "Огнестрел" };

        HashMap<String, String> mapForTables = new HashMap<>();
        HashMap<String, String> mapForTablesRus = new HashMap<>();
        for (int i = 0; i < buttonNames.length; i++) {
            mapForTables.put(buttonNames[i], tableNames[i]);
            mapForTablesRus.put(buttonNames[i], tableNamesRus[i]);
        }
        mainFrame.add(setMenu(buttonNames, mapForTables, mapForTablesRus), BorderLayout.NORTH);
        mainFrame.setSize(700, 500);
        mainFrame.add(setBottom(), BorderLayout.SOUTH);
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
        fdlg = new FileDialog(mainFrame, ""); // создаем диалог работы с файлами
        fdlg.setMode(FileDialog.SAVE); // делаем созданный диалог диалогом сохранения
    }
}
