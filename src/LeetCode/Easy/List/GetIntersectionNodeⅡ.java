package LeetCode.Easy.List;

import dataStructure.ListNode;

public class GetIntersectionNodeⅡ {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a_len = 0;
        int b_len = 0;
        ListNode len_a_pt = headA;
        ListNode len_b_pt = headB;
        while (len_a_pt != null) {
            a_len++;
            len_a_pt = len_a_pt.next;
        }
        while (len_b_pt != null) {
            b_len++;
            len_b_pt = len_b_pt.next;
        }
        int distance = Math.max(a_len, b_len) - Math.min(a_len, b_len);
        if (a_len > b_len) {
            while (distance-- != 0) {
                headA = headA.next;
            }
        } else if (b_len > a_len) {
            while (distance-- != 0) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

}
