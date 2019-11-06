public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(3.5);
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getArea());

        ResizableCircle resizableCircle = new ResizableCircle(5.0);
        System.out.println(resizableCircle.getPerimeter());
        System.out.println(resizableCircle.getArea());
        resizableCircle.resize(-50);
        System.out.println(resizableCircle.getPerimeter());
        System.out.println(resizableCircle.getArea());
    }
}
