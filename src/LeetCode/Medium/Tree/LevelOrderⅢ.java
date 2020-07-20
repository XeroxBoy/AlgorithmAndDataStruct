package LeetCode.Medium.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderⅢ {
    public List<List<Integer>> levelOrder(TreeNode root) {
        boolean reverse = false;
        List<List<Integer>> levelList = new ArrayList<>();
        if (root == null) return levelList;
        Queue<TreeNode> node_queue = new LinkedList<>();
        node_queue.offer(root);
        while (!node_queue.isEmpty()) {
            int size = node_queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = size - 1; i >= 0; i--) {
                TreeNode node = node_queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    node_queue.offer(node.left);
                }
                if (node.right != null) {
                    node_queue.offer(node.right);
                }
            }
            if (reverse) {
                List<Integer> reverseList = new ArrayList<>();
                for (int i = list.size() - 1; i >= 0; i--) {
                    reverseList.add(list.get(i));
                }
                levelList.add(reverseList);
                reverse = false;
            } else {
                levelList.add(list);
                reverse = true;
            }
        }
        return levelList;
    }
}
