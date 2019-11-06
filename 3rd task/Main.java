public class Main {
    public static void main(String[] args) {
        Ball b = new Ball(2f, 2f, 2, 1, 30);
        Container c = new Container(0, 0, 5, 5);

        for (int i = 0; i < 10; i++) {
            if (!c.collides(b)) {
                if (b.getX() + b.getRadius() >= (c.getX() + c.getWidth())
                        || b.getX() - b.getRadius() <= c.getX())
                    b.reflectHorizontal();
                if (b.getY() + b.getRadius() >= c.getY() + c.getHeight()
                    || b.getY() - b.getRadius() <= c.getY())
                b.reflectVertical();
            }
            b.move();
            System.out.println(b.toString());
            System.out.println();
        }
    }
}
