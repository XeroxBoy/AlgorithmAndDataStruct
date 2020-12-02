package LeetCode.Top100.Matrix;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = 0;
        int n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0) {
            if (matrix[m][n] == target) return true;
            else if (matrix[m][n] > target) n--;
            else m++;
        }
        return false;
    }

    private boolean traverse_find_target(int[][] matrix, int i, int j, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (i >= m || j >= n) return false;
        if (matrix[i][j] == target) return true;
        boolean hasTarget = false;
        if (i + 1 < m && j + 1 < n && matrix[i + 1][j] > target && matrix[i][j + 1] > target) return false;
        if (i + 1 < m && matrix[i + 1][j] <= target) {
            hasTarget |= traverse_find_target(matrix, i + 1, j, target);
            if (hasTarget) return hasTarget;
        }
        if (j + 1 < n && matrix[i][j + 1] <= target) {
            hasTarget |= traverse_find_target(matrix, i, j + 1, target);
            if (hasTarget) return hasTarget;
        }
        return false;
    }
}
