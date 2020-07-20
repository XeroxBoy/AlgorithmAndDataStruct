package LeetCode.Medium.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {
    private static List<List<Integer>> sumList;
    private static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(-2);
        TreeNode n2 = new TreeNode(-3);
        n1.right = n2;
        new PathSum().pathSum(n1, -5).forEach(System.out::println);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        sumList = new LinkedList<>();
        calculateSum(root, 0, sum);
        return sumList;
    }

    private void calculateSum(TreeNode root, int nowSum, int sum) {
        if (root == null) return;
        list.add(root.val);
        nowSum += root.val;
        if (nowSum == sum && root.left == null && root.right == null) {
            sumList.add(new LinkedList<>(list));
        }
        calculateSum(root.left, nowSum, sum);
        calculateSum(root.right, nowSum, sum);
        list.removeLast();
    }

}
