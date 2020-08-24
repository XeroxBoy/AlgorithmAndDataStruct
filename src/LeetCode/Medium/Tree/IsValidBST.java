package LeetCode.Medium.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;

public class IsValidBST {
    private ArrayList<Integer> list;

    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<>();
        valid(root);
        return isRightSeq(list);
    }

    private void valid(TreeNode node) {
        if (node == null) return;
        valid(node.left);
        list.add(node.val);
        valid(node.right);
    }

    private boolean isRightSeq(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            long chaju = new Long(list.get(i + 1)) - new Long(list.get(i));
            if (chaju <= 0) return false;
        }
        return true;
    }
}
