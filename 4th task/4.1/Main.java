public class Main {
    public static void main(String[] args) {
        Person p = new Person("Sergey", "Moscow");
        System.out.println(p);

        Student s = new Student("Alexey", "NN", "qwe", 2010, 100.5);
        System.out.println(s);

        Staff st = new Staff("Oleg", "Vorkuta", "123", 200.6);
        System.out.println(st);
    }
}
