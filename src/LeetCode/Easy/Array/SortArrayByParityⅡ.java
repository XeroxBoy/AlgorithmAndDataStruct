package LeetCode.Easy.Array;

import java.util.Arrays;

public class SortArrayByParityⅡ {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 5, 7};
        Arrays.stream(new SortArrayByParityⅡ().sortArrayByParityII(arr)).forEach(System.out::println);
    }

    public int[] sortArrayByParityII(int[] A) {
        int evenPoint = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[evenPoint] % 2 == 1) {
                    evenPoint += 2;
                }
                swap(A, i, evenPoint);
            }
        }
        return A;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
