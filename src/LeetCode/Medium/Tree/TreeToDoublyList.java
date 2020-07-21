package LeetCode.Medium.Tree;

import java.util.LinkedList;

public class TreeToDoublyList {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        traverseTree(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void traverseTree(Node current) {
        if (current == null) return;
        traverseTree(current.left);
        if (pre != null) pre.right = current;
        else head = current;
        current.left = pre;
        pre = current;
        traverseTree(current.right);
    }


    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;
}
