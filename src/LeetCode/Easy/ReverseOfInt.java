package LeetCode.Easy;

import java.util.Stack;

public class ReverseOfInt {
    public static void main(String[] args) {
        System.out.println(new ReverseOfInt().reverse(1234567899));
    }

    public int reverse(int x) {
        boolean negative = false;
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) return 0;
        if (x < 0) {
            negative = true;
            x *= -1;
        }
        int yushu;
        Stack<Integer> numStack = new Stack<>();

        while (x != 0) {
            yushu = x % 10;
            x /= 10;
            numStack.push(yushu);
        }
        long result = 0;
        long times = 1;
        while (!numStack.isEmpty()) {
            result += numStack.pop() * times;
            if (result > Integer.MAX_VALUE) return 0;
            times *= 10;
        }
        if (negative) {
            result *= -1;
        }
        int trueResult = (int) result;
        return trueResult;
    }
}
