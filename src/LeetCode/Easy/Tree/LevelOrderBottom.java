package LeetCode.Easy.Tree;

import dataStructure.TreeNode;

import java.util.*;

public class LevelOrderBottom {
    public static void main(String[] args) {
        TreeNode root0 = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);
        root0.left = root1;
        root0.right = root2;
        root2.left = root3;
        root2.right = root4;
        List<List<Integer>> list = new LevelOrderBottom().levelOrderBottom(root0);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> eachList = list.get(i);
            for (int j = 0; j < eachList.size(); j++) {
                System.out.print(eachList.get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<Queue<TreeNode>> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) return list;
        Queue<TreeNode> queue0 = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue0.add(root);
        queue1.add(root);
        queue.add(queue1);
        int levelCount = 1;
        int nextLevelCount = 0;
        while (queue0.size() != 0) {
            Queue<TreeNode> queue2 = new LinkedList<>();
            while (levelCount-- != 0) {
                root = queue0.poll();
                if (root.left != null) {
                    queue2.add(root.left);
                    queue0.add(root.left);
                    nextLevelCount++;
                }
                if (root.right != null) {
                    queue2.add(root.right);
                    queue0.add(root.right);
                    nextLevelCount++;
                }
            }
            levelCount = nextLevelCount;
            nextLevelCount = 0;
            if (queue2.size() != 0)
                queue.add(queue2);
        }
        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            Queue<TreeNode> queue3 = queue.poll();
            List eachLevelNode = new ArrayList<TreeNode>();
            int innerQueSize = queue3.size();
            for (int j = 0; j < innerQueSize; j++) {
                eachLevelNode.add(queue3.poll().val);
            }
            list.add(eachLevelNode);
        }
        Stack<List<Integer>> stack = new Stack<>();
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            stack.push(list.get(i));
        }
        while (!stack.isEmpty()) {
            resultList.add(stack.pop());
        }
        return resultList;
    }

    public List<List<Integer>> greatLevelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> oneLevel = new ArrayList<>();
            // 每次都取出一层的所有数据
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                oneLevel.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            // 每次都往队头塞
            result.addFirst(oneLevel);
        }
        return result;
    }
}
