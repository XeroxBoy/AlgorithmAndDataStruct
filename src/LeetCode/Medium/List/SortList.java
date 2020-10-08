package LeetCode.Medium.List;

import dataStructure.ListNode;

import java.util.List;


public class SortList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        SortList sortList = new SortList();
        sortList.sortList(n1);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }

    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }

    private void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode node = partion(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    private ListNode partion(ListNode head, ListNode end) {
        ListNode p1 = head, p2 = head.next;
        while (p2 != end) {
            if (p2.val < head.val) {
                p1 = p1.next;
                int temp = p2.val;
                p2.val = p1.val;
                p1.val = temp;
            }
            p2 = p2.next;
        }
        if (p1 != head) {
            int temp = p1.val;
            p1.val = head.val;
            head.val = temp;
        }
        return p1;
    }

    class Solution {
        public ListNode sortList(ListNode head) {
            //采用归并排序
            if (head == null || head.next == null) {
                return head;
            }
            //获取中间结点
            ListNode mid = getMid(head);
            ListNode right = mid.next;
            mid.next = null;
            //合并
            return mergeSort(sortList(head), sortList(right));
        }

        /**
         * 获取链表的中间结点,偶数时取中间第一个
         *
         * @param head
         * @return
         */
        private ListNode getMid(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            //快慢指针
            ListNode slow = head, quick = head;
            //快2步，慢一步
            while (quick.next != null && quick.next.next != null) {
                slow = slow.next;
                quick = quick.next.next;
            }
            return slow;
        }

        /**
         * 归并两个有序的链表
         *
         * @param head1
         * @param head2
         * @return
         */
        private ListNode mergeSort(ListNode head1, ListNode head2) {
            ListNode p1 = head1, p2 = head2, head;
            //得到头节点的指向
            if (head1.val < head2.val) {
                head = head1;
                p1 = p1.next;
            } else {
                head = head2;
                p2 = p2.next;
            }

            ListNode p = head;
            //比较链表中的值
            while (p1 != null && p2 != null) {

                if (p1.val <= p2.val) {
                    p.next = p1;
                    p1 = p1.next;
                    p = p.next;
                } else {
                    p.next = p2;
                    p2 = p2.next;
                    p = p.next;
                }
            }
            //第二条链表空了
            if (p1 != null) {
                p.next = p1;
            }
            //第一条链表空了
            if (p2 != null) {
                p.next = p2;
            }
            return head;
        }
    }
}
