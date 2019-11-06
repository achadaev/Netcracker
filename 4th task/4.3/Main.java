public class Main {
    public static void main(String[] args) {
        Point point = new Point(1.1f, 2.2f);
        System.out.println(point);

        MovablePoint movablePoint = new MovablePoint(4.0f, 5.0f, 1.5f, 0.5f);
        System.out.println(movablePoint);
        System.out.println(movablePoint.move());
    }
}
