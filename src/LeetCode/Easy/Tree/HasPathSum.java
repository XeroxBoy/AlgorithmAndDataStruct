package LeetCode.Easy.Tree;

import dataStructure.TreeNode;

public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        return pathSum(root, 0, sum);
    }

    public boolean pathSum(TreeNode root, int now_sum, int target) {
        if (root == null) return false;
        now_sum += root.val;
        if ((now_sum == target && root.left == null && root.right == null)) return true;
        return pathSum(root.left, now_sum, target) || pathSum(root.right, now_sum, target);
    }
}
