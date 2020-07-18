package LeetCode.Easy.List;

import dataStructure.ListNode;

public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode forward = head;
        for (int i = 0; i < k; i++) {
            forward = forward.next;
        }
        ListNode behind = head;
        while (forward != null) {
            forward = forward.next;
            behind = behind.next;
        }
        return behind;
    }
}
