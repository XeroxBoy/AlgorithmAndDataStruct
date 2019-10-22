package LeetCode.Easy.Tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;

public class ConvertBST {
    public TreeNode convertBST(TreeNode root) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        traverseTree(root, numList);
        numList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        changeTree(root, numList);
        return root;
    }

    private void changeTree(TreeNode root, ArrayList<Integer> numList) {
        if (root == null) return;
        int num = root.val;
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) <= root.val) break;
            num += numList.get(i);
        }
        root.val = num;
        changeTree(root.left, numList);
        changeTree(root.right, numList);
    }

    private void traverseTree(TreeNode root, ArrayList<Integer> numList) {
        if (root == null) return;
        numList.add(root.val);
        if (root.left != null) {
            traverseTree(root.left, numList);
        }
        if (root.right != null) {
            traverseTree(root.right, numList);
        }
    }

    public int preNum = 0;

    //递归写法
    public TreeNode greatConvertBST(TreeNode root) {
        unPreOrder(root);
        return root;
    }

    public void unPreOrder(TreeNode root) {
        if (root == null)
            return;
        unPreOrder(root.right);
        root.val += preNum;
        preNum = root.val;
        unPreOrder(root.left);
    }
    //非递归写法
    /*public TreeNode convertBST(TreeNode root) {
        if(root == null)
            return root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //stack.add(root);
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.add(node);
                node = node.right;
            }
            node = stack.pop();
            node.val += preNum;
            preNum = node.val;
            if(node.left != null)
                node = node.left;
            else
                node = null;
        }
        return root;
    }*/

    public static void main(String[] args) {
        TreeNode h1 = new TreeNode(2);
        TreeNode h2 = new TreeNode(1);
        TreeNode h3 = new TreeNode(3);
        h1.left = h2;
        h1.right = h3;
        new ConvertBST().convertBST(h1);
        System.out.println(h1.val + " " + h2.val + " " + h3.val);
    }

}

