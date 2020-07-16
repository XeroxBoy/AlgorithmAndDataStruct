package LeetCode.Medium.Graph;

import java.util.Arrays;
import java.util.HashSet;


public class IsBipartite {
    private boolean valid = true;

    public static void main(String[] args) {
        new IsBipartite().isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}});
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == COLOR.UNCOLORED.getState())
                dfs(i, COLOR.RED, graph, color);
        }
        return valid;
    }

    private void dfs(int i, COLOR color_type, int[][] graph, int[] color) {
        color[i] = color_type.getState();
        COLOR next_type = color_type == COLOR.RED ? COLOR.GREEN : COLOR.RED;
        int[] part_nodes = graph[i];
        for (int j = 0; j < part_nodes.length; j++) {
            if (color[part_nodes[j]] == COLOR.UNCOLORED.getState()) {
                dfs(part_nodes[j], next_type, graph, color);
                if (!valid) return;
            } else if (color[part_nodes[j]] != next_type.getState()) {
                valid = false;
                return;
            }
        }
    }

    enum COLOR {
        UNCOLORED(0), RED(1), GREEN(2);
        //必须增加一个构造函数,变量,得到该变量的值
        private int mState;

        private COLOR(int value) {
            mState = value;
        }

        /**
         * @return 枚举变量实际返回值
         */
        public int getState() {
            return mState;
        }
    }
}
