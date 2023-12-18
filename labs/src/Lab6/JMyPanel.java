package Lab6;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class JMyPanel extends JPanel { // наш класс является наследником класса JPanel
    // создаем перечисление используемых параметров
    public static enum Figure {
        LINE, OVAL, RECT, ROUNDRECT, SURNAME, CLEAR
    };

    private Figure vibor = Figure.CLEAR; // объявляем переменную типа созданного перечисления
    // и присваиваем ей значение CLEAR

    public JMyPanel() {
    } // конструктор нашего класса

    public void ris(String s) {// метод, вызов которого приводит к перерисовке панели
        // параметр s принимает значение во время вызова данного метода (см.
        // MyGraph.java)
        vibor = Figure.valueOf(s); // устанавливаем, что нужно нарисовать
        repaint(); // перерисовываем нашу панель, т.е. вызываем метод paintComponent
    }

    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;
        BasicStroke pen;// создаем перо, параметры которого будут определять стиль линий
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        switch (vibor) {
            case LINE:

                pen = new BasicStroke(20, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
                g.setStroke(pen);// делаем текущим пером созданное нами
                g.setColor(Color.blue);// задаем цвет пера
                g.drawLine(20, 20, 100, 100);
                break;
            case OVAL:

                float[] dash = { 10, 30 };

                pen = new BasicStroke(10, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10, dash, 0);
                g.setStroke(pen);
                g.setColor(Color.red);

                g.setPaint(new GradientPaint(30, 30, Color.red, 50, 50, Color.green, true));
                g.fill(new Ellipse2D.Double(20, 20, 100, 100));
                break;
            case RECT:
                float[] dash2 = { 20, 20 };
                pen = new BasicStroke(5, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 1, dash2, 0);
                g.setStroke(pen);
                g.setColor(Color.magenta);
                g.drawRect(20, 20, 100, 100);
                break;
            case ROUNDRECT:
                float[] dash3 = { 20, 20, 2, 20, 2, 20 };
                pen = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 1, dash3, 0);
                g.setStroke(pen);
                g.setColor(Color.yellow);
                g.drawRoundRect(20, 20, 100, 100, 60, 60);
                break;
            case SURNAME:
                pen = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
                g.setStroke(pen);
                g.setColor(Color.green);

                // H
                g.drawLine(20, 20, 20, 100);
                g.drawLine(20, 60, 50, 60);
                g.drawLine(50, 20, 50, 100);

                // A
                pen = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 5, new float[] { 15, 10 }, 0);
                g.setStroke(pen);
                g.setColor(Color.MAGENTA);

                g.drawLine(70, 100, 85, 20);
                g.drawLine(85, 20, 100, 100);
                g.drawLine(80, 80, 90, 80);

                // З
                pen = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 5, new float[] { 15, 10 }, 0);
                g.setStroke(pen);
                g.setColor(Color.red);
                g.drawArc(100, 20, 40, 40, 110, -180);
                g.drawArc(100, 60, 40, 40, 90, -190);

                // M
                pen = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 5, new float[] { 15, 10 }, 0);
                g.setStroke(pen);
                g.setColor(Color.black);
                g.drawLine(160, 100, 175, 20);
                g.drawLine(175, 20, 190, 100);
                g.drawLine(190, 100, 205, 20);
                g.drawLine(205, 20, 220, 100);

                // И
                pen = new BasicStroke(10, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10, new float[] { 15, 20 },
                        0);
                g.setStroke(pen);
                g.setColor(Color.cyan);
                g.drawLine(240, 20, 240, 100);
                g.drawLine(240, 100, 270, 20);
                g.drawLine(270, 20, 270, 100);

                // E
                pen = new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
                g.setStroke(pen);
                g.setColor(Color.ORANGE);
                g.drawLine(290, 20, 290, 100);
                g.drawLine(290, 20, 320, 20);
                g.drawLine(290, 60, 320, 60);
                g.drawLine(290, 100, 320, 100);

                // B
                pen = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 5, new float[] { 15, 10 }, 0);
                g.setStroke(pen);
                g.setColor(Color.GRAY);
                g.drawLine(340, 20, 340, 100);
                g.drawArc(320, 20, 40, 40, 90, -180);
                g.drawArc(330, 60, 40, 40, 90, -210);

                break;

            case CLEAR:
                g.clearRect(0, 0, getSize().width, getSize().height);
                break;
        }
    }
}
