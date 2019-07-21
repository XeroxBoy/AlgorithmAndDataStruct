package dataStructure;

public class avl {
    static class Node{
        Node left;
        Node right;
        int height;
        int data;
    }

    Node tree;

    int height(Node node){return node.height;}

    public static Node rightR(Node a){
        Node b=a.left;
        a.left=b.right;
        b.right=a;
        a.height=a.left.height>a.right.height?a.left.height:a.right.height;
        b.height=b.left.height>b.right.height?b.left.height:b.right.height;
        return b;
    }

    public static Node leftR(Node a){
        Node b=a.right;
        a.right=b.left;
        b.left=a;
        a.height=a.left.height>a.right.height?a.left.height:a.right.height;
        b.height=b.left.height>b.right.height?b.left.height:b.right.height;
        return b;
    }

    public static Node leftRightR(Node a){
        a.left=leftR(a.left);
        return rightR(a);
    }

    public static Node rightLeftR(Node a){
        a.right=rightR(a.right);
        return leftR(a);
    }
}

