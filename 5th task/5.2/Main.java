import java.util.*;

public class Main {
    public static void main(String[] args) {
        long start;

        //###### ArrayList vs LinkedList ######

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        start = System.nanoTime();
        arrayList.add(1);
        long arrayListAdd = System.nanoTime() - start;
        start = System.nanoTime();
        linkedList.add(1);
        long linkedListAdd = System.nanoTime() - start;

        start = System.nanoTime();
        arrayList.set(50000, 1);
        long arrayListSet = System.nanoTime() - start;
        start = System.nanoTime();
        linkedList.set(50000, 1);
        long linkedListSet = System.nanoTime() - start;

        start = System.nanoTime();
        arrayList.remove(99999);
        long arrayListRemove = System.nanoTime() - start;
        start = System.nanoTime();
        linkedList.remove(99999);
        long linkedListRemove = System.nanoTime() - start;

        //###### HashSet vs LinkedHashSet vs TreeSet ######

        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < 100000; i++) {
            hashSet.add(i);
            linkedHashSet.add(i);
            treeSet.add(i);
        }

        start = System.nanoTime();
        hashSet.add(150000);
        long hashSetAdd = System.nanoTime() - start;
        start = System.nanoTime();
        linkedHashSet.add(150000);
        long linkedHashSetAdd = System.nanoTime() - start;
        start = System.nanoTime();
        treeSet.add(150000);
        long treeSetAdd = System.nanoTime() - start;

        start = System.nanoTime();
        hashSet.remove(99999);
        long hashSetRemove = System.nanoTime() - start;
        start = System.nanoTime();
        linkedHashSet.remove(99999);
        long linkedHashSetRemove = System.nanoTime() - start;
        start = System.nanoTime();
        treeSet.remove(99999);
        long treeSetRemove = System.nanoTime() - start;

        //###### HashMap vs LinkedHashMap vs TreeMap

        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < 100000; i++) {
            hashMap.put(i, i * 2);
            linkedHashMap.put(i, i * 2);
            treeMap.put(i, i * 2);
        }

        start = System.nanoTime();
        hashMap.put(150000, 1);
        long hashMapPut = System.nanoTime() - start;
        start = System.nanoTime();
        linkedHashMap.put(150000, 1);
        long linkedHashMapPut = System.nanoTime() - start;
        start = System.nanoTime();
        treeMap.put(150000, 1);
        long treeMapPut = System.nanoTime() - start;

        start = System.nanoTime();
        hashMap.get(99999);
        long hashMapGet = System.nanoTime() - start;
        start = System.nanoTime();
        linkedHashMap.get(99999);
        long linkedHashMapGet = System.nanoTime() - start;
        start = System.nanoTime();
        treeMap.get(99999);
        long treeMapGet = System.nanoTime() - start;

        start = System.nanoTime();
        hashMap.remove(99999);
        long hashMapRemove = System.nanoTime() - start;
        start = System.nanoTime();
        linkedHashMap.remove(99999);
        long linkedHashMapRemove = System.nanoTime() - start;
        start = System.nanoTime();
        treeMap.remove(99999);
        long treeMapRemove = System.nanoTime() - start;

        //###### Comparing results ######

        System.out.println("###### ArrayList vs LinkedList ######\n");
        System.out.println("arrayListAdd = " + arrayListAdd);
        System.out.println("linkedListAdd = " + linkedListAdd + "\n");
        System.out.println("arrayListSet = " + arrayListSet);
        System.out.println("linkedListSet = " + linkedListSet + "\n");
        System.out.println("arrayListRemove = " + arrayListRemove);
        System.out.println("linkedListRemove = " + linkedListRemove + "\n");

        System.out.println("###### HashSet vs LinkedHashSet vs TreeSet ######\n");
        System.out.println("hashSetAdd = " + hashSetAdd);
        System.out.println("linkedHashSetAdd = " + linkedHashSetAdd);
        System.out.println("treeSetAdd = " + treeSetAdd + "\n");
        System.out.println("hashSetRemove = " + hashSetRemove);
        System.out.println("linkedHashSetRemove = " + linkedHashSetRemove);
        System.out.println("treeSetRemove = " + treeSetRemove + "\n");

        System.out.println("###### HashMap vs LinkedHashMap vs TreeMap ######");
        System.out.println("hashMapPut = " + hashMapPut);
        System.out.println("linkedHashMapPut = " + linkedHashMapPut);
        System.out.println("treeMapPut = " + treeMapPut + "\n");
        System.out.println("hashMapGet = " + hashMapGet);
        System.out.println("linkedHashMapGet = " + linkedHashMapGet);
        System.out.println("treeMapGet = " + treeMapGet + "\n");
        System.out.println("hashMapRemove = " + hashMapRemove);
        System.out.println("linkedHashMapRemove = " + linkedHashMapRemove);
        System.out.println("treeMapRemove = " + treeMapRemove);
    }
}
