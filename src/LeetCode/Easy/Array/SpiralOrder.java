package LeetCode.Easy.Array;

public class SpiralOrder {
    public static void main(String[] args) {
        int[] nums = new SpiralOrder().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[]{};
        int n = matrix.length, m = matrix[0].length;
        int len = m * n;
        int[] results = new int[len];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < m - i; j++) {
                results[index++] = matrix[i][j];
            }
            if (index >= len) break;

            for (int j = i + 1; j < n - i; j++) {
                results[index++] = matrix[j][m - i - 1];
            }
            if (index >= len) break;

            for (int j = m - i - 2; j >= i; j--) {
                results[index++] = matrix[n - i - 1][j];
            }
            if (index >= len) break;

            for (int j = n - i - 2; j > i; j--) {
                results[index++] = matrix[j][i];
            }
            if (index >= len) break;

        }
        return results;
    }
}
