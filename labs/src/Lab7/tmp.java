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

    static HashMap<String, String[]> students = new HashMap<String, String[]>();

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
        JLabel nm = new JLabel("Имя");
        JLabel ag = new JLabel("Возраст");
        JLabel ad = new JLabel("Адрес");
        Box lable = new Box(BoxLayout.X_AXIS);
        lable.add(Box.createHorizontalGlue());

        lable.add(nm);
        lable.add(Box.createHorizontalGlue());
        lable.add(ag);
        lable.add(Box.createHorizontalGlue());
        lable.add(ad);
        lable.add(Box.createHorizontalGlue());

        top.add(lable);

        Box topText = new Box(BoxLayout.X_AXIS);
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField addresField = new JTextField();
        topText.add(nameField);
        topText.add(ageField);
        topText.add(addresField);
        top.add(topText);

        Box under = new Box(BoxLayout.X_AXIS);

        // add
        JButton addButton = new JButton("Add");
        under.add(addButton);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (nameField.getText().isEmpty()) {
                    return;
                }
                myListModel.addElement(nameField.getText());
                String[] value = new String[2];
                value[0] = ageField.getText();
                value[1] = addresField.getText();
                students.put(nameField.getText(), value);
                nameField.setText("");
                ageField.setText("");
                addresField.setText("");

                info.setText(String.format("<html>Телефон: %s <br>Адрес: %s </html>", value[0], value[1]));
            }
        });

        // remove
        JButton remButton = new JButton("Remove");
        under.add(remButton);
        remButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (myList.getSelectedValue() == null) {
                    return;
                }
                students.remove(myList.getSelectedValue().toString());
                myListModel.removeAllElements();
                students.forEach((name, value) -> {
                    myListModel.addElement(name.toString());
                });
                info.setText("¯\\_(ツ)_/¯");
            }
        });

        // clear
        JButton clearButton = new JButton("Clear");
        under.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myListModel.clear();
                info.setText("¯\\_(ツ)_/¯");
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
                        myBWriter.write(myListModel.getElementAt(i));
                        myBWriter.newLine();
                        myBWriter.write(students.get(myListModel.getElementAt(i))[0]);
                        myBWriter.newLine();
                        myBWriter.write(students.get(myListModel.getElementAt(i))[1]);
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
                    if (fdlg.getFile() == null) {
                        return;
                    }
                    myReader = new FileReader(fdlg.getDirectory() + fdlg.getFile());
                    myListModel.clear();
                    BufferedReader myBReader = new BufferedReader(myReader);
                    String name;
                    while ((name = myBReader.readLine()) != null) {
                        String[] value = new String[2];
                        value[0] = myBReader.readLine();
                        value[1] = myBReader.readLine();

                        students.put(name, value);

                        info.setText(String.format("<html>Телефон: %s <br>Адрес: %s </html>", value[0], value[1]));
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
                if (myList.getSelectedValue() == null) {
                    return;
                }
                info.setText(String.format("<html>Телефон: %s <br>Адрес: %s </html>",
                        students.get(myList.getSelectedValue())[0], students.get(myList.getSelectedValue())[1]));
            }
        });
    }
}
