package LeetCode.Easy.Array;

import java.util.HashMap;

public class TwoSumⅡ {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] indices = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(target - numbers[i], i);
            } else {
                Integer otherIndex = map.get(numbers[i]);
                indices[0] = (otherIndex >= i ? i : otherIndex) + 1;
                indices[1] = (otherIndex >= i ? otherIndex : i) + 1;
                break;
            }
        }
        return indices;
    }

    public int[] twoSumⅡ(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low <= high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{low, low};
    }
}
