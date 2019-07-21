package nowcoder;

public class multiplie {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) B[i] = 1;
        int n = A.length - 1;
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j<=n; j++) {
                if (j == i) continue;
                B[i] *= A[j];
            }
        }
        return B;
    }
}
