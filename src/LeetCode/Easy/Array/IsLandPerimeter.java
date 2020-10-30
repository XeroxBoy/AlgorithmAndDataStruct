package LeetCode.Easy.Array;

public class IsLandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result += nearNum(grid, i, j);
                }
            }
        }
        return result;
    }


    public int nearNum(int[][] grid, int row, int col) {
        int nearNum = 4;
        int m = grid.length, n = grid[0].length;
        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            nearNum -= 1;
        }
        if (row + 1 < m && grid[row + 1][col] == 1) {
            nearNum -= 1;
        }
        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            nearNum -= 1;
        }
        if (col + 1 < n && grid[row][col + 1] == 1) {
            nearNum -= 1;
        }
        return nearNum;
    }

}
