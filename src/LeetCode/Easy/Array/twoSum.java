package LeetCode.Easy.Array;

public class twoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] twoSum = new int[2];
        if (numbers.length < 2) return twoSum;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] > target) break;
                if (numbers[i] + numbers[j] == target) {
                    twoSum[0] = i + 1;
                    twoSum[1] = j + 1;
                    return twoSum;
                }
            }
        }
        return twoSum;
    }

    public int[] greatTwoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            if (numbers[low] + numbers[high] > target) {
                high--;
            } else if (numbers[low] + numbers[high] < target) {
                low++;
            } else {
                res[0] = low + 1;
                res[1] = high + 1;
                break;
            }
        }
        return res;
    }
}
