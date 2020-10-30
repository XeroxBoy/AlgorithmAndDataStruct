package LeetCode.Medium.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SumNumbers {
    private List<Integer> sumList;

    public int sumNumbers(TreeNode root) {
        sumList = new ArrayList<>();
        traverseTree(root, new LinkedList<>());
        return calculateListSum(sumList);
    }

    private void traverseTree(TreeNode root, LinkedList<Integer> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root.val);
        if (root.left == null && root.right == null) {
            sumList.add(calculateListLevelSum(nodes));
            return;
        }
        if (root.left != null) {
            LinkedList<Integer> leftList = new LinkedList<>(nodes);
            leftList.add(root.left.val);
            traverseTree(root.left, leftList);
        }
        if (root.right != null) {
            LinkedList<Integer> rightList = new LinkedList<>(nodes);
            rightList.add(root.right.val);
            traverseTree(root.right, rightList);
        }
    }

    private int calculateListLevelSum(List<Integer> list) {
        int mutilplyer = 1;
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            sum += list.get(i) * mutilplyer;
            mutilplyer *= 10;
        }
        return sum;
    }


    private int calculateListSum(List<Integer> list) {
        int result = 0;
        for (Integer integer : list) {
            result += integer;
        }
        return result;
    }

}
