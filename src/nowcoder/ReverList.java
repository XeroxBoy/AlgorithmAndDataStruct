package nowcoder;

import java.util.Stack;

public class ReverList {
    public static class ListNode {
        int val;
        ListNode next = null;
    }

    public static void main(String []args) {
        ListNode head=new ListNode();
        head.val=1;
        ListNode next1=new ListNode();
        next1.val=2;
        head.next=next1;
        ListNode next2=new ListNode();
        next2.val=3;
        next1.next=next2;
        ListNode result=ReverseList(head);
        while(result!=null){
            System.out.print(result.val + " ");
            result=result.next;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        Stack<ListNode> stack=new Stack();
        if(head==null) return null;
        while(head!=null){
            stack.push(head);
            head=head.next;
        }
        ListNode newHead,resultHead;
        newHead=stack.pop();
        System.out.print(newHead.val+" ");
        resultHead=newHead;
        System.out.print(newHead.val+" ");
        while(!stack.isEmpty()){
            newHead.next=stack.pop();
            newHead=newHead.next;
            //     System.out.print(newHead.val+" ");
        }
        //newHead.next=null;
        return null;
        // return resultHead;
    }
    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null; //前指针节点
        ListNode curr = head; //当前指针节点
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (curr != null) {
            ListNode nextTemp = curr.next; //临时节点，暂存当前节点的下一节点，用于后移
            curr.next = prev; //将当前节点指向它前面的节点
            prev = curr; //前指针后移
            curr = nextTemp; //当前指针后移
        }
        return prev;
    }
}
