package company.huawei;

import dataStructure.ListNode;

import java.util.PriorityQueue;

public class ListMedium {
    /**
     * 题目描述：四个数字链表，求四个链表的中位数。如果数字个数是奇数n，中位数是中间下标为n/2+1的数
     * ；如果是偶数个，中位数是中间两个下标为n/2和n/2+1数之和的平均数
     * 备注：
     * 1. 不能采用链表合并再全排列算法；
     */
    public static double mediumOfFourLists(ListNode node1, ListNode node2, ListNode node3, ListNode node4) {
        int allLen = getListLen(node1) + getListLen(node2) + getListLen(node3) + getListLen(node4);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        addNumbersToQueue(node1, allLen / 2 + 1, priorityQueue);
        addNumbersToQueue(node2, allLen / 2 + 1, priorityQueue);
        addNumbersToQueue(node3, allLen / 2 + 1, priorityQueue);
        addNumbersToQueue(node4, allLen / 2 + 1, priorityQueue);
        if (allLen % 2 == 0) {
            int number1 = priorityQueue.poll();
            int number2 = priorityQueue.poll();
            return (number1 + number2) * 1.0 / 2;
        } else {
            return priorityQueue.poll();
        }
    }

    private static void addNumbersToQueue(ListNode node1, int capacity, PriorityQueue<Integer> priorityQueue) {
        while (node1 != null) {
            if (priorityQueue.size() > capacity) {
                if (node1.val > priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.add(node1.val);
                }
            } else {
                priorityQueue.add(node1.val);
            }
            node1 = node1.next;
        }
    }

    private static int getListLen(ListNode node) {
        int length = 0;
        while (node != null) {
            length += 1;
            node = node.next;
        }
        return length;
    }


}
