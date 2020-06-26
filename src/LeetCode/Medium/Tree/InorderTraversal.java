package LeetCode.Medium.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        root.right = right1;
        TreeNode leftRight1 = new TreeNode(3);
        right1.left = leftRight1;
        List<Integer> results = new InorderTraversal().inorderTraversal(root);
        for (Integer i : results
        ) {
            System.out.println(i);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            resultList.add(curr.val);
            curr = curr.right;
        }
        return resultList;
    }
}
