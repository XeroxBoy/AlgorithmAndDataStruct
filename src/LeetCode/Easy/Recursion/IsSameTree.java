package LeetCode.Easy.Recursion;

import dataStructure.TreeNode;

import java.util.Stack;

public class IsSameTree {
    public static void main(String[] args) {
        TreeNode root0 = new TreeNode(1);
        TreeNode left0 = new TreeNode(2);
        TreeNode right0 = new TreeNode(3);
        TreeNode root1 = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        root0.left = left0;
//        root0.right = right0;
//        root1.left = left1;
//        root1.right = right1;
        root1.right = left1;
        System.out.println(new IsSameTree().isSameTree(root0, root1));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

    /**
     * 非递归前序遍历判断相等
     * 根左右
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreePre(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        Stack<TreeNode> stackP = new Stack<>();
        stackP.add(p);
        Stack<TreeNode> stackQ = new Stack<>();
        stackQ.add(q);
        while (!stackP.isEmpty() || !stackQ.isEmpty()) {
            TreeNode pNode = stackP.pop();
            TreeNode qNode = stackQ.pop();
            if (pNode == null && qNode == null) continue;
            if (pNode == null) return false;
            if (qNode == null) return false;
            if (pNode.val != qNode.val) {
                return false;
            } else {
                stackP.add(pNode.right);
                stackQ.add(qNode.right);
                stackP.add(pNode.left);
                stackQ.add(qNode.left);
            }
        }
        return true;
    }

    /**
     * 非递归中序遍历判断两棵二叉树是否相等
     * 左根右
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeMid(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        while (p != null || q != null || !stackP.isEmpty() || !stackQ.isEmpty()) {
            if (p != null && q != null) {
                stackP.add(p);
                stackQ.add(q);
                p = p.left;
                q = q.left;
            } else if (q == null && p == null) {
                p = stackP.pop();
                q = stackQ.pop();
                if (p.val != q.val) {
                    return false;
                }
                p = p.right;
                q = q.right;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 二叉树后序遍历判断两颗树相等
     * 左右根
     * 双栈解法
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeEnd1(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackPTmp = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        Stack<TreeNode> stackQTmp = new Stack<>();
        while (p != null || q != null || !stackPTmp.isEmpty() || !stackQTmp.isEmpty()) {
            if (p != null && q != null) {
                stackP.add(p);
                stackPTmp.add(p);
                stackQ.add(q);
                stackQTmp.add(p);
                p = p.right;
                q = q.right;
            } else if (p == null && q == null) {
                p = stackPTmp.pop();
                p = p.left;
                q = stackQTmp.pop();
                q = q.left;
            } else {
                return false;
            }
        }

        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            if (stackP.pop().val != stackQ.pop().val) {
                return false;
            }
        }

        return true;
    }

    /**
     * 二叉树后序遍历单栈实现对比判断
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeEnd2(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        Stack<TreeNode> stackP = new Stack<>();
        stackP.add(p);
        TreeNode pPre = null;
        Stack<TreeNode> stackQ = new Stack<>();
        stackQ.add(q);
        TreeNode qPre = null;
        while (!stackP.isEmpty() || !stackQ.isEmpty()) {
            p = stackP.peek();
            q = stackQ.peek();
            if (((pPre != null && (p.left == pPre || p.right == pPre)) || (p.left == null && p.right == null)) &&
                    ((qPre != null && (q.left == qPre || q.right == qPre)) || (q.left == null && q.right == null))) {
                if (p.val != q.val) {
                    return false;
                }
                pPre = p;
                qPre = q;
                stackP.pop();
                stackQ.pop();
            } else {
                if (p.right != null && q.right != null) {
                    stackP.add(p.right);
                    stackQ.add(q.right);
                } else if (p.right != null || q.right != null) {
                    return false;
                }

                if (p.left != null && q.left != null) {
                    stackP.add(p.left);
                    stackQ.add(q.left);
                } else if (p.left != null || q.left != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
