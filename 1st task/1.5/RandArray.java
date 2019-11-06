import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class RandArray {
    private int[][] arr;
    public int rows;
    public int columns;

    RandArray(int rows, int columns, int min, int max) {
        this.rows = rows;
        this.columns = columns;
        arr = new int[rows][columns];

        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int value = random.nextInt(max - min + 1);
                value += min;
                arr[i][j] = value;
            }
        }
    }

    // Sorts rows descending
    public void rowSort() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < j; k++) {
                    if (arr[i][j] > arr[i][k]) {
                        int temp = arr[i][j];
                        arr[i][j] = arr[i][k];
                        arr[i][k] = temp;
                    }
                }
            }
        }
    }

    // Prints maximal rows multiply by module and it's index
    public void printMaxRowMult() {
        int[] multArray = new int[rows];
        for (int i = 0; i < rows; i++) {
            int mult = 1;
            for (int j = 0; j < columns; j++) {
                if (arr[i][j] < 0) {
                    mult *= (arr[i][j] * -1);
                } else {
                    mult *= arr[i][j];
                }
            }
            multArray[i] = mult;
        }

        int maxMult = 0;
        int maxMultIndex = 0;
        for (int i = 0; i < multArray.length; i++) {
            if (multArray[i] > maxMult) {
                maxMult = multArray[i];
                maxMultIndex = i;
            }
        }

        System.out.println("Maximal rows multiply: " + maxMult + " (" + maxMultIndex + ")");
    }

    // Prints maximal element and it's indexes
    public void printMax() {
        int maxValue = arr[0][0];
        int maxI = 0;
        int maxJ = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (arr[i][j] > maxValue) {
                    maxValue = arr[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        System.out.println("Maximal element: " + maxValue + " (" + maxI + ", " + maxJ + ")");
    }

    // Prints sum and multiply of main and side diagonals
    public void diagonalSumMult() {
        int mainSum = 0;
        int sideSum = 0;
        long mainMult = 1;
        long sideMult = 1;

        // To count diagonals matrix should be N x N
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == j) {
                    mainSum += arr[i][j];
                    mainMult *= arr[i][j];
                } else if (i == (rows - j) - 1) {
                    sideSum += arr[i][j];
                    sideMult *= arr[i][j];
                }
            }
        }

        System.out.println("Sum of main diagonal: " + mainSum);
        System.out.println("Multiply of main diagonal: " + mainMult);
        System.out.println("Sum of side diagonal: " + sideSum);
        System.out.println("Multiply of side diagonal: " + sideMult);
    }

    public void printArray() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (arr[i][j] >= 0) System.out.print(" ");
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RandArray)) return false;
        RandArray randArray = (RandArray) o;
        return rows == randArray.rows &&
                columns == randArray.columns &&
                Arrays.equals(arr, randArray.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rows, columns);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }
}
