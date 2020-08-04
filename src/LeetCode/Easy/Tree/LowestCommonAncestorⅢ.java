package LeetCode.Easy.Tree;

import dataStructure.TreeNode;

/*
 * 二叉树版本
 * */
public class LowestCommonAncestorⅢ {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.left != null) {
            TreeNode leftFather = lowestCommonAncestor(root.left, p, q);
            if (contains(leftFather, p) && contains(leftFather, q)) return leftFather;
        }
        if (root.right != null) {
            TreeNode rightFather = lowestCommonAncestor(root.right, p, q);
            if (contains(rightFather, p) && contains(rightFather, q)) return rightFather;
        }
        return root;
    }

    public boolean contains(TreeNode root, TreeNode target) {
        if (root == null) return false;
        return root.val == target.val || contains(root.left, target) || contains(root.right, target);
    }
}
