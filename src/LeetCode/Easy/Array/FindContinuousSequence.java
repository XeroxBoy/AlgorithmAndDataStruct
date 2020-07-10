package LeetCode.Easy.Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FindContinuousSequence {
    public static void main(String[] args) {
        Arrays.stream(new FindContinuousSequence().findContinuousSequence(9)).forEach(System.out::println);
    }

    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> seqs = new ArrayList<>();
        int i = 1;
        int j = i;
        int sum = 0;
        while (i <= target / 2) {
            if (sum < target) {
                sum += j++;
            } else if (sum == target) {
                int[] list = new int[j - i];
                for (int k = 0; k < j - i; k++) {
                    list[k] = i + k;
                }
                seqs.add(list);
                sum -= i++;
                i++;
            } else {
                sum -= i++;
            }
        }
        return seqs.toArray(new int[seqs.size()][]);
    }
}
