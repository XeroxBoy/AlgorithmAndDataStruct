package LeetCode.Easy.List;

import dataStructure.ListNode;

import java.util.Stack;

public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> list_stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            list_stack.push(node.val);
            node = node.next;
        }
        int[] header = new int[list_stack.size()];
        for (int i = 0; i < header.length; i++) {
            header[i] = list_stack.pop();
        }
        return header;
    }

    public int[] betterReversePrint(ListNode head) {
        //先获取链表长度，创建对应长度数组
        ListNode currNode = head;
        int len = 0;
        while (currNode != null) {
            len++;
            currNode = currNode.next;
        }
        int[] result = new int[len];

        //再次遍历链表，将值倒序填充至结果数组
        currNode = head;
        while (currNode != null) {
            result[len - 1] = currNode.val;
            len--;
            currNode = currNode.next;
        }
        return result;
    }
}
