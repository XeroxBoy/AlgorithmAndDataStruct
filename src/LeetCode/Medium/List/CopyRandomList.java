package LeetCode.Medium.List;

import dataStructure.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class CopyRandomList {
    public static void main(String[] args) {
        Node h1 = new Node(7);
        Node h2 = new Node(13);
        Node h3 = new Node(11);
        Node h4 = new Node(10);
        Node h5 = new Node(1);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h2.random = h1;
        h3.random = h5;
        h4.random = h3;
        h5.random = h1;
        Node head = new CopyRandomList().copyRandomList(h1);
        while (head != null) {
            System.out.println(head.val);
            if (head.random == null) head = head.next;
            else head = head.random;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}
