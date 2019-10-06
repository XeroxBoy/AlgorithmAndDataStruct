package LeetCode.Easy.Stack;

import java.util.Stack;

public class MinStackⅡ {
    private Stack<Integer> stack;
    /** initialize your data structure here. */
    /**
     * initialize your data structure here.
     */
    public MinStackⅡ() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            stack.push(x);
        } else {
            int tmp = stack.peek();
            stack.push(x);
            if (tmp < x) {
                stack.push(tmp);
            } else {
                stack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.get(stack.size() - 2);
    }

    public int getMin() {
        return stack.peek();
    }
}
