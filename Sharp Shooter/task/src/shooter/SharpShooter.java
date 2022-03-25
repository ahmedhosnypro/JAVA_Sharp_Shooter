package shooter;

import javax.swing.*;
import java.awt.*;

public class SharpShooter extends JFrame {

    public SharpShooter() {
        super("Sharp Shooter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException
                | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        var target = new Canvas();
        var statusBar = new StatusBar();
        add(target, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        new Game(target, statusBar );
    }
}