package LeetCode.Easy.Stack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class MinStack {
    private static ArrayList<Integer> list = new ArrayList<Integer>();
    private static Stack<Integer> stack = new Stack<Integer>();

    public MinStack() {
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
//        minStack.push(2);
//        minStack.push(3);
        minStack.push(-1);
        System.out.println(minStack.top());
//        minStack.push(4);
        System.out.println(minStack.getMin());

    }

    public void push(int x) {
        stack.push(x);
        list.add(x);
        sortList();
    }

    private void sortList() {
        list.sort(Comparator.comparingInt(o -> o));
    }

    public void pop() {
        int x = stack.peek();

        if (!list.contains(x)) return;
        stack.pop();
        list.remove(new Integer(x));
        sortList();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return list.get(0);
    }
}
