package LeetCode.Easy.Stack;

import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int yushu;
        Stack<Integer> numStack = new Stack<>();
        int originValue = x;
        while (x != 0) {
            yushu = x % 10;
            x /= 10;
            numStack.push(yushu);
        }
        long result = 0;
        long times = 1;
        while (!numStack.isEmpty()) {
            result += numStack.pop() * times;
            times *= 10;
        }
        return result == originValue;
    }
}
