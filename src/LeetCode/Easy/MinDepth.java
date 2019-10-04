package LeetCode.Easy;

import dataStructure.TreeNode;

public class MinDepth {
    public static void main(String[] args) {
        TreeNode root0 = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);
        root0.left = root1;
        root1.left = root2;
        root2.right = root3;
        root3.right = root4;
//        root0.right=root2;
//        root2.left=root3;
//        root2.right=root4;
        System.out.println(new MinDepth().minDepth(root0));
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null || root.right == null) {
            if (root.left == null) return minDepth(root.right) + 1;
            return minDepth(root.left) + 1;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        return leftDepth > rightDepth ? rightDepth + 1 : leftDepth + 1;
    }
}
