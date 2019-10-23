import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class RandArray implements IArray {
    private int[] arr;
    public int size;

    RandArray(int size, int min, int max) {
        this.size = size;
        arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int value = random.nextInt(max - min + 1);
            value += min;
            arr[i] = value;
        }
    }

    // Returns most frequent element of array
    public int getMostFreqElement() {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int key : arr) {
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        int mostFreq = 1;
        int mostFreqValue = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > mostFreq) {
                mostFreqValue = entry.getKey();
                mostFreq = entry.getValue();
            } else if (entry.getValue() == mostFreq) {
                System.out.print(entry.getKey() + " and " + mostFreqValue);
                System.out.println(" entries are the same (" + entry.getValue() + ")");
            }
        }
        return mostFreqValue;
    }

    // Returns average value of array
    public int getAverage() {
        int sum = 0;
        for (int value : arr) sum += value;

        return sum / size;
    }

    // Finds min and max element of array,
    // print them and their last entry index
    public void minMax() {
        int min = arr[0];
        int max = arr[0];
        int lastMinIndex = 0;
        int lastMaxIndex = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] <= min) {
                min = arr[i];
                lastMinIndex = i;
            }
            if (arr[i] >= max) {
                max = arr[i];
                lastMaxIndex = i;
            }
        }

        System.out.println("Minimal element: " + min + "\nLast index: " + lastMinIndex);
        System.out.println("Maximal element: " + max + "\nLast index: " + lastMaxIndex);
    }

    // Changes odd-index elements to 0
    public void oddToZero() {
        for (int i = 0; i < size; i += 2) {
            arr[i] = 0;
        }
    }

    // Counts odd and even elements and print them
    public void countOddEven() {
        int[] oddArr = new int[20];
        int[] evenArr = new int[20];
        int odd = 0;
        int even = 0;

        for (int value : arr) {
            if (value % 2 == 0) {
                evenArr[even] = value;
                even++;
            }
            else {
                oddArr[odd] = value;
                odd++;
            }
        }

        System.out.println("Count of odd elements: " + odd);
        for (int i = 0; i < odd; i++) System.out.print(oddArr[i] + " ");
        System.out.println("\nCount of even elements: " + even);
        for (int i = 0; i < even; i++) System.out.print(evenArr[i] + " ");
    }

    @Override
    public void printArr() {
        for (int value : arr) System.out.print(value + " ");
    }

    @Override
    public int[] sort(boolean isAscending) {
        if (isAscending) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] < arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
                return arr;
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            return arr;
        }
        return null;
    }
}
