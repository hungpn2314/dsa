import java.util.Arrays;
import java.util.Random;

public class ReverseArray {
    public static void main(String[] args) {
        // define an array random INT
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.print("BEFORE::: " + Arrays.toString(arr));
        reverse(arr);
        System.out.println("\nAFTER::: " + Arrays.toString(arr));
    }

    public static void reverse(int[] arr) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        while (firstIndex < lastIndex) {
            // swap 2 value
            int temp = arr[firstIndex];
            arr[firstIndex] = arr[lastIndex];
            arr[lastIndex] = temp;
            firstIndex++;
            lastIndex--;
        }
    }
}
