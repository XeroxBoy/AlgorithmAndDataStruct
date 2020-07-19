package LeetCode.Medium.Tree;

import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
* 这类题目与字符串匹配有些神似，求解过程大致分为两步：

先将根节点匹配；

根节点匹配后，对子树进行匹配。

而参与匹配的二叉树可以是一棵，与自身匹配；也可以是两棵，即互相匹配。

* */
public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (dfs_equal(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }


    public boolean dfs_equal(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null || t1.val != t2.val) return false;
        return dfs_equal(t1.left, t2.left) && dfs_equal(t1.right, t2.right);
    }


    public boolean isSubStructure_bfs(TreeNode A, TreeNode B) {
        if (B == null || A == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        while (!queue.isEmpty()) {
            TreeNode node_a = queue.poll();
            if (isEqual(node_a, B)) return true;
            if (node_a.left != null)
                queue.offer(node_a.left);
            if (node_a.right != null)
                queue.offer(node_a.right);
        }
        return false;
    }

    public boolean isEqual(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        return A.val == B.val && isEqual(A.left, B.left) && isEqual(A.right, B.right);
    }
}
