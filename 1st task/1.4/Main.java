public class Main {
    public static void main(String[] args) {
        System.out.println("### a ###");
        OddArray oddArr = new OddArray();
        oddArr.printArr();

        System.out.println();
        oddArr.sort(false);
        oddArr.printArr();

        System.out.println("\n\n### b ###");
        RandArray bArray = new RandArray(20, 0, 10);
        bArray.printArr();
        System.out.println();
        bArray.countOddEven();

        System.out.println("\n\n### c ###");
        RandArray cArray = new RandArray(10,1, 100);
        cArray.printArr();
        cArray.oddToZero();
        System.out.println();
        cArray.printArr();

        System.out.println("\n\n### d ###");
        RandArray dArray = new RandArray(15, -50, 50);
        dArray.printArr();
        System.out.println();
        dArray.minMax();

        System.out.println("\n### e ###");
        RandArray eArray1 = new RandArray(10, 0, 10);
        RandArray eArray2 = new RandArray(10, 0, 10);
        int average1 = eArray1.getAverage();
        int average2 = eArray2.getAverage();
        System.out.println("1st array average: " + average1);
        System.out.println("2nd array average: " + average2);
        if (average1 > average2) System.out.println("Average of the 1st array is bigger");
        else if (average1 < average2) System.out.println("Average of the 2nd array is bigger");
        else System.out.println("Average values of arrays are equal");

        System.out.println("\n### f ###");
        RandArray fArray = new RandArray(20, -1, 1);
        System.out.println("Most frequent element: " + fArray.getMostFreqElement());
    }
}
