package LeetCode.Easy.Tree;

import dataStructure.TreeNode;

import java.util.HashSet;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] array = new int[]{-10, -3, 0, 5, 9};
        System.out.println(new SortedArrayToBST().sortedArrayToBST(array).left.right.val);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
        return root;
    }

}
