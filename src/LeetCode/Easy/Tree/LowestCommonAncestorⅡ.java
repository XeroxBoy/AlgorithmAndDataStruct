package LeetCode.Easy.Tree;

import dataStructure.TreeNode;

/*
 * 二叉搜索树
 * */
public class LowestCommonAncestorⅡ {
    // 错误
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) return null;
//        if (root.left == null && root.right == null) return null;
//        TreeNode leftFather = lowestCommonAncestor(root.left, p, q);
//        TreeNode rightFather = lowestCommonAncestor(root.right, p, q);
//        if ((root.val - p.val) * (q.val - root.val) >= 0) return root;
//        if (root.left == p && root.right == q) return root;
//        return leftFather == null ? rightFather : leftFather;
//    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if ((root.val - p.val) * (q.val - root.val) == 0) return root;
        TreeNode leftFather = lowestCommonAncestor(root.left, p, q);
        TreeNode rightFather = lowestCommonAncestor(root.right, p, q);
        if (leftFather != null && rightFather != null) return root;
        return leftFather == null ? rightFather : leftFather;
    }
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (p.val < root.val && q.val < root.val)
//            return lowestCommonAncestor(root.right, p, q);
//        if (p.val > root.val && q.val > root.val)
//            return lowestCommonAncestor(root.left, p, q);
//        return root;
//    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while (root != null) {
                if (p.val < root.val && q.val < root.val) {
                    root = root.left;
                } else if (p.val > root.val && q.val > root.val) {
                    root = root.right;
                } else break;
            }
            return root;
        }
    }

}
