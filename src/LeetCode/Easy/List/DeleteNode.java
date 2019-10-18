package LeetCode.Easy.List;

import dataStructure.ListNode;

public class DeleteNode {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        ListNode newNextNode = nextNode.next;
        node.next = newNextNode;
        node.val = nextNode.val;
    }
}
