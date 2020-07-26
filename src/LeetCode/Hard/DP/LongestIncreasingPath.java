package LeetCode.Hard.DP;

import java.util.LinkedList;
import java.util.Queue;

public class LongestIncreasingPath {
    int[][] max_len;

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingPath().longestIncreasingPath(new int[][]{{1, 2}}));
        System.out.println(new LongestIncreasingPath().longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
        new LongestIncreasingPath().longestIncreasingPath(new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, {
                19, 18, 17, 16, 15, 14, 13, 12, 11, 10}, {20, 21, 22, 23, 24, 25, 26, 27, 28, 29}, {
                39, 38, 37, 36, 35, 34, 33, 32, 31, 30}, {40, 41, 42, 43, 44, 45, 46, 47, 48, 49}, {
                59, 58, 57, 56, 55, 54, 53, 52, 51, 50}, {60, 61, 62, 63, 64, 65, 66, 67, 68, 69}, {
                79, 78, 77, 76, 75, 74, 73, 72, 71, 70}, {80, 81, 82, 83, 84, 85, 86, 87, 88, 89}, {
                99, 98, 97, 96, 95, 94, 93, 92, 91, 90}, {100, 101, 102, 103, 104, 105, 106, 107, 108, 109}, {
                119, 118, 117, 116, 115, 114, 113, 112, 111, 110}, {120, 121, 122, 123, 124, 125, 126, 127, 128, 129}, {
                139, 138, 137, 136, 135, 134, 133, 132, 131, 130}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}});
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        max_len = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(max_len[i], 1);
//        }
        int max_num = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max_num = Math.max(max_num, start_find_path(matrix, i, j));
            }
        }
        return max_num;
    }

    private int start_find_path(int[][] matrix, int i, int j) {
        if (max_len[i][j] != 0) return max_len[i][j];
        ++max_len[i][j];
        int now_num = matrix[i][j];
        if (i + 1 < matrix.length && matrix[i + 1][j] > now_num) {
            max_len[i][j] = Math.max(1 + start_find_path(matrix, i + 1, j), max_len[i][j]);
        }
        if (j + 1 < matrix[i].length && matrix[i][j + 1] > now_num) {
            max_len[i][j] = Math.max(1 + start_find_path(matrix, i, j + 1), max_len[i][j]);
        }
        if (i - 1 >= 0 && matrix[i - 1][j] > now_num) {
            max_len[i][j] = Math.max(1 + start_find_path(matrix, i - 1, j), max_len[i][j]);
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > now_num) {
            max_len[i][j] = Math.max(1 + start_find_path(matrix, i, j - 1), max_len[i][j]);
        }
        return max_len[i][j];
    }

    //拓扑排序做法
    class Solution {
        public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int rows, columns;

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            rows = matrix.length;
            columns = matrix[0].length;
            int[][] outdegrees = new int[rows][columns];
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    for (int[] dir : dirs) {
                        int newRow = i + dir[0], newColumn = j + dir[1];
                        if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[i][j]) {
                            ++outdegrees[i][j];
                        }
                    }
                }
            }
            Queue<int[]> queue = new LinkedList<int[]>();
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    if (outdegrees[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                    }
                }
            }
            int ans = 0;
            while (!queue.isEmpty()) {
                ++ans;
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    int[] cell = queue.poll();
                    int row = cell[0], column = cell[1];
                    for (int[] dir : dirs) {
                        int newRow = row + dir[0], newColumn = column + dir[1];
                        if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] < matrix[row][column]) {
                            --outdegrees[newRow][newColumn];
                            if (outdegrees[newRow][newColumn] == 0) {
                                queue.offer(new int[]{newRow, newColumn});
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }
}
