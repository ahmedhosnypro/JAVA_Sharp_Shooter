package shooter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Canvas extends JPanel implements MouseListener {
    Canvas(String name) {
        setName(name);
        setPreferredSize(new Dimension(700, 700));
        setMinimumSize(new Dimension(700, 700));
        setBackground(Color.DARK_GRAY);

        addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLACK);

        //1-6 circles
        g.fillOval(50, 50, 600, 600);
        g.fillOval(80, 80, 540, 540);
        g.fillOval(110, 110, 480, 480);
        g.fillOval(140, 140, 420, 420);
        g.fillOval(170, 170, 360, 360);
        g.fillOval(200, 200, 300, 300);

        g.setColor(Color.WHITE);

        //7-9 circles
        g.fillOval(230, 230, 240, 240);
        g.fillOval(260, 260, 180, 180);
        g.fillOval(290, 290, 120, 120);

        g.setColor(Color.BLACK);

        //10th circle
        g.fillOval(320, 320, 60, 60);

        //Gun Sight
        g.setColor(Color.RED);
        g.fillOval(280, 480, 40, 40);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX());
        System.out.println(e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
