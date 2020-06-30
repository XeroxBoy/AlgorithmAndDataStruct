package LeetCode.Medium.List;

import dataStructure.ListNode;

public class RemoveNthFromeEnd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode header = new RemoveNthFromeEnd().removeNthFromEnd(l1, 2);
        while (header != null) {
            System.out.println(header.val);
            header = header.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode forwardPointer = head;
        ListNode backwardPoint = head;
        ListNode backwardBeforePoint = null;
        for (int i = 0; i < n; i++) {
            forwardPointer = forwardPointer.next;
        }
        while (forwardPointer != null) {
            forwardPointer = forwardPointer.next;
            backwardBeforePoint = backwardPoint;
            backwardPoint = backwardPoint.next;
        }
        if (backwardBeforePoint == null) {
            assert backwardPoint != null;
            head = backwardPoint.next;
        } else {
            backwardBeforePoint.next = backwardPoint.next;
            backwardPoint.next = null;
        }
        return head;
    }
}
