package shooter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class Canvas extends JPanel {
    final Map<Point, Integer> holes = new IdentityHashMap<>();
    private static final BufferedImage TARGET = createTargetImage();
    static final JLabel sight = new JLabel();
    final BufferedImage SIGHT_IMAGE;

    public Canvas() {
        setName("Canvas");
        setPreferredSize(new Dimension(700, 700));
        setBackground(Color.DARK_GRAY);
        setFocusable(true);
        setLayout(null);
        sight.setPreferredSize(new Dimension(80, 80));
        sight.setLocation(new Point(350, 350));
        add(sight);
        SIGHT_IMAGE = createSightImage();
    }

    private static BufferedImage createTargetImage() {
        BufferedImage image = new BufferedImage(700, 700, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2D = image.createGraphics();
        g2D.setColor(Color.BLACK);
        g2D.fillOval(50, 50, 600, 600);
        g2D.setColor(Color.WHITE);
        g2D.fillOval(230, 230, 240, 240);
        g2D.setColor(Color.BLACK);
        g2D.fillOval(320, 320, 60, 60);
        g2D.setFont(new Font("Tahoma", Font.PLAIN | Font.BOLD, 20));
        for (int i = 0, n = 1; n <= 10; i += 30, n++) {
            g2D.setColor(n > 6 ? Color.BLACK : Color.WHITE);
            g2D.drawOval(50 + i, 50 + i, 600 - 2 * i, 600 - 2 * i);
            if (n != 10) {
                g2D.drawString(String.valueOf(n), 60 + i, 358);
                g2D.drawString(String.valueOf(n), 630 - i, 358);
                g2D.drawString(String.valueOf(n), 344, 72 + i);
                g2D.drawString(String.valueOf(n), 344, 643 - i);
            }
        }
        return image;
    }

    private static BufferedImage createSightImage() {
        BufferedImage image = new BufferedImage(80, 80, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2D = image.createGraphics();
        g2D.setColor(Color.RED);
        g2D.setStroke(new BasicStroke(1f));
        g2D.drawLine(0, 40, 35, 40);
        g2D.drawLine(45, 40, 80, 40);
        g2D.drawLine(40, 0, 40, 35);
        g2D.drawLine(40, 45, 40, 80);
        g2D.setStroke(new BasicStroke(3f));
        g2D.drawOval(1, 1, 78, 78);
        return image;
    }

    void addInstructions() {
            var legend = new JLabel("<html><font color=red size=+1><b>\u2192 \u2190 \u2191 \u2193</b></font> - aim<br>" +
                "<font color=red>SPACE</font> - shot", SwingConstants.RIGHT);
        legend.setSize(new Dimension(100, 40));
        legend.setForeground(Color.WHITE);
        legend.setFont(new Font("Arial", Font.PLAIN, 10));
        add(legend);
        legend.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(TARGET, 0, 0, this);
        g2D.setColor(Color.CYAN);
        holes.keySet().forEach(h -> g2D.fillOval(h.x - 5, h.y - 5, 10, 10));
        var point = sight.getLocation();
        g2D.drawImage(SIGHT_IMAGE, point.x - 40, point.y - 40, null);
    }
}