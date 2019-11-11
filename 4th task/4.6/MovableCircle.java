public class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        MovablePoint movablePoint = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
        this.center = movablePoint;
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }

    @Override
    public void moveUp() {
        center.y += center.ySpeed;
    }

    @Override
    public void moveDown() {
        center.y -= center.ySpeed;
    }

    @Override
    public void moveLeft() {
        center.x -= center.xSpeed;
    }

    @Override
    public void moveRight() {
        center.x += center.xSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovableCircle)) return false;

        MovableCircle that = (MovableCircle) o;

        if (radius != that.radius) return false;
        return center.equals(that.center);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + radius;
        result = 31 * result + center.hashCode();
        return result;
    }
}
