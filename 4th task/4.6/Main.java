public class Main {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint(0, 1, 2, 1);
        System.out.println(movablePoint);
        movablePoint.moveUp();
        movablePoint.moveRight();
        System.out.println(movablePoint);

        MovableCircle circle = new MovableCircle(1, 1, 5, 10, 4);
        System.out.println(circle);
        circle.moveDown();
        circle.moveDown();
        circle.moveRight();
        System.out.println(circle);
    }
}
