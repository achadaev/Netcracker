import java.util.Objects;

import static java.lang.Math.PI;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    Circle(){}

    Circle(double radius) {
        this.radius = radius;
    }

    Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return ("Circle[radius=" + radius + ",color=" + color + "]");
    }

    public double getArea() {
        return (PI * (radius * radius));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 &&
                color.equals(circle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, color);
    }
}
