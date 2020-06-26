package LeetCode.Medium.Array;

public class MaxAreaOfIsland {
    private static int[][] visited;

    public static void main(String[] args) {
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}
        ));
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(new int[][]
                {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}}));
        System.out.println(
                new MaxAreaOfIsland().maxAreaOfIsland(new int[][]{{0, 1, 1}, {1, 1, 0}})
        );
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] != 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0) return 0;
        visited[i][j] = 1;
        int nowArea = 1;

        if (i + 1 < grid.length && grid[i + 1][j] == 1 && visited[i + 1][j] != 1) {
            nowArea += dfs(grid, i + 1, j);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == 1 && visited[i - 1][j] != 1) {
            nowArea += dfs(grid, i - 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1 && visited[i][j - 1] != 1) {
            nowArea += dfs(grid, i, j - 1);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1 && visited[i][j + 1] != 1) {
            nowArea += dfs(grid, i, j + 1);
        }

        return nowArea;
    }

    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int res = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        res = Math.max(res, dfs(i, j, grid));
                    }
                }
            }
            return res;
        }

        // 每次调用的时候默认num为1，进入后判断如果不是岛屿，则直接返回0，就可以避免预防错误的情况。
        // 每次找到岛屿，则直接把找到的岛屿改成0，这是传说中的沉岛思想，就是遇到岛屿就把他和周围的全部沉默。
        // ps：如果能用沉岛思想，那么自然可以用朋友圈思想。有兴趣的朋友可以去尝试。
        private int dfs(int i, int j, int[][] grid) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
                return 0;
            }
            grid[i][j] = 0;
            int num = 1;
            num += dfs(i + 1, j, grid);
            num += dfs(i - 1, j, grid);
            num += dfs(i, j + 1, grid);
            num += dfs(i, j - 1, grid);
            return num;

        }
    }
}
