public class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint() {
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] result = {xSpeed, ySpeed};
        return result;
    }

    @Override
    public String toString() {
        return "(" + super.getX() + "," + super.getY() + "),speed=(" + xSpeed + "," + ySpeed + ")";
    }

    public MovablePoint move() {
        super.setXY(super.getX() + xSpeed, super.getY() + ySpeed);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovablePoint)) return false;
        if (!super.equals(o)) return false;

        MovablePoint that = (MovablePoint) o;

        if (Float.compare(that.xSpeed, xSpeed) != 0) return false;
        return Float.compare(that.ySpeed, ySpeed) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (xSpeed != +0.0f ? Float.floatToIntBits(xSpeed) : 0);
        result = 31 * result + (ySpeed != +0.0f ? Float.floatToIntBits(ySpeed) : 0);
        return result;
    }
}
