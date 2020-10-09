package LeetCode.Easy.List;

import dataStructure.ListNode;

public class HasCycleⅡ {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean hasCycle = false;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                if (slow.next != null) {
                    slow = slow.next;
                    if (fast == slow) {
                        hasCycle = true;
                        break;
                    }
                }
            }
        }
        return hasCycle;
    }
}
