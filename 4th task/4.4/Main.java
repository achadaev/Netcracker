public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);

        Circle circle = new Circle(2.3);
        System.out.println(circle);

        Rectangle rectangle = new Rectangle("blue", false, 4.5, 5.0);
        System.out.println(rectangle);

        Square square = new Square("green", true, 10.4);
        System.out.println(square);
    }
}
