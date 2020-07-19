package LeetCode.Easy.Tree;

import dataStructure.TreeNode;

public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
//        root.right = left;
//        root.left = right;
        return root;
    }
}
