public class tree {
    public static void main(String[] args){
        Node root=new Node();
        Node left1=new Node();
        Node leftright1=new Node();
        Node leftleft1=new Node();
        Node right1=new Node();
        Node rightleft1=new Node();
        Node rightright1=new Node();
        root.setVal(1);
        left1.setVal(2);
        right1.setVal(3);
        leftleft1.setVal(4);
        leftright1.setVal(5);
        rightleft1.setVal(6);
        rightright1.setVal(7);
        root.setLeft(left1);
        root.setRight(right1);
        left1.setLeft(leftleft1);
        left1.setRight(leftright1);
        right1.setLeft(rightleft1);
        right1.setRight(rightright1);
        preIter(root);
        System.out.println();
        midIter(root);
        System.out.println();
        backIter(root);
    }
    static class Node{
        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        private int val;
        private Node left;
        private Node right;
    }
    private Node root;

    public tree(Node root) {
        this.root = root;
    }
    public static void preIter(Node root){
        if(root==null) return;
        System.out.print(root.getVal()+" ");
        preIter(root.getLeft());
        preIter(root.getRight());
    }
    public static void midIter(Node root){
        if(root==null) return;
        midIter((root.getLeft()));
        System.out.print(root.getVal()+" ");
        midIter(root.getRight());
    }
    public static void backIter(Node root){
        if(root==null) return;
        backIter(root.getLeft());
        backIter(root.getRight());
        System.out.print(root.getVal()+" ");
    }
}

