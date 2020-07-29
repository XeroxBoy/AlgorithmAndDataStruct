package LeetCode.Easy.Tree;

import dataStructure.TreeNode;

public class MaxDepth {
    int maxdepth;

    public int maxDepth(TreeNode root) {
        maxdepth = 0;
        find_depth(root, 1);
        return maxdepth;
    }

    private void find_depth(TreeNode root, int depth) {
        if (root == null) return;
        maxdepth = Math.max(depth, maxdepth);
        if (root.left != null) find_depth(root.left, depth + 1);
        if (root.right != null) find_depth(root.right, depth + 1);
    }
}
