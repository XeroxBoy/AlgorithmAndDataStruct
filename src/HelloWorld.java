import java.util.Stack;
public class HelloWorld {
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

}
