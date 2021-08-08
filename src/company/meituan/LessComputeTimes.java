package company.meituan;

import java.util.Scanner;

public class LessComputeTimes {
    /**
     * 小美给了小团一个长度为n（n为偶数）的序列A，序列中的数都是介于[1,100000]的整数。
     * 小团想把这个序列变得漂亮后再送回给小美。小美觉得一个序列是漂亮的当且仅当这个序列的前一半和后一半是一样的，即对于1<=i<=n/2都满足A[i]==A[i+n/2]。
     * <p>
     * 小团可以按进行以下操作任意次：
     * <p>
     * 选择两个介于[1, 100000]之间的数x和y，然后将序列A中所有值为x的数替换为y。
     * <p>
     * 注意，每次操作都会在上一次操作后得到的序列上进行。小团想知道他最少需要操作多少次可以把序列变成漂亮的。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int mostCommonPreDifferNum = array[0];
        int mostCommonBackDifferNum = array[n / 2];
        int mostCommonDifferNum = array[n / 2];
        int preSameNum = 0;
        int backSameNum = 0;
        boolean isSym = false;
        int times = 0;
        while (!isSym) {
            isSym = true;
            for (int i = 0; i < n / 2; i++) {
                if (array[i] != array[i + n / 2]) {
                    isSym = false;
                    if (mostCommonPreDifferNum == array[i]) {
                        preSameNum++;
                    } else if (mostCommonPreDifferNum != array[i]) {
                        preSameNum--;
                        if (preSameNum <= 0) {
                            mostCommonPreDifferNum = array[i];
                            preSameNum = 1;
                        }
                    }
                    if (mostCommonBackDifferNum == array[i + n / 2]) {
                        backSameNum++;
                    } else if (mostCommonBackDifferNum != array[i + n / 2]) {
                        backSameNum--;
                        if (backSameNum <= 0) {
                            mostCommonBackDifferNum = array[i + n / 2];
                            backSameNum = 1;
                        }
                    }
                }
            }
            if (!isSym) {
                if (preSameNum >= backSameNum) {
                    mostCommonDifferNum = mostCommonPreDifferNum;
                } else {
                    mostCommonDifferNum = mostCommonBackDifferNum;
                }
                replaceAllNumInArray(array, mostCommonDifferNum);
                times++;
            }
        }
        System.out.println(times);
    }

    private static void replaceAllNumInArray(int[] array, int mostCommonDifferNum) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            if (array[i] != array[i + n / 2]) {
                if (array[i] == mostCommonDifferNum || array[i + n / 2] == mostCommonDifferNum) {
                    array[i] = mostCommonDifferNum;
                    array[i + n / 2] = mostCommonDifferNum;
                }
            }
        }
    }

}
