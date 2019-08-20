package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IsSymmetrical {
    private List<TreeNode> leftList = new ArrayList<TreeNode>();
    private List<Integer> leftDepthList = new ArrayList<Integer>();
    private List<Integer> rightDepthList = new ArrayList<Integer>();
    private List<TreeNode> rightList = new ArrayList<TreeNode>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(2);
        root.left = left1;
        root.right = right1;
        System.out.println(new IsSymmetrical().isSymmetrical(root));
    }

    boolean isSymmetrical(TreeNode pRoot) {
        middleLeftLoop(pRoot, pRoot, 1);
        middleRightLoop(pRoot, pRoot, 1);
        if (leftList.size() != rightList.size() || leftDepthList.size() != rightDepthList.size()) return false;
        for (int i = 0; i < leftList.size(); i++) {
            if (leftList.get(i).val != rightList.get(i).val) return false;
            if (!leftDepthList.get(i).equals(rightDepthList.get(i))) return false;
        }
        return true;
    }

    void middleLeftLoop(TreeNode pRootLoop, TreeNode pRoot, int depth) {
        if (pRootLoop == null) return;
        if (pRootLoop.left != null) {
            leftList.add(pRootLoop.left);
            leftDepthList.add(depth);
        }
        middleLeftLoop(pRootLoop.left, pRoot, depth + 1);
        if (pRootLoop == pRoot) {
            return;
        }
        if (pRootLoop.right != null) {
            leftList.add(pRootLoop.right);
            leftDepthList.add(depth);
        }
        middleLeftLoop(pRootLoop.right, pRoot, depth + 1);
    }

    void middleRightLoop(TreeNode pRootLoop, TreeNode pRoot, int depth) {
        if (pRootLoop == null) return;
        if (pRootLoop.right != null) {
            rightList.add(pRootLoop.right);
            rightDepthList.add(depth);
        }
        middleRightLoop(pRootLoop.right, pRoot, depth + 1);
        if (pRootLoop == pRoot) {
            return;
        }
        if (pRootLoop.left != null) {
            rightList.add(pRootLoop.left);
            rightDepthList.add(depth);
        }
        middleRightLoop(pRootLoop.left, pRoot, depth + 1);
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int value) {
            val = value;
        }

    }
}
