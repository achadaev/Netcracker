public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width;
        this.y2 = y + height;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return x2 - x1;
    }

    public int getHeight() {
        return y2 - y1;
    }

    public boolean collides(Ball ball) {
        boolean inX = ((ball.getX() + ball.getRadius()) <= x2 && (ball.getX() - ball.getRadius()) >= x1);
        boolean inY = ((ball.getY() + ball.getRadius()) <= y2 && (ball.getY() - ball.getRadius()) >= y1);
        return (inX && inY) ? true : false;
    }

    @Override
    public String toString() {
        return "Container[(" + x1 + "," + y1 + "),(" + x2 + "," + y2 + ")]";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Container)) return false;

        Container container = (Container) object;

        if (x1 != container.x1) return false;
        if (y1 != container.y1) return false;
        if (x2 != container.x2) return false;
        if (y2 != container.y2) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 15;
        result = 31 * result + x1;
        result = 31 * result + y1;
        result = 31 * result + x2;
        result = 31 * result + y2;
        return result;
    }
}
