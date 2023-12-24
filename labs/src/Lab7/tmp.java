package Lab7;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class tmp extends JFrame {

    static HashMap<String, String> students = new HashMap<String, String>();

    public static void main(String[] args) {
        tmp f = new tmp();
        f.setVisible(true);
        f.setSize(f.getSize().width + 350, f.getSize().height + 350);
        f.setMinimumSize(f.getSize());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("lab 7");
        f.pack();
    }

    public tmp() {
        // center
        JSplitPane split = new JSplitPane();
        JLabel info = new JLabel("¯\\_(ツ)_/¯", SwingConstants.CENTER);

        final DefaultListModel<String> myListModel = new DefaultListModel<String>();
        final JList<String> myList = new JList<String>();
        JScrollPane myScroll = new JScrollPane(myList);
        myList.setModel(myListModel);

        split.setDividerLocation(250);
        split.setLeftComponent(myScroll);
        split.setRightComponent(info);
        add(split, BorderLayout.CENTER);

        // north
        Box top = new Box(BoxLayout.Y_AXIS);
        JTextField text = new JTextField();
        top.add(text);

        Box under = new Box(BoxLayout.X_AXIS);

        // add
        JButton addButton = new JButton("Add");
        under.add(addButton);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myListModel.addElement(text.getText());
            }
        });

        // remove
        JButton remButton = new JButton("Remove");
        under.add(remButton);
        remButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                students.remove(myList.getSelectedValue().toString());
                myListModel.removeAllElements();
                students.forEach((name, value) -> {
                    myListModel.addElement(name.toString());
                });
            }
        });

        // clear
        JButton clearButton = new JButton("Clear");
        under.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myListModel.clear();
            }
        });

        top.add(under);
        add(top, BorderLayout.NORTH);

        // bot
        Box bot = new Box(BoxLayout.X_AXIS);
        JButton saveButton = new JButton("Save...");
        bot.add(saveButton);

        final FileDialog fdlg = new FileDialog(this, "");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fdlg.setMode(FileDialog.SAVE);
                fdlg.setTitle("Save");
                fdlg.setVisible(true);
                FileWriter myWriter = null;
                try {
                    myWriter = new FileWriter(fdlg.getDirectory() + fdlg.getFile());
                    BufferedWriter myBWriter = new BufferedWriter(myWriter);
                    for (int i = 0; i < myListModel.getSize(); i++) {
                        myBWriter.write("" + myListModel.getElementAt(i));
                        myBWriter.newLine();
                    }
                    myBWriter.close();
                    myWriter.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        bot.add(Box.createHorizontalGlue());
        JButton loadButton = new JButton("Load...");
        bot.add(loadButton);
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fdlg.setMode(FileDialog.LOAD);
                fdlg.setTitle("Load");
                fdlg.setVisible(true);

                FileReader myReader = null;
                try {
                    myReader = new FileReader(fdlg.getDirectory() + fdlg.getFile());
                    myListModel.clear();
                    BufferedReader myBReader = new BufferedReader(myReader);
                    String s;
                    while ((s = myBReader.readLine()) != null) {
                        String[] parts = s.split(" ");
                        String name = parts[0];
                        String value = parts[1] + " " + parts[2];
                        students.put(name, value);
                        info.setText(value);
                        myListModel.addElement(name);
                    }
                    myBReader.close();
                    myReader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        add(bot, BorderLayout.SOUTH);

        myList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

                info.setText(students.get(myList.getSelectedValue().toString()));
            }
        });
    }
}
