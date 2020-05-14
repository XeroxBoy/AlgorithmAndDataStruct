package LeetCode.Medium.List;

import dataStructure.ListNode;

public class DetectCycle {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
//        h1.next = h2;
//        h2.next = h1;
        System.out.println(new DetectCycle().detectCycle(l1).val);
        System.out.println(new DetectCycle().detectCycle(h1).val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        //判断是否有环
        ListNode fast = head;
        ListNode slow = head;
        boolean hasCycle = false;
        while (!hasCycle) {
            fast = fast.next;
            if (fast == null) return null;
            fast = fast.next;
            slow = slow.next;
            if (slow == null || fast == null) return null;
            if (slow == fast) hasCycle = true;
        }
        //判断相遇
        ListNode q = head;
        while (true) {
            if (q == slow) return slow;
            q = q.next;
            slow = slow.next;
        }
    }

}