package LeetCode.Medium.Queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxQueue {
    PriorityQueue<Integer> max_queue;
    Queue<Integer> queue;

    public MaxQueue() {
        max_queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        queue = new LinkedList<>();
    }

    public int max_value() {
        if (queue.size() == 0) return -1;
        return max_queue.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        max_queue.offer(value);
    }

    public int pop_front() {
        if (queue.size() == 0) return -1;
        Integer poll_val = queue.poll();
        max_queue.remove(poll_val);
        return poll_val;
    }

    public class better_MaxQueue {

        Queue<Integer> queue;
        LinkedList<Integer> max;

        public better_MaxQueue() {
            queue = new LinkedList<>();
            max = new LinkedList<>();//LinkedList是双端链表
        }

        public int max_value() {
            return max.size() == 0 ? -1 : max.getFirst();
        }

        public void push_back(int value) {
            queue.add(value);
            while (max.size() != 0 && max.getLast() < value) {//注意：这里第二个判断条件不能带等号，即max中对于当前queue中的具有相同值的元素会全部存储，而不是存储最近的那个。
                max.removeLast();
            }
            max.add(value);
        }

        public int pop_front() {
            if (max.size() != 0)//Integer类型的值的比较不能直接使用==
            {
                assert queue.peek() != null;
                if (queue.peek().equals(max.getFirst())) max.removeFirst();
            }
            return queue.size() == 0 ? -1 : queue.poll();
        }

        /**
         * Your MaxQueue object will be instantiated and called as such:
         * MaxQueue obj = new MaxQueue();
         * int param_1 = obj.max_value();
         * obj.push_back(value);
         * int param_3 = obj.pop_front();
         */
    }

}
