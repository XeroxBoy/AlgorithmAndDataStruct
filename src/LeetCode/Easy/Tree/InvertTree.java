package LeetCode.Easy.Tree;

import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left); // 递归找到左节点
        TreeNode rightNode= root.right; // 保存右节点
        root.right = root.left;
        root.left = rightNode;
        // 递归找到右节点 继续交换 : 因为此时左右节点已经交换了,所以此时的右节点为root.left
        invertTree(root.left);
        return root;
    }
    // 先序遍历--从顶向下交换
    public TreeNode preInvertTree(TreeNode root) {
        if (root == null) return null;
        // 保存右子树
        TreeNode rightTree = root.right;
        // 交换左右子树的位置
        root.right = preInvertTree(root.left);
        root.left = preInvertTree(rightTree);
        return root;
    }
    public TreeNode backInvertTree(TreeNode root) {
        // 后序遍历-- 从下向上交换
        if (root == null) return null;
        TreeNode leftNode = backInvertTree(root.left);
        TreeNode rightNode = backInvertTree(root.right);
        root.right = leftNode;
        root.left = rightNode;
        return root;
    }
    public TreeNode queueInvertTree(TreeNode root) {
        // 层次遍历--直接左右交换即可
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode rightTree = node.right;
            node.right = node.left;
            node.left = rightTree;
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return root;
    }
}

