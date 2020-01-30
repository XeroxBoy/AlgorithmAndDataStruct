package LeetCode.Easy.Tree;

import dataStructure.TreeNode;

public class DiameterOfBinaryTree {
    private int result = 0;

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        head.left = node1;
        head.right = node2;
        node1.left = node3;
        node1.right = node4;
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(head));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return result;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = root.left == null ? 0 : depth(root.left) + 1;
        int right = root.right == null ? 0 : depth(root.right) + 1;
        result = Math.max(left + right, result);
        return Math.max(left, right);
    }
}
