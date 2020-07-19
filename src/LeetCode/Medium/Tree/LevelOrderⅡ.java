package LeetCode.Medium.Tree;

import dataStructure.TreeNode;

import java.util.*;

public class LevelOrderⅡ {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode right_1 = new TreeNode(15);
        TreeNode right_2 = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = right_1;
        right.right = right_2;

        Arrays.stream(new LevelOrderⅡ().levelOrder(root)).forEach(System.out::println);
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        int[] orders = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            orders[i] = list.get(i);
        }
        return orders;
    }
}
