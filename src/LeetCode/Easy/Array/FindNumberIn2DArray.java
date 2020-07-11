package LeetCode.Easy.Array;

public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }

    class Solution {
        //从左下 右上找
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int rows = matrix.length, columns = matrix[0].length;
            int row = rows - 1, column = 0;
            while (row >= 0 && column < columns) {
                int num = matrix[row][column];
                if (num == target) {
                    return true;
                } else if (num > target) {
                    row--;
                } else {
                    column++;
                }
            }
            return false;
        }
    }


}
