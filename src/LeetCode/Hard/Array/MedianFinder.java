package LeetCode.Hard.Array;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> max_queue;
    PriorityQueue<Integer> min_queue;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        max_queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        min_queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(-1);
        finder.addNum(-2);
        System.out.println(finder.findMedian());
        finder.addNum(-3);
        System.out.println(finder.findMedian());
        finder.addNum(-4);
        System.out.println(finder.findMedian());
        finder.addNum(-5);
        System.out.println(finder.findMedian());

    }

    public void addNum(int num) {
        if (max_queue.size() != min_queue.size()) {
            max_queue.add(num);
            min_queue.add(max_queue.poll());

        } else {
            min_queue.add(num);
            max_queue.add(min_queue.poll());
        }
    }

    public double findMedian() {
        return max_queue.size() == min_queue.size() ? (max_queue.peek() + min_queue.peek()) / 2.0 : max_queue.peek();
    }
}
