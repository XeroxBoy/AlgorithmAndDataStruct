package LeetCode.Easy.List;

import dataStructure.ListNode;

import java.util.Stack;

public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        ListNode newHead = new ReverseList().reverseList(head);
        while (newHead != null) {
//            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode newHead = stack.pop();
        ListNode node = newHead;
        System.out.println(node.val);
        while (!stack.isEmpty()) {
            ListNode nextNode = stack.pop();
            node.next = nextNode;
            node = nextNode;
        }
        return newHead;
    }
}
