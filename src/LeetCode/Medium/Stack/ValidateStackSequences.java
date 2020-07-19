package LeetCode.Medium.Stack;

import java.util.LinkedList;
import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int push = 0;
        int pop = 0;
        while (push < pushed.length) {
            stack.push(pushed[push++]);
            while (!stack.isEmpty() && stack.peek() == popped[pop]) {
                stack.pop();
                pop++;
            }
        }
        return stack.isEmpty();
    }
}
