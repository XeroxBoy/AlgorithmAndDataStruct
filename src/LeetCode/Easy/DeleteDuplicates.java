package LeetCode.Easy;

import dataStructure.ListNode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head){
        ListNode originHead = head;
        while(head!= null){
            ListNode nextPtr = head.next;
            while(nextPtr != null && nextPtr.val == head.val){
                nextPtr = nextPtr.next;
            }
            head.next = nextPtr;
            head = head.next;
        }
        return originHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode newHead = new DeleteDuplicates().deleteDuplicates(l1);
        while(newHead!=null){
            System.out.print(newHead.val+" ");
            newHead = newHead.next;
        }
    }
}

