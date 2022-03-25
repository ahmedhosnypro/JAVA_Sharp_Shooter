package shooter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Canvas extends JPanel implements MouseListener {
    int gunSightX = 340;
    int gunSightY = 340;

    transient ArrayList<BulletHole> bulletHoles = new ArrayList<>();

    Canvas(String name) {
        setName(name);
        setPreferredSize(new Dimension(700, 700));
        setMinimumSize(new Dimension(700, 700));
        setBackground(Color.DARK_GRAY);


        addMouseListener(this);

        //space-32 left-37 up-38 right-39 down-40
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //not used
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case 32 -> shoot();
                    case 37 -> {     //left
                        if (gunSightX >= 40) {
                            gunSightX -= 10;
                        }
                    }
                    case 38 -> {     //up
                        if (gunSightY >= 40) {
                            gunSightY -= 10;
                        }
                    }
                    case 39 -> {     //right
                        if (gunSightX <= 640) {
                            gunSightX += 10;
                        }
                    }
                    case 40 -> {     //down
                        if (gunSightY <= 640) {
                            gunSightY += 10;
                        }
                    }
                }
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //not used
            }
        });
    }

    private void shoot() {
        bulletHoles.add(new BulletHole(gunSightX, gunSightY));
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
        g.fillOval(gunSightX, gunSightY, 20, 20);

        g.setColor(Color.lightGray);
        for (var bh : bulletHoles) {
            g.fillOval(bh.getX(), bh.getY(), 10, 10);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX());
        System.out.println(e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //not used
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //not used
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //not used
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //not used
    }
}
