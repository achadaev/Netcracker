public class Main {
    public static void main(String[] args) {
        MyPolynomial p = new MyPolynomial(1, 2, 3, 4);
        MyPolynomial n = new MyPolynomial(3, 2, 1);

        System.out.println(p.getDegree());
        System.out.println(p.evaluate(2));
        System.out.println(p.toString());
        System.out.println(n.toString());
        System.out.println(p.add(n).toString());
        System.out.println(p.multiple(n).toString());
    }
}
