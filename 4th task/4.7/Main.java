public class Main {
    public static void main(String[] args) {
        MovablePoint p1 = new MovablePoint(0, 2, 1, 1);
        MovablePoint p2 = new MovablePoint(4, 0, 1, 1);

        System.out.println(p1);
        System.out.println(p2);

        MovableRectangle movableRectangle = new MovableRectangle(0, 2, 4, 0, 1, 1);
        movableRectangle.moveUp();
        System.out.println(movableRectangle);
        movableRectangle.moveRight();
        System.out.println(movableRectangle);
    }
}
