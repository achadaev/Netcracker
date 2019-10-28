public class Rectangle {
    private float length = 1.0f;
    private float width = 1.0f;

    Rectangle() {}

    Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }


    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public double getArea() {
        return (double) length * width;
    }

    public double getPerimeter() {
        return (double) (length * 2 + width * 2);
    }

    @Override
    public String toString() {
        return ("Rectangle[length=" + length + ",width=" + width + "]");
    }
}
