package LeetCode.Easy.Array;

import java.util.Arrays;

public class ConstructArr {
    public static void main(String[] args) {
        Arrays.stream(new ConstructArr().constructArr(new int[]{1, 2, 3, 4, 5})).forEach(System.out::println);
    }

    public int[] constructArr(int[] a) {
        int n = a.length;
        if (n == 0) return new int[0];
        int beforeCon = 1;
        int[] results = new int[n];
        int[] backCon = new int[n];
        backCon[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            backCon[i] = backCon[i + 1] * a[i];
        }
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                results[i] += beforeCon;
                beforeCon = beforeCon * a[i];
            } else {
                results[i] += 1;
                beforeCon = a[i];
            }
            if (i != n - 1) results[i] *= backCon[i + 1];
        }
        return results;
    }
}
