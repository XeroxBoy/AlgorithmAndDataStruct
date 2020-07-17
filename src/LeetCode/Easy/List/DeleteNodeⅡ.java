package LeetCode.Easy.List;

import dataStructure.ListNode;

public class DeleteNodeⅡ {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = null;
        ListNode forward = head;
        while (forward.val != val) {
            pre = forward;
            forward = forward.next;
        }
        if (pre != null) {
            pre.next = forward.next;
        } else {
            return head.next;
        }
        return head;
    }
}
