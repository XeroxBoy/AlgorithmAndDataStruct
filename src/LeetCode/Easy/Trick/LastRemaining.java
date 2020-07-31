package LeetCode.Easy.Trick;

import exception.A;

import java.util.ArrayList;

public class LastRemaining {
    public static void main(String[] args) {
        System.out.println(new LastRemaining().lastRemaining(5, 3));
        System.out.println(new LastRemaining().lastRemaining(10, 17));
        System.out.println(new LastRemaining().lastRemaining(56795, 87778));
    }

    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        int circle = n;
        while (list.size() > 1) {
            index = (index + m - 1) % circle;
            circle -= 1;
            list.remove(index);
        }
        return list.get(0);
    }

    class Solution {
        public int lastRemaining(int n, int m) {
            int ans = 0;
            // 最后一轮剩下2个人，所以从2开始反推
            for (int i = 2; i <= n; i++) {
                ans = (ans + m) % i;
            }
            return ans;
        }
    }
}
