import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {
            if (map.containsKey(key)) {
                int value = map.get(key);
                value++;
                map.replace(key, value);
            } else {
                map.put(key, 1);
            }
        }
        int maxFrequent;
        for (int key : )
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}

