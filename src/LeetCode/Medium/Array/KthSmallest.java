package LeetCode.Medium.Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallest {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(new KthSmallest().kthSmallest(matrix, 8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int[] array = new int[matrix.length * matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                array[i * matrix[0].length + j] = matrix[i][j];
            }
        }
        Arrays.sort(array);
        return array[k - 1];
//        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                queue.offer(matrix[i][j]);
//                if (queue.size() > k) {
//                    queue.poll();
//                }
//            }
//        }
//        return queue.peek();
    }


}
