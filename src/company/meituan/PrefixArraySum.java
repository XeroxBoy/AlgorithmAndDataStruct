package company.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class PrefixArraySum {
    /**
     * 小美有一个长度为n的序列A，A[i]表示序列中第i个数(1<=i<=n)。她定义序列中第i个数的prev[i]值为前i-1个数中比A[i]小的最
     * 大的值，即满足1<=j<i且A[j]<A[i]中最大的A[j]，若不存在这样的数，则prev[i]的值为0。现在
     * 她想要你帮忙计算对于所有的i，prev[i]*i之和是多少，即Σprev[i]*i (1<=i<=n，A[1]为序列第1个数)。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }
        int[] prev = new int[n];
        int[] sortedPrefix = new int[n];
        Arrays.fill(sortedPrefix, Integer.MAX_VALUE);
        sortedPrefix[0] = A[0];
        int sum = 0;
        for (int i = 1; i < n; i++) {
            int nowNum = A[i];
            Arrays.sort(sortedPrefix);
            boolean hasSmaller = false;
            if (nowNum == A[i - 1]) {
                prev[i] = prev[i - 1];
                hasSmaller = true;
            } else if (nowNum < A[i - 1]) {
                if (nowNum > prev[i - 1]) {
                    prev[i] = prev[i - 1];
                    hasSmaller = true;
                }
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if (sortedPrefix[j] < nowNum) {
                        hasSmaller = true;
                        prev[i] = sortedPrefix[j];
                        break;
                    }
                }
            }
            if (hasSmaller)
                sum += prev[i] * (i + 1);
            sortedPrefix[i] = A[i];
        }
        System.out.println(sum);
    }

    private static void swap(int[] a, int i, int i1) {
        int temp = a[i];
        a[i] = a[i1];
        a[i1] = temp;
    }
}
