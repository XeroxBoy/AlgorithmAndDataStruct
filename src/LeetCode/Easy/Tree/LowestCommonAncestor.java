package LeetCode.Easy.Tree;

import dataStructure.TreeNode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = null;
        if ((root.val - p.val) * (root.val - q.val) <= 0) {
            res = root;
            return res;
        } else if (root.val < p.val && root.val < q.val) {
            res = lca(root.right, p, q);
            return res;
        } else {
            res = lca(root.left, p, q);
            return res;
        }
    }
}
