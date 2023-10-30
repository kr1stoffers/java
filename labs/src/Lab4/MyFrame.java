package Lab4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

public class MyFrame implements ActionListener {
    public JTextField txt;
    public static JSlider slider;
    public static JLabel myLabel;
    public static JFrame frame;

    public static void main(String[] args) {
        new MyFrame();
    }

    public class C_Listener extends ComponentAdapter {
        public void componentResized(ComponentEvent e) {
            myLabel.setText("Window size: " + frame.getWidth() + " " + frame.getHeight());
        }
    }

    public class M_Listener extends MouseAdapter {

        public void mouseEntered(MouseEvent e) {
            myLabel.setText("Slider value: " + slider.getValue());
        }

        public void mouseExited(MouseEvent e) {
            myLabel.setText("Window size: " + frame.getWidth() + " " + frame.getHeight());
        }

        public void mousePressed(MouseEvent e) {
            myLabel.setText("Slider value: " + slider.getValue());
        }

        public void mouseReleased(MouseEvent e) {
            myLabel.setText("Slider value: " + slider.getValue());
        }
    }

    public void actionPerformed(ActionEvent e) {
        txt.setText(e.getActionCommand());
    }

    public MyFrame() {
        frame = new JFrame("lab_4-5");
        frame.addComponentListener(new C_Listener());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(380, 400));
        frame.setSize(650, 500);
        frame.setVisible(true);

        // SOUTH
        myLabel = new JLabel(" ");
        frame.add(myLabel, BorderLayout.SOUTH);

        // NORTH
        Box top = new Box(BoxLayout.Y_AXIS);
        Box firstTOP = new Box(BoxLayout.X_AXIS);
        firstTOP.add(Box.createHorizontalStrut(60));
        firstTOP.add(new JLabel("Метка 1"));
        firstTOP.add(Box.createHorizontalGlue());
        slider = new JSlider(0, 20);
        firstTOP.add(slider);
        slider.addMouseListener(new M_Listener());
        firstTOP.add(Box.createHorizontalGlue());
        firstTOP.add(new JLabel("Метка 2"));
        firstTOP.add(Box.createHorizontalStrut(60));

        top.add(firstTOP);
        txt = new JTextField("Text:");
        top.add(txt);

        frame.add(top, BorderLayout.NORTH);

        // CENTER
        ArrayList<JButton> masJB = new ArrayList<JButton>();
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(4, 5, 15, 15));
        int buttons_flag = 1;
        String[] sign = { "+", "-", "=" };
        int flag_sign = 0;

        for (int i = 0; i < 20; i++) {
            if (i == 3 || i == 8 || i == 13 || i == 15 || i == 17 || i == 18 || i == 19) {
                masJB.add(new JButton(" "));
                leftPanel.add(Box.createHorizontalStrut(frame.getSize().width / 6));
                continue;
            }
            if (i == 16) {
                masJB.add(new JButton("0"));
                leftPanel.add(masJB.get(i));
                masJB.get(i).addActionListener(this);
            } else {
                if (i == 4 || i == 9 || i == 14) {
                    masJB.add(new JButton(sign[flag_sign]));
                    leftPanel.add(masJB.get(i));
                    flag_sign += 1;
                    masJB.get(i).addActionListener(this);
                    continue;
                }
                masJB.add(new JButton(Integer.toString(buttons_flag)));
                leftPanel.add(masJB.get(i));
                masJB.get(i).addActionListener(this);
                buttons_flag += 1;
            }

        }
        frame.add(leftPanel, BorderLayout.CENTER);

        frame.pack();

    }
}
