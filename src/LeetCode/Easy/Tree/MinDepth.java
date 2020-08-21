package LeetCode.Easy.Tree;

import dataStructure.TreeNode;

public class MinDepth {
    private static int minDepth = Integer.MAX_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;
        System.out.println(new MinDepth().minDepth(root));
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        minDepth = Integer.MAX_VALUE;
        minHeight(root, 1);
        return minDepth;
    }

    private void minHeight(TreeNode node, int height) {
        if (node.left == null && node.right == null) {
            minDepth = Math.min(height, minDepth);
            return;
        }
        if (node.left != null)
            minHeight(node.left, height + 1);
        if (node.right != null)
            minHeight(node.right, height + 1);
    }
}
