package company.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class NandK {
    /**
     * 小美和小团在玩游戏。小美将会给出n个大小在1到n之间（包括1和n）的整数，然后小美会再告诉小团一个整数k，小团需要找到一个最小的整数x满足以下条件：
     * <p>
     * 整数x的大小在1到n之间（包括1和n）
     * <p>
     * 在小美给出的n个整数中，恰好有k个数严格比x小
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            Arrays.sort(nums);
            boolean hasSmaller = false;
            int smallNumber = 0;
            if (k == nums.length) {
                smallNumber = nums[k - 1];
                if (smallNumber < n) {
                    System.out.println("YES");
                    hasSmaller = true;
                } else {
                    System.out.println("NO");
                }
            } else if (k < nums.length) {
                if (k - 1 >= 0 && nums[k] > nums[k - 1]) {
                    smallNumber = nums[k - 1];
                    System.out.println("YES");
                    hasSmaller = true;
                } else if (k == 0) {
                    smallNumber = 0;
                    System.out.println("YES");
                    hasSmaller = true;
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
            if (hasSmaller) {
                System.out.println(smallNumber + 1);
            }
        }

    }
}
