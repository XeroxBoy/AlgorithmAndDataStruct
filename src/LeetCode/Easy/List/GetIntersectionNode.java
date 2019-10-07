package LeetCode.Easy.List;

import dataStructure.ListNode;

public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(6);
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(5);
        ListNode h3 = new ListNode(4);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        h1.next = h2;
//        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = h3;
        System.out.println(new GetIntersectionNode().getIntersectionNode(h1, h2).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode detectA = headA;
        ListNode detectB = headB;
        if (headA == null || headB == null) return null;
        while (detectA != null) {
            while (detectB != null) {
                if (detectA.equals(detectB)) return detectB;
                detectB = detectB.next;
            }
            detectB = headB;
            detectA = detectA.next;
        }
        if (headA.next == null) {
            while (detectB != null) {
                if (detectB.equals(headA)) return headA;
                detectB = detectB.next;
            }
        }
        return null;
    }

    public ListNode greatGetIntersectionNode(ListNode headA, ListNode headB) {
        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
