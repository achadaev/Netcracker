public class Selection implements IArray {
    private int[] arr;

    Selection(int[] arr) {this.arr = arr.clone();}

    @Override
    public long sort() {
        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        long estimatedTime = System.nanoTime() - startTime;
        return estimatedTime;
    }
}