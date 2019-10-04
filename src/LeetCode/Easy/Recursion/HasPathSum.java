package LeetCode.Easy.Recursion;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class HasPathSum {
    List<Integer> sumList = new ArrayList();

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        pathSum(root, root.val);
        for (int i = 0; i < sumList.size(); i++) {
            if (sumList.get(i).equals(sum)) return true;
        }
        return false;
    }

    public void pathSum(TreeNode root, int nowSum) {
        if (root.left == null && root.right == null) {
            sumList.add(nowSum);
            return;
        }
        if (root.left != null)
            pathSum(root.left, nowSum + root.left.val);
        if (root.right != null)
            pathSum(root.right, nowSum + root.right.val);
    }
}
