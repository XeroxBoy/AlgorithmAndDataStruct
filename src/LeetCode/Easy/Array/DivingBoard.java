package LeetCode.Easy.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DivingBoard {
    public static void main(String[] args) {
        Arrays.stream(new DivingBoard().divingBoard(1, 2, 3)).forEach(System.out::println);
        Arrays.stream(new DivingBoard().divingBoard(1, 1, 0)).forEach(System.out::println);
        Arrays.stream(new DivingBoard().divingBoard(9, 8436, 28489)).forEach(System.out::println);
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        int[] results = new int[k + 1];
        if (k == 0) return new int[0];
        if (shorter == longer) return new int[]{longer * k};
        for (int i = 0; i <= k; i++) {
            int result = i * longer + (k - i) * shorter;
            results[i] = result;
        }
        return results;
    }
}
