public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = (float) (speed * Math.cos(direction));
        this.yDelta = (float) (-speed * Math.sin(direction));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getXDelta() {
        return xDelta;
    }

    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getYDelta() {
        return yDelta;
    }

    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal() {
        xDelta = -xDelta;
    }

    public void reflectVertical() {
        yDelta = -yDelta;
    }

    @Override
    public String toString() {
        return "Ball[(" + x + "," + y + "),speed=(" + xDelta + "," + yDelta + ")]";
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Ball)) return false;
        if (!super.equals(object)) return false;

        Ball ball = (Ball) object;

        if (Float.compare(ball.x, x) != 0) return false;
        if (Float.compare(ball.y, y) != 0) return false;
        if (radius != ball.radius) return false;
        if (Float.compare(ball.xDelta, xDelta) != 0) return false;
        if (Float.compare(ball.yDelta, yDelta) != 0) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (x != +0.0f ? Float.floatToIntBits(x) : 0);
        result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
        result = 31 * result + radius;
        result = 31 * result + (xDelta != +0.0f ? Float.floatToIntBits(xDelta) : 0);
        result = 31 * result + (yDelta != +0.0f ? Float.floatToIntBits(yDelta) : 0);
        return result;
    }
}
