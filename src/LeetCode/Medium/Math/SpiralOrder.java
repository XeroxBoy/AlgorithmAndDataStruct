package LeetCode.Medium.Math;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new SpiralOrder().spiralOrder(matrix).forEach(System.out::println);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        int totalNum = matrix.length * matrix[0].length;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int rowPoint = 0;
        int colPoint = 0;
        int counter = 0;
        while (counter < totalNum) {
            for (int i = 0; i < direction.length; i++) {
                while (rowPoint >= 0 && colPoint >= 0 && rowPoint < matrix.length && colPoint < matrix[rowPoint].length) {
                    if (!visited[rowPoint][colPoint] && counter < totalNum) {
                        result.add(matrix[rowPoint][colPoint]);
                        counter++;
                        visited[rowPoint][colPoint] = true;
                    }
                    if (counter == totalNum) break;
                    if (rowPoint + direction[i][1] >= 0 && rowPoint + direction[i][1] < matrix.length && colPoint + direction[i][0] >= 0 &&
                            colPoint + direction[i][0] < matrix[rowPoint].length && !visited[rowPoint + direction[i][1]][colPoint + direction[i][0]]) {
                        colPoint += direction[i][0];
                        rowPoint += direction[i][1];
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
