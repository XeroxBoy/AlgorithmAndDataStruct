package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IsSymmetrical {
    private List<TreeNode> leftList = new ArrayList<TreeNode>();
    private List<TreeNode> rightList = new ArrayList<TreeNode>();

    public static void main(String[] args) {

    }

    boolean isSymmetrical(TreeNode pRoot) {
        middleLeftLoop(pRoot, pRoot);
        middleRightLoop(pRoot, pRoot);
        if (leftList.size() != rightList.size()) return false;
        for (int i = 0; i < leftList.size(); i++) {
            if (leftList.get(i) != rightList.get(i)) return false;
        }
        return true;
    }

    void middleLeftLoop(TreeNode pRootLoop, TreeNode pRoot) {
        if (pRootLoop == null) return;
        leftList.add(pRootLoop.left);
        middleLeftLoop(pRootLoop.left, pRoot);
        if (pRootLoop == pRoot) {
            return;
        }
        leftList.add(pRootLoop.right);
        middleLeftLoop(pRootLoop.right, pRoot);
    }

    void middleRightLoop(TreeNode pRootLoop, TreeNode pRoot) {
        if (pRootLoop == null) return;
        rightList.add(pRootLoop.right);
        middleRightLoop(pRootLoop.right, pRoot);
        if (pRootLoop == pRoot) {
            return;
        }
        rightList.add(pRootLoop.left);
        middleRightLoop(pRootLoop.left, pRoot);
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
