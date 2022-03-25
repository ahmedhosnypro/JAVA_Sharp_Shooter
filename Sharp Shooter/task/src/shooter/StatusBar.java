package shooter;

import javax.swing.*;
import java.awt.*;

public class StatusBar extends JLabel {

    public StatusBar() {
        super("Press the SPACE bar to start the game", SwingConstants.CENTER);
        setName("Statusbar");
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setPreferredSize(new Dimension(700, 30));
        setOpaque(true);
    }

    void updateStatus(int attemptsLeft, int totalScore, int lastShot) {
        setText(String.format("Bullets left: %d, your score: %d (%d).", attemptsLeft, totalScore, lastShot));
    }

    void showFinalScore(int finalScore) {
        setText(String.format("Game over, your score: %d.", finalScore));
    }
}