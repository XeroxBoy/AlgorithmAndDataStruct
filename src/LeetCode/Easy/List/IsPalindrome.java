package LeetCode.Easy.List;

import dataStructure.ListNode;

import java.util.ArrayList;

public class IsPalindrome {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(new IsPalindrome().isPalindrome(null));
    }

    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> preList = new ArrayList<>();
        ArrayList<Integer> backList = new ArrayList<>();
        while (head != null) {
            preList.add(head.val);
            head = head.next;
        }
        for (int i = preList.size() - 1; i >= 0; i--) {
            backList.add(preList.get(i));
        }
        for (int i = 0; i < preList.size(); i++) {
            if (!backList.get(i).equals(preList.get(i))) return false;
        }
        return true;
    }

    public boolean greatIsPalindrome(ListNode head) {
        // 要实现 O(n) 的时间复杂度和 O(1) 的空间复杂度，需要翻转后半部分
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 根据快慢指针，找到链表的中点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow.next);
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        // 递归到最后一个节点，返回新的新的头结点
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
