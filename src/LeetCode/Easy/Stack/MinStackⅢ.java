package LeetCode.Easy.Stack;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStackⅢ {
    Stack<Integer> stack1;
    PriorityQueue<Integer> queue;

    /**
     * initialize your data structure here.
     */
    public MinStackⅢ() {
        stack1 = new Stack<>();
        queue = new PriorityQueue<>((o1, o2) -> (o1 > o2) ? 1 : -1);
    }

    public void push(int x) {
        stack1.push(x);
        queue.offer(x);
    }

    public void pop() {
        int val = stack1.pop();
        queue.remove(val);
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        if (queue.size() == 0) return -1;
        return queue.peek();
    }

    class MinStack {
        Stack<Integer> A, B;

        public MinStack() {
            A = new Stack<>();
            B = new Stack<>();
        }

        public void push(int x) {
            A.add(x);
            if (B.empty() || B.peek() >= x)
                B.add(x);
        }

        public void pop() {
            if (A.pop().equals(B.peek()))
                B.pop();
        }

        public int top() {
            return A.peek();
        }

        public int min() {
            return B.peek();
        }
    }
}