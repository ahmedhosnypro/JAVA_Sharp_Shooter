package shooter;

import javax.swing.*;
import java.awt.*;

public class SharpShooter extends JFrame {

    public SharpShooter() {
        setTitle("Sharp Shooter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(710, 780);
        setLayout(new FlowLayout());
        setResizable(false);

        setLocationRelativeTo(null);
        setBackground(Color.DARK_GRAY);
        initComponents();

        setVisible(true);
    }

    private void initComponents() {
        addCanvas();
        addStatusBar();
    }

    private void addStatusBar() {
        JPanel statusBar = new JPanel();
        statusBar.setPreferredSize(new Dimension(700, 20));
        statusBar.setMinimumSize((new Dimension(700, 20)));

        JLabel statusBarLabel = new JLabel("You are welcome!");
        statusBarLabel.setName("Statusbar");
        statusBar.add(statusBarLabel);

        add(statusBar);
    }

    private void addCanvas() {
        Canvas canvas = new Canvas("Canvas");

        add(canvas);
        canvas.setFocusable(true);
        canvas.repaint();
    }
}