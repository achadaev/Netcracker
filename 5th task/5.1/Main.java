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
        long adding;
        long getting;
        long removing;

        for (int i = 0; i < 100000; i++) {
            my.add(i);
            another.add(i);
        }

        long start;

        start = System.nanoTime();
        another.add(75);
        adding = System.nanoTime() - start;

        start = System.nanoTime();
        another.get(50000);
        getting = System.nanoTime() - start;

        start = System.nanoTime();
        another.remove(25000);
        removing = System.nanoTime() - start;

        /*-------------------------------------------*/

/*
        start = System.nanoTime();
        my.add(75);
        adding = System.nanoTime() - start;

        start = System.nanoTime();
        my.get(50000);
        getting = System.nanoTime() - start;

        start = System.nanoTime();
        my.remove(25000);
        removing = System.nanoTime() - start;
*/


        System.out.println("Adding = " + adding);
        System.out.println("Getting = " + getting);
        System.out.println("Removing = " + removing);
    }
}