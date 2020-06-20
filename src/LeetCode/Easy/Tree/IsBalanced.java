package LeetCode.Easy.Tree;

import dataStructure.TreeNode;

public class IsBalanced {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(treeHeight(root.left)
                - treeHeight(root.right)) < 2;
    }

    private int treeHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
