package LeetCode.Easy.List;

import dataStructure.ListNode;

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val == val){
            head = head.next;
        }
        if(head == null) return null;
        ListNode newHead = head;
        ListNode prev = null;
        while(head!=null){
            if(head.val == val) {
                while (head.val == val) {
                    head = head.next;
                    if(head == null) break;
                }
                prev.next = head;
            }
            else {
                prev = head;
                head = head.next;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(6);
        ListNode h4 = new ListNode(3);
        ListNode h5 = new ListNode(4);
        ListNode h6 = new ListNode(5);
        ListNode h7 = new ListNode(6);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        h6.next = h7;
        ListNode head = new RemoveElements().removeElements(h1,6);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}

