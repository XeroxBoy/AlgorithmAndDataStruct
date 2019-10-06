package LeetCode.Easy.List;

import dataStructure.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HasCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node0 = new ListNode(2);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(-4);
//        head.next= node0;
//        node0.next = node1;
//        node0.next = head;
//        node1.next = node2;
//        node2.next = node0;
        System.out.println(new HasCycle().hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        int pos = -1;
        int pointPos = 0;
        Set<ListNode> nodeSet = new HashSet<>();
        if (head == null) return false;
        nodeSet.add(head);
        while (head.next != null) {
            if (nodeSet.contains(head.next)) return true;
            nodeSet.add(head);
            head = head.next;
            pointPos++;
        }
        pos = pointPos;
        return false;
    }

    public boolean greatHasCycle(ListNode head) {
        if (head == null) return false;
        while (head.next != null && head.val != Integer.MIN_VALUE) {
            head.val = Integer.MIN_VALUE;
            head = head.next;
        }
        return head.next != null;
    }
}
