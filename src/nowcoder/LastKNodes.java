package nowcoder;

import java.util.List;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class LastKNodes {
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) return null;
        if (k <= 0) return null;
        ListNode leader = head;
        for (int i = 0; i < k - 1; i++) {
            leader = leader.next;
        }
        if (leader == null) return null;
        while (leader.next != null) {
            head = head.next;
            leader = leader.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode listNode = FindKthToTail(node1, 1);
        System.out.println(listNode.val);
    }
}
