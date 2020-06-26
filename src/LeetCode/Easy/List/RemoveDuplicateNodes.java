package LeetCode.Easy.List;

import dataStructure.ListNode;

import java.util.List;

public class RemoveDuplicateNodes {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode head = new RemoveDuplicateNodes().removeDuplicateNodes(l1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
//        System.out.println(new RemoveDuplicateNodes().removeDuplicateNodes());
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        int[] nodes = new int[20000];
        ListNode tempHead = head;
        ListNode beforeHead;
        nodes[tempHead.val]++;
        beforeHead = tempHead;
        while (tempHead != null) {
            while (tempHead != null && nodes[tempHead.val] != 0) tempHead = tempHead.next;
            if (tempHead == null) {
                beforeHead.next = null;
                break;
            } else {
                nodes[tempHead.val]++;
                beforeHead.next = tempHead;
                beforeHead = tempHead;
                tempHead = tempHead.next;
            }
        }
        return head;
    }
}
