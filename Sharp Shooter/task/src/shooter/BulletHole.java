package shooter;

public class BulletHole {
    private final int X;
    private final int Y;

    public BulletHole(int x, int y) {
        X = x + 5;
        Y = y + 5;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
