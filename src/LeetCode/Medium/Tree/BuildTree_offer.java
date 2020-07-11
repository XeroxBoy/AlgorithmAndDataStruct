package LeetCode.Medium.Tree;

import dataStructure.TreeNode;

import java.util.HashMap;

public class BuildTree_offer {
    private HashMap<Integer, Integer> map;

    public static void main(String[] args) {
        new BuildTree_offer().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        new BuildTree_offer().buildTree(new int[]{3, 1, 2, 4}, new int[]{1, 2, 3, 4});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return builder(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode builder(int[] preorder, int[] inorder, int startPreIndex, int endPreIndex,
                            int startInIndex, int endInIndex) {
        if (startPreIndex > endPreIndex) return null;
        int rootVal = preorder[startPreIndex];
        int rootInIndex = map.get(preorder[startPreIndex]);
//        for (int i = 0; i < inorder.length; i++) {
//            if (inorder[i] == rootVal) rootInIndex = i;
//        }
        TreeNode root = new TreeNode(rootVal);
        int leftNum = rootInIndex - startInIndex;
        root.left = builder(preorder, inorder, startPreIndex + 1, startPreIndex + leftNum, startInIndex, rootInIndex - 1);
        root.right = builder(preorder, inorder, startPreIndex + leftNum + 1, endPreIndex, rootInIndex + 1, endInIndex);
        return root;
    }
}
