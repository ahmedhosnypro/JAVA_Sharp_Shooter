package shooter;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import static java.awt.event.KeyEvent.*;

public class Game extends KeyAdapter {
    private enum GameState {
        START, GAME, END
    }

    private static final Point center = new Point(350, 350);
    private static GameState gameState = GameState.START;
    private static int lastShotScore = 0;
    private static int ATTEMPTS = 12;
    private final StatusBar statusBar;
    private final Canvas target;

    public Game(Canvas target, StatusBar statusBar) {
        this.target = target;
        this.statusBar = statusBar;
        target.addInstructions();
        target.addKeyListener(this);
    }

    private static void shoot(Canvas target, Point bulletHole) {
        lastShotScore = Math.max(0, 10 - (int) center.distance(bulletHole) / 30);
        target.holes.put(bulletHole.getLocation(), lastShotScore);
    }

    private void move(Canvas target, Point aim, int keyPressed) {
        if (keyPressed == VK_UP && aim.y > 40) aim.y -= 10;
        if (keyPressed == VK_DOWN && aim.y < target.getHeight() - 40) aim.y += 10;
        if (keyPressed == VK_LEFT && aim.x > 40) aim.x -= 10;
        if (keyPressed == VK_RIGHT && aim.x < target.getWidth() - 40) aim.x += 10;
        Canvas.sight.setLocation(aim);
    }

    private int getTotalScore(Canvas target) {
        return target.holes.values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        switch (gameState) {
            case START:
                if (e.getKeyCode() == VK_SPACE) {
                    statusBar.updateStatus(ATTEMPTS, getTotalScore(target), lastShotScore);
                    gameState = GameState.GAME;
                }
                break;
            case GAME:
                if (List.of(VK_UP, VK_DOWN, VK_LEFT, VK_RIGHT).contains(e.getKeyCode())) {
                    move(target, Canvas.sight.getLocation(), e.getKeyCode());
                } else if (e.getKeyCode() == VK_SPACE) {
                    shoot(target, Canvas.sight.getLocation());
                    if (--ATTEMPTS != 0) statusBar.updateStatus(ATTEMPTS, getTotalScore(target), lastShotScore);
                    else {
                        statusBar.showFinalScore(getTotalScore(target));
                        gameState = GameState.END;
                    }
                }
                target.repaint();
        }
    }
}