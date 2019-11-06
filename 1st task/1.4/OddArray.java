import java.util.Arrays;
import java.util.Objects;

public class OddArray implements IArray {
    private int[] arr = new int[50];
    private int count = 0;

    OddArray() {
        for (int j = 1; j <= 99; j++) {
            if (j % 2 != 0) {
                arr[count] = j;
                count++;
            }
        }
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

    @Override
    public void printArr() {
        for (int value : arr) System.out.print(value + " ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OddArray)) return false;
        OddArray oddArray = (OddArray) o;
        return count == oddArray.count &&
                Arrays.equals(arr, oddArray.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(count);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }
}
