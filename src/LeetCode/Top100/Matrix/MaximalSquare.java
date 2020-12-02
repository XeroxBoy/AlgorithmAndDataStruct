package LeetCode.Top100.Matrix;

public class MaximalSquare {
    static int maxSquare;
    static int m;
    static int n;

    public int maximalSquare(char[][] matrix) {
        maxSquare = 0;
        m = matrix.length;
        n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    maxSquare = Math.max(1, maxSquare);
                    traverse_find_max_square(matrix, i, j, 1);
                }
            }
        }
        return (int) Math.pow(maxSquare, 2);
    }

    private void traverse_find_max_square(char[][] matrix, int row, int col, int val) {
        if (col + val >= n || row + val >= m) return;
        if (isOneSquare(matrix, row, col, val)) {
            val += 1;
            maxSquare = Math.max(maxSquare, val);
            traverse_find_max_square(matrix, row, col, val);
        }
    }

    private boolean isOneSquare(char[][] matrix, int row, int col, int val) {
        int traverse_row = row + val;
        int traverse_col = col + val;
        for (int i = row; i <= traverse_row; i++) {
            if (matrix[i][traverse_col] != '1') return false;
        }
        for (int i = col; i <= traverse_col; i++) {
            if (matrix[traverse_row][i] != '1') return false;
        }
        return true;
    }
}
