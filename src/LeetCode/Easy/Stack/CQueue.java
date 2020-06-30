package LeetCode.Easy.Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class CQueue {
    private LinkedList<Integer> stack_01 = new LinkedList<>();
    private LinkedList<Integer> stack_02 = new LinkedList<>();

    public CQueue() {

    }

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        queue.appendTail(5);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());

    }

    public void appendTail(int value) {
        stack_01.push(value);
    }

    public int deleteHead() {
        while (!stack_01.isEmpty()) {
            stack_02.push(stack_01.pop());
        }
        if (stack_02.isEmpty()) return -1;
        int head_value = stack_02.pop();
        while (!stack_02.isEmpty()) {
            stack_01.push(stack_02.pop());
        }
        return head_value;
    }
}
