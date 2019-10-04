package LeetCode.Easy.Recursion;

import dataStructure.TreeNode;

public class MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left0 = new TreeNode(9);
        TreeNode right0 = new TreeNode(20);
        TreeNode right1 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);
        root.left = left0;
        root.right = right0;
        right0.left = right1;
        right0.right = right2;
        System.out.println(new MaxDepth().maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int max = Math.max(left, right);
        return max + 1;
//        return maxDepth(root.left)>maxDepth(root.right)?maxDepth(root.left)+1:maxDepth(root.right)+1;
    }
}
