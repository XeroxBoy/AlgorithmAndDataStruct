package LeetCode.Easy.Array;

public class Merge {
    public static void main(String[] args) {
        new Merge().merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public void perfect_merge(int[] A, int m, int[] B, int n) {
        int k = m + n - 1, i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] < B[j]) {
                A[k--] = B[j--];
            } else {
                A[k--] = A[i--];
            }
        }
        while (j >= 0) A[k--] = B[j--];
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int[] mirrorA = new int[A.length];
        if (m >= 0) System.arraycopy(A, 0, mirrorA, 0, m);
        int aPoint = 0;
        int bPoint = 0;
        int i = 0;
        while (aPoint < m && bPoint < n) {
            A[i] = Math.min(mirrorA[aPoint], B[bPoint]);
            if (mirrorA[aPoint] < B[bPoint]) aPoint++;
            else bPoint++;
            i++;
        }
        while (aPoint < m) {
            A[i++] = mirrorA[aPoint++];
        }
        while (bPoint < n) {
            A[i++] = B[bPoint++];
        }
    }
}
