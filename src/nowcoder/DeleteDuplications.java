package nowcoder;

public class DeleteDuplications {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int value) {
            val = value;
        }
    }
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null) return pHead;
        boolean loop = false;
        ListNode head = pHead;
        while(head.val==head.next.val) //一开始就是连续相同的情况
        {
            loop = true;
            head = head.next;
            if(head.next == null) break;
            if(head.next.next != null){
                if(head.next.val == head.next.next.val)
                {head=head.next;continue;}
            }
        }
        if(loop) {
            pHead = head.next;
        }
        while(head.next != null){
            int nextNextVal;
            if(head.next.next != null) nextNextVal = head.next.next.val;
            else break;
            if(head.next.val == nextNextVal){
                ListNode detectHead = head.next;
                while(detectHead.val == detectHead.next.val){
                    detectHead=detectHead.next;
                    if(detectHead.next == null) {detectHead=detectHead.next;break;}
                }
                if (detectHead==null) head.next=null;
                if(detectHead!=null) {
                    head.next=detectHead.next;
                }
            }
            else
                head = head.next;
        }
        return pHead;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(3);
        ListNode p5 = new ListNode(4);
        ListNode p6 = new ListNode(4);
        ListNode p7 = new ListNode(5);
        ListNode p8 = new ListNode(6);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        p7.next = p8;
        DeleteDuplications dD = new DeleteDuplications();
        ListNode pHead = dD.deleteDuplication(p1);
        while(pHead!=null){
            System.out.println(pHead.val);
            pHead = pHead.next;
        }
    }
}