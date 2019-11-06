import java.util.Objects;

public class MyTriangle {
    private MyPoint v1 = new MyPoint();
    private MyPoint v2 = new MyPoint();
    private MyPoint v3 = new MyPoint();

    MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        v1.setXY(x1, y1);
        v2.setXY(x2, y2);
        v3.setXY(x3, y3);
    }

    MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public String toString() {
        return ("MyTriangle[v1=" + v1.toString() + ",v2=" + v2.toString() + ",v3=" + v3.toString() + "]");
    }

    public double getPerimeter() {
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }

    public String getType() {
        if (v1.distance(v2) == v2.distance(v3)
                && v2.distance(v3) == v3.distance(v1)) {
            return "Equilateral";
        } else if (v1.distance(v2) == v2.distance(v3)
                    || v2.distance(v3) == v3.distance(v1)
                    || v1.distance(v3) == v1.distance(v2)) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyTriangle)) return false;
        MyTriangle that = (MyTriangle) o;
        return v1.equals(that.v1) &&
                v2.equals(that.v2) &&
                v3.equals(that.v3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1, v2, v3);
    }
}
