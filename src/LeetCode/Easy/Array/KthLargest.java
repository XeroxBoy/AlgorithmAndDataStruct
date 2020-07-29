package LeetCode.Easy.Array;

import dataStructure.TreeNode;

public class KthLargest {
    int k_th;
    int index;

    public int kthLargest(TreeNode root, int k) {
        index = 1;
        k_th = root.val;
        find_largest(root, k);
        return k_th;
    }

    private void find_largest(TreeNode root, int k) {
        if (root == null) return;
        find_largest(root.right, k);
        if (index == k) k_th = root.val;
        index++;
        find_largest(root.left, k);
    }
}
