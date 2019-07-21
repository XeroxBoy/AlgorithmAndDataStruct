package nowcoder;

import java.util.HashSet;
import java.util.Set;

public class EntryNodeOfLoop {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        Set<ListNode> CharSet = new HashSet<>();
        boolean find = true;
        ListNode searcher = new ListNode(pHead.val);
        searcher.next = pHead.next;
        CharSet.add(pHead);

        searcher = searcher.next;
        while (!CharSet.contains(searcher)) {
            CharSet.add(searcher);
            if (searcher == null) {
                find = false;
                break;
            }
            searcher = searcher.next;
        }
        if (find) return searcher;
        return null;
    }

    public static void main(String[] args) {
        EntryNodeOfLoop enl = new EntryNodeOfLoop();
        ListNode phead = new ListNode(1);
        ListNode pNode1 = new ListNode(2);
        ListNode pNode2 = new ListNode(3);
        ListNode pNode3 = new ListNode(4);
        ListNode pNode4 = new ListNode(5);

        phead.next = pNode1;
        pNode1.next = pNode2;
        pNode2.next = pNode3;
        pNode3.next = pNode4;
        pNode4.next = phead;
        System.out.println(enl.EntryNodeOfLoop(phead).val);
    }
}

