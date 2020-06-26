package LeetCode.Medium.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    private Queue<TreeNode> queue = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node0.left = node1;
        node0.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(new LevelOrder().levelOrder(node0));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> levelOrderList = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> eachLevelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                eachLevelList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            levelOrderList.add(eachLevelList);
        }
        return levelOrderList;
    }
}
