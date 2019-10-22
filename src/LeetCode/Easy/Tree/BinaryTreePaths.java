package LeetCode.Easy.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    List<String> pathList = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        tarverseTree("", root);
        List<String> resultList = new ArrayList<>();
        for (String path : pathList
        ) {
            path = path.substring(2);
            resultList.add(path);
        }
        return resultList;
    }

    public void tarverseTree(String s, TreeNode root) {
        if (root == null) return;
        s += "->";
        s += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            pathList.add(s);
            return;
        }
        tarverseTree(s, root.left);
        tarverseTree(s, root.right);
    }

    public static void main(String[] args) {
        TreeNode h1 = new TreeNode(1);
        TreeNode h2 = new TreeNode(2);
        TreeNode h3 = new TreeNode(3);
        TreeNode h4 = new TreeNode(5);
        h1.left = h2;
        h1.right = h3;
        h2.right = h4;
        List<String> resultString = new BinaryTreePaths().binaryTreePaths(h4);
        for (String s : resultString
        ) {
            System.out.println(s);
        }
    }

}

