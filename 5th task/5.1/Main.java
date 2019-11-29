import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        for (int i = 6; i > 0; i--) {
            myLinkedList.add(i);
        }

        myLinkedList.forEach(System.out::println);
        System.out.println();

        System.out.println("myLinkedList.add(1, 8)");
        myLinkedList.add(1, 8);
        myLinkedList.forEach(System.out::println);
        System.out.println();

        System.out.println("myLinkedList.get(3) = " + myLinkedList.get(3));
        System.out.println();

        System.out.println("myLinkedList.indexOf(5) = " + myLinkedList.indexOf(5));
        System.out.println();

        System.out.println("myLinkedList.remove(1) = " + myLinkedList.remove(1));
        myLinkedList.forEach(System.out::println);
        System.out.println();

        System.out.println("myLinkedList.set(5, 10) = " + myLinkedList.set(5, 10));
        myLinkedList.forEach(System.out::println);
        System.out.println();

        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        System.out.println();

        Integer[] arr = new Integer[5];
        System.out.println("myLinkedList.toArray(E[] array)");
        for (Integer i : myLinkedList.toArray(arr))
            System.out.println(i);
        System.out.println();

        System.out.println("myLinkedList.toArray()");
        for (Object o : myLinkedList.toArray())
            System.out.println(o);
        System.out.println();

        System.out.println("myLinkedList.toString()");
        System.out.println(myLinkedList);
        System.out.println();

        System.out.println("myLinkedList.clear()");
        myLinkedList.clear();
        myLinkedList.forEach(System.out::println);
        System.out.println();


        System.out.println("/*------------------------------ Testing ---------------------------------*/\n");


        MyLinkedList<Integer> my = new MyLinkedList<>();
        LinkedList<Integer> another = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            my.add(i);
            another.add(i);
        }

        long start;

        start = System.nanoTime();
        another.add(75);
        long anotherAdd = System.nanoTime() - start;

        start = System.nanoTime();
        another.get(50000);
        long anotherGet = System.nanoTime() - start;

        start = System.nanoTime();
        another.remove(25000);
        long anotherRemove = System.nanoTime() - start;

        /*-------------------------------------------*/

        start = System.nanoTime();
        my.add(75);
        long myAdd = System.nanoTime() - start;

        start = System.nanoTime();
        my.get(50000);
        long myGet = System.nanoTime() - start;

        start = System.nanoTime();
        my.remove(25000);
        long myRemove = System.nanoTime() - start;


        System.out.println("myAdd = " + myAdd);
        System.out.println("anotherAdd = " + anotherAdd);
        System.out.println();
        System.out.println("myGet = " + myGet);
        System.out.println("anotherGet = " + anotherGet);
        System.out.println();
        System.out.println("myRemove = " + myRemove);
        System.out.println("anotherRemove = " + anotherRemove);
    }
}
