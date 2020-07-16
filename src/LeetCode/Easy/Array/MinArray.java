package LeetCode.Easy.Array;

public class MinArray {
    public int minArray(int[] numbers) {
        int min = numbers[0];
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] < numbers[i - 1]) {
                min = numbers[i];
                break;
            }
        }
        return min;
    }
}
