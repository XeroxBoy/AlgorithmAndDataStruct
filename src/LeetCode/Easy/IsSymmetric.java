package LeetCode.Easy;

import dataStructure.TreeNode;

import java.util.ArrayList;

public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left0 = new TreeNode(2);
        TreeNode right0 = new TreeNode(2);
        TreeNode left1 = new TreeNode(3);
        TreeNode left2 = new TreeNode(4);
        TreeNode right1 = new TreeNode(4);
        TreeNode right2 = new TreeNode(3);
        root.left = left0;
        root.right = right0;
        left0.left = left1;
        left0.right = left2;
        right0.left = right1;
        right0.right = right2;
        System.out.println(new IsSymmetric().isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSym(root.left, root.right);
    }

    public boolean isSym(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right != null && left.val == right.val) {
            return isSym(left.left, right.right) &&
                    isSym(left.right, right.left);
        } else return false;
    }
}
