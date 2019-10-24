public class Main {
    public static void main(String[] args) {
        System.out.println("### a ###");
        RandArray aArray = new RandArray(8, 8, 1, 99);
        aArray.printArray();
        System.out.println();
        aArray.diagonalSumMult();

        System.out.println("\n### b ###");
        RandArray bArray = new RandArray(8, 5, -99, 99);
        bArray.printArray();
        bArray.printMax();

        System.out.println("\n### c ###");
        RandArray cArray = new RandArray(8, 5, -10, 10);
        cArray.printArray();
        cArray.printMaxRowMult();

        System.out.println("\n### d ###");
        RandArray dArray = new RandArray(10, 7, 0, 100);
        dArray.printArray();
        System.out.println();
        dArray.rowSort();
        dArray.printArray();
    }
}
