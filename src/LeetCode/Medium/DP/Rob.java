package LeetCode.Medium.DP;

import dataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Rob {
    class Solution {
        Map<TreeNode, Integer> f = new HashMap<>();
        Map<TreeNode, Integer> g = new HashMap<>();

        public int rob_better(TreeNode root) {
            rob_dfs(root);
            return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
        }

        public int rob(TreeNode root) {
            int[] rootStatus = rob_dfs(root);
            return Math.max(rootStatus[0], rootStatus[1]);
        }

        public int[] rob_dfs(TreeNode node) {
            if (node == null) {
                return new int[]{0, 0};
            }
            int[] l = rob_dfs(node.left);
            int[] r = rob_dfs(node.right);
            int selected = node.val + l[1] + r[1];
            int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
            return new int[]{selected, notSelected};
        }

        public void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            dfs(node.left);
            dfs(node.right);
            f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
            g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
        }
    }

}
