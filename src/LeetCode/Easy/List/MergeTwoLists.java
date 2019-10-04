package LeetCode.Easy.List;

import dataStructure.ListNode;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(3);
        ListNode r3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        r1.next = r2;
        r2.next = r3;
        ListNode l4 = null;
        ListNode r4 = new ListNode(1);
        ListNode head = new MergeTwoLists().mergeTwoLists(l4, r4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return l1;
        else if (l1 == null) return l2;
        else if (l2 == null) return l1;
        int firstVal = -1;
        if (l1.val > l2.val) {
            firstVal = l2.val;
            l2 = l2.next;
        } else {
            firstVal = l1.val;
            l1 = l1.next;
        }
        ListNode head = new ListNode(firstVal);
        ListNode originhead = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                originhead.next = new ListNode(l2.val);
                originhead = originhead.next;
                l2 = l2.next;
            } else {
                originhead.next = new ListNode(l1.val);
                originhead = originhead.next;
                l1 = l1.next;
            }
        }
        while (l1 != null) {
            originhead.next = l1;
            originhead = originhead.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            originhead.next = l2;
            originhead = originhead.next;
            l2 = l2.next;
        }
        return head;
    }
}
