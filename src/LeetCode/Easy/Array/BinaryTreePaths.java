package LeetCode.Easy.Array;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    private List<String> pathList;

    public List<String> binaryTreePaths(TreeNode root) {
        pathList = new ArrayList<>();
        if (root != null)
            traverse(root, new StringBuilder());
        return pathList;
    }

    private void traverse(TreeNode node, StringBuilder paths) {
        if (node == null) {
            return;
        }
        paths.append("->").append(node.val);
        if (node.left == null && node.right == null) {
            pathList.add(paths.substring(2));
            return;
        }
        if (node.left != null) {
            traverse(node.left, new StringBuilder(paths));
        }
        if (node.right != null) {
            traverse(node.right, new StringBuilder(paths));
        }
    }
}
