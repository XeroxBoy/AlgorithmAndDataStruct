package LeetCode.Medium.Tree;

import dataStructure.TreeNode;

import java.util.HashMap;

public class BuildTree {
    private HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeFromRoot(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode buildTreeFromRoot(int[] preorder, int[] inorder, int preOrderStartIndex, int preOrderEndIndex
            , int startMidIndex, int endMidIndex) {
        if (preOrderStartIndex > preOrderEndIndex) return null;
        TreeNode root = new TreeNode(preorder[preOrderStartIndex]);
        int rootMidIndex = map.get(preorder[preOrderStartIndex]);
        int leftNum = rootMidIndex - startMidIndex;
        int rightNum = endMidIndex - rootMidIndex;
        root.left = buildTreeFromRoot(preorder, inorder, preOrderStartIndex + 1, preOrderStartIndex +
                leftNum, startMidIndex, rootMidIndex - 1);
        root.right = buildTreeFromRoot(preorder, inorder, preOrderStartIndex + leftNum + 1, preOrderEndIndex
                , rootMidIndex + 1, endMidIndex);
        return root;
    }

}
