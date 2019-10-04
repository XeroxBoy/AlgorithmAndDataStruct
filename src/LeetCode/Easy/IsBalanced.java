package LeetCode.Easy;

import dataStructure.TreeNode;

public class IsBalanced {
    public static void main(String[] args) {
        TreeNode root0 = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);
        TreeNode head0 = new TreeNode(1);
        TreeNode head1 = new TreeNode(2);
        TreeNode head2 = new TreeNode(2);
        TreeNode head3 = new TreeNode(3);
        TreeNode head4 = new TreeNode(3);
        TreeNode head5 = new TreeNode(4);
        TreeNode head6 = new TreeNode(4);
        head0.left = head1;
        head0.right = head2;
        head1.left = head3;
        head1.right = head4;
        head3.left = head5;
        head3.right = head6;
        root0.left = root1;
        root0.right = root2;
        root2.left = root3;
        root2.right = root4;
        System.out.println(new IsBalanced().isBalanced(head0));

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        if (left == -1 || right == -1) return false;
        else return Math.abs(left - right) <= 1;
    }

    private int treeHeight(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = treeHeight(node.left);
        int rightHeight = treeHeight(node.right);
        if (leftHeight == -1 || rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }
}
