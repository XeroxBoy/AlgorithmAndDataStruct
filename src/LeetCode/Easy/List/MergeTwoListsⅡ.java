package LeetCode.Easy.List;

import dataStructure.ListNode;

public class MergeTwoListsⅡ {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        ListNode head = new MergeTwoListsⅡ().mergeTwoLists(l1, l4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1_iter = l1;
        ListNode l2_iter = l2;
        ListNode new_head = new ListNode(-1);
        ListNode head = new_head;
        while (l1_iter != null && l2_iter != null) {
            int val = Math.min(l1_iter.val, l2_iter.val);
            new_head.next = new ListNode(val);
            new_head = new_head.next;
            if (l1_iter.val > l2_iter.val) l2_iter = l2_iter.next;
            else l1_iter = l1_iter.next;
        }
        new_head.next = l1_iter != null ? l1_iter : l2_iter;
        return head.next;
    }
}
