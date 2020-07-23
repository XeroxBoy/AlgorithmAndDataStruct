package LeetCode.Easy.Array;

import LeetCode.Medium.List.MinimumTotal;

public class MinArrayⅡ {
    public static void main(String[] args) {
        System.out.println(new MinArrayⅡ().minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new MinArrayⅡ().minArray(new int[]{2, 2, 2, 0, 1}));
        System.out.println(new MinArrayⅡ().minArray(new int[]{1, 1}));
        System.out.println(new MinArrayⅡ().minArray(new int[]{3, 1, 1}));
    }

    public int minArray(int[] numbers) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (numbers[mid] > numbers[end]) {
                start = mid + 1;
            } else if (numbers[end] > numbers[mid]) {
                end = mid;
            } else {
                end -= 1;
            }
        }
        return numbers[start];
    }
}
