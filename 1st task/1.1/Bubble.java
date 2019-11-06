import java.util.Arrays;

public class Bubble implements IArray {
    private int[] arr;

    Bubble(int[] arr) {this.arr = arr.clone();}

    @Override
    public long sort() {
        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        long estimatedTime = System.nanoTime() - startTime;
        return estimatedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bubble)) return false;
        Bubble bubble = (Bubble) o;
        return Arrays.equals(arr, bubble.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }
}