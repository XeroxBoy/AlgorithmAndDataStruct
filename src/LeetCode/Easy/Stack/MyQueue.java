package LeetCode.Easy.Stack;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());


    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        Stack<Integer> stack3 = new Stack<>();
        stack2.push(x);
        while (!stack1.isEmpty()) stack3.push(stack1.pop());
        stack3.push(stack2.pop());
        while (!stack3.isEmpty()) stack1.push(stack3.pop());
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!stack1.isEmpty()) return stack1.pop();
        return -1;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack1.isEmpty()) return stack1.peek();
        return -1;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
