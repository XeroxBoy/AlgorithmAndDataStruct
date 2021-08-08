package company.meituan;

import dataStructure.TreeNode;

import java.util.Scanner;

public class ChangeTree {
    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 第一行是一行整数n, m, k，表示有n个节点，从1编号到n。小美会进行m次节点的调换。小美给出的二叉树的根节点是k。
     * <p>
     * 接下来有 n 行，对于第 i 行，每行两个正整数，描述 i 号节点的左右儿子。其中对于没有儿子的情况用0来表示。
     * <p>
     * 最后一行是m个空格隔开的正整数，每个正整数表示小美调换了这个正整数所标识的节点的左右子树。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = null;
        }
        nodes[0] = new TreeNode(k);
        for (int i = 0; i < n; i++) {
            TreeNode oneNode = nodes[i];
            int left = sc.nextInt();
            int right = sc.nextInt();
            if (left != 0) {
                nodes[i * 2 + 1] = new TreeNode(left);
                oneNode.left = nodes[i * 2 + 1];
            }
            if (right != 0) {
                nodes[i * 2 + 2] = new TreeNode(right);
                oneNode.right = nodes[i * 2 + 2];
            }
        }
        for (int i = 0; i < m; i++) {
            int changeIndex = sc.nextInt();
            changeSym(nodes[changeIndex - 1]);
        }
        traverseTree(nodes[0]);
    }

    private static void traverseTree(TreeNode root) {
        if (root == null) return;
        traverseTree(root.left);
        System.out.print(root.val + " ");
        traverseTree(root.right);
    }

    private static void changeSym(TreeNode node) {
        if (node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
