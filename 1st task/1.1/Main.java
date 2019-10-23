import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long bubbleTime;
        long selectionTime;
        long arraysTime;

        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        Bubble bubbleArr = new Bubble(arr);
        Selection selectArr = new Selection(arr);

        bubbleTime = bubbleArr.sort();
        selectionTime = selectArr.sort();
        long startTime = System.nanoTime();
        Arrays.sort(arr);
        arraysTime = System.nanoTime() - startTime;

        System.out.println("Bubble-sorting time: " + bubbleTime + " ns");
        System.out.println("Selection-sorting time: " + selectionTime + " ns");
        System.out.println("Arrays.sort()-sorting time: " + arraysTime + " ns");

        System.out.println();
        System.out.println("The smallest time is " + Math.min(Math.min(bubbleTime, selectionTime), arraysTime) + " ns");
        System.out.println("The biggest time is " + Math.max(Math.max(bubbleTime, selectionTime), arraysTime) + " ns");
    }
}
