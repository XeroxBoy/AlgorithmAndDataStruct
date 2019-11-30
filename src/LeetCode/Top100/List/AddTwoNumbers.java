package LeetCode.Top100.List;

import dataStructure.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode node;
        int num = l1.val + l2.val + carry;
        if (num >= 10) {
            carry = 1;
            num = num % 10;
        }
        node = new ListNode(num);
        ListNode firstNode = node;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            num = l1.val + l2.val + carry;
            if (num >= 10) {
                carry = 1;
                num = num % 10;
            } else carry = 0;
            ListNode next = new ListNode(num);
            node.next = next;
            node = next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            num = l1.val + carry;
            if (num >= 10) {
                carry = 1;
                num = num % 10;
            } else carry = 0;
            ListNode next = new ListNode(num);
            node.next = next;
            node = next;
            l1 = l1.next;
        }
        while (l2 != null) {
            num = l2.val + carry;
            if (num >= 10) {
                carry = 1;
                num = num % 10;
            } else carry = 0;
            ListNode next = new ListNode(num);
            node.next = next;
            node = next;
            l2 = l2.next;
        }
        if (carry == 1) node.next = new ListNode(1);
        return firstNode;
    }
}
