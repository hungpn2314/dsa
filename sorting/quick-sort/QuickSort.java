import java.util.Arrays;
import java.util.Random;

/*
    3 steps:
        1 - pivot selection
        2 - partition(arr[], lowIndex, highIndex) -> int
        3 - recursion()
 */
public class QuickSort {
    public static void main(String[] args) {
        // define an array random INT
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.print("BEFORE::: " + Arrays.toString(arr));
        quicksort(arr, 0, arr.length - 1);
        System.out.println("\nAFTER::: " + Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quicksort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int pivotIndex = partition(arr, lowIndex, highIndex); // pivotIndex = j - 1;
            quicksort(arr, lowIndex, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, highIndex);
        }
    }
    public static int partition(int[] arr, int lowIndex, int highIndex) {
        // select pivot as last element
        int pivotValue = arr[highIndex];
        int i = lowIndex, j = lowIndex;
        while (i <= highIndex) {
            if (arr[i] <= pivotValue) {
                swap(arr, i, j);
                j++;
            }
            i++;
        }
        return j - 1;
    }
}
