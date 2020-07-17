package LeetCode.Easy.Array;

public class PrintNumbers {
    public int[] printNumbers(int n) {
        int target = (int) Math.pow(10, n);
        int[] results = new int[target - 1];
        for (int i = 1; i < target; i++) {
            results[i - 1] = i;
        }
        return results;
    }
}
