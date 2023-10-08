package Lab4;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class MyFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("lab4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 500);
        setWest(frame);
        setEast(frame);
        frame.setVisible(true);
        setNorth(frame);
        frame.setMinimumSize(frame.getSize());
        frame.pack();
    }

    public static void setNorth(JFrame fr) {
        Box top = new Box(BoxLayout.Y_AXIS);
        Box firstTOP = new Box(BoxLayout.X_AXIS);
        firstTOP.add(Box.createHorizontalStrut(60));
        firstTOP.add(new JLabel("Метка 1"));
        firstTOP.add(Box.createHorizontalGlue());
        firstTOP.add(new JSlider(0, 20));
        firstTOP.add(Box.createHorizontalGlue());
        firstTOP.add(new JLabel("Метка 2"));
        firstTOP.add(Box.createHorizontalStrut(60));

        top.add(firstTOP);
        top.add(new JTextField("Текстовое поле"));

        fr.add(top, BorderLayout.NORTH);

    }

    public static void setWest(JFrame fr) {
        ArrayList<JButton> masJB = new ArrayList<JButton>();
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(4, 3, 15, 15));

        for (int i = 0; i < 12; i++) {
            if (i == 9 || i == 11) {
                masJB.add(new JButton(" "));
                leftPanel.add(Box.createHorizontalStrut(fr.getSize().width / 6));
                continue;
            }
            if (i == 10) {
                masJB.add(new JButton("0"));
                leftPanel.add(masJB.get(i));

            } else {
                masJB.add(new JButton(Integer.toString(i + 1)));
                leftPanel.add(masJB.get(i));
            }

        }
        fr.add(leftPanel, BorderLayout.WEST);
    }

    public static void setEast(JFrame fr) {
        JPanel rightPanel = new JPanel();
        String[] sign = { "+", "-", "=" };
        rightPanel.setLayout(new GridLayout(4, 1, 15, 15));

        for (int i = 0; i < 4; i++) {
            if (i != 3) {
                rightPanel.add(new JButton(sign[i]));
            } else {
                rightPanel.add(Box.createHorizontalStrut(fr.getSize().width / 6));
            }

        }
        fr.add(rightPanel, BorderLayout.EAST);
    }

}
