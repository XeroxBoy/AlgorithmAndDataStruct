package LeetCode.Easy.Tree;

import dataStructure.TreeNode;

public class PathSum {
    int pathNum = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        sum(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return pathNum;
    }

    public void sum(TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        if (sum == 0) {
            pathNum++;
        }
        sum(root.left, sum);
        sum(root.right, sum);
    }
}
