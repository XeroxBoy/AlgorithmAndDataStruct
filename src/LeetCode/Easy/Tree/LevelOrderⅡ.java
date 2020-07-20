package LeetCode.Easy.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderⅡ {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        new LevelOrderⅡ().levelOrder(node1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        Queue<TreeNode> node_queue = new LinkedList<>();
        if (root == null) return levelList;
        node_queue.offer(root);
        while (!node_queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = node_queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = node_queue.poll();
                list.add(node.val);
                if (node.left != null) node_queue.offer(node.left);
                if (node.right != null) node_queue.offer(node.right);
            }
            levelList.add(list);
        }
        return levelList;
    }
}
