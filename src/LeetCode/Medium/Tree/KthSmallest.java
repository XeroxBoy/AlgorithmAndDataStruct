package LeetCode.Medium.Tree;

import dataStructure.TreeNode;

public class KthSmallest {
    private static int now_num = 0;
    private static int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        now_num = 0;
        result = 0;
        traverse_tree(root, k);
        return result;
    }

    private void traverse_tree(TreeNode root, int k) {
        if (root == null) return;
        traverse_tree(root.left, k);
        now_num++;
        if (now_num == k)
            result = root.val;
        traverse_tree(root.right, k);
    }
}
