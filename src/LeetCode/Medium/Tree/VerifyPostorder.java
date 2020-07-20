package LeetCode.Medium.Tree;

public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        int n = postorder.length;
        return isTree(postorder, 0, n - 1);
    }

    private boolean isTree(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int last = postorder[j];
        int divider = j;
        for (int k = i; k < j; k++) {
            if (postorder[k] > last) {
                divider = k;
                break;
            }
        }
        int p = 0;
        for (int k = divider; k <= j; k++) {
            if (postorder[k] <= last) {
                p = k;
                break;
            }
        }
        return p == j && isTree(postorder, i, divider - 1) && isTree(postorder, divider, j - 1);
    }

    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return recur(postorder, 0, postorder.length - 1);
        }

        boolean recur(int[] postorder, int i, int j) {
            if (i >= j) return true;
            int p = i;
            while (postorder[p] < postorder[j]) p++;
            int m = p;
            while (postorder[p] > postorder[j]) p++;
            return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
        }
    }

}
