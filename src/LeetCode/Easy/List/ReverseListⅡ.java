package LeetCode.Easy.List;

import dataStructure.ListNode;

public class ReverseListⅡ {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode reverseHead = new ReverseListⅡ().reverseList(listNode);
        while (reverseHead != null) {
            System.out.println(reverseHead.val);
            reverseHead = reverseHead.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode forward = head;
        while (forward != null) {
            ListNode temp = forward.next;
            forward.next = prev;
            prev = forward;
            forward = temp;
        }
        return prev;
    }
}
