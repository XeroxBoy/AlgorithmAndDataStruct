package LeetCode.Easy.Array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        Arrays.stream(new MaxSlidingWindow().maxSlidingWindow(new int[]{1}, 1)).forEach(System.out::println);
        Arrays.stream(new MaxSlidingWindow().maxSlidingWindow(new int[]{1, 2}, 1)).forEach(System.out::println);
        Arrays.stream(new MaxSlidingWindow().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)).forEach(System.out::println);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int n = nums.length;
        int[] results = new int[n - k + 1];

        for (int i = 0; i < n - k + 1; i++) {
            int max_in_window = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                max_in_window = Math.max(max_in_window, nums[i + j]);
            }
            results[i] = max_in_window;
        }
        return results;
    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0 || k == 0) return new int[0];
            Deque<Integer> deque;
            deque = new LinkedList<>();
            int[] res = new int[nums.length - k + 1];
            for (int j = 0, i = 1 - k; j < nums.length; i++, j++) {
                if (i > 0 && deque.peekFirst() == nums[i - 1])
                    deque.removeFirst(); // 删除 deque 中对应的 nums[i-1]
                while (!deque.isEmpty() && deque.peekLast() < nums[j])
                    deque.removeLast(); // 保持 deque 递减
                deque.addLast(nums[j]);
                if (i >= 0)
                    res[i] = deque.peekFirst();  // 记录窗口最大值
            }
            return res;
        }
    }
}
