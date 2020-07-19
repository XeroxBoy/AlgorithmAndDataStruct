package LeetCode.Easy.Tree;

import dataStructure.TreeNode;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isSame(left.left, right.right) && isSame(left.right, right.left);
    }
}
