public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        cycle(25);
        long cycleTime = System.nanoTime() - startTime;
        startTime = System.nanoTime();
        recursion(25);
        long recursionTime = System.nanoTime() - startTime;


        System.out.println("Cycle time: " + cycleTime + " ns");
        System.out.println("Recursion time: " + recursionTime + " ns");

        String res = (cycleTime < recursionTime) ? "Cycle" : "Recursion";
        System.out.println(res + " algorithm is faster");
    }

    public static long recursion(long value) {
        if (value == 0) return 1;
        else return (value * recursion(value - 1));
    }

    public static long cycle(int value) {
        long result = 1;
        for (int i = 1; i <= value; i++) {
            result *= i;
        }
        return result;
    }
}
