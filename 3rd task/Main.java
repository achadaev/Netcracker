public class Main {
    public static void main(String[] args) {
        Ball b = new Ball(2f, 2f, 2, 1, 30);
        Container c = new Container(0, 0, 5, 5);

        for (int i = 0; i < 10; i++) {
            if (!c.collides(b)) {
                b.reflectHorizontal();
                b.reflectVertical();
            }
            b.move();
            System.out.println(b.toString());
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }
}
