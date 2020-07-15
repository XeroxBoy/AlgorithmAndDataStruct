package LeetCode.Medium.MutilThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class boom {
    public static void main(String[] args) {
        List<pangzi> list = new ArrayList<>();
        while (true) {
            pangzi pangzi = new pangzi();
            Arrays.fill(pangzi.arr, Integer.MAX_VALUE);
            list.add(pangzi);
        }
    }

    static class pangzi {
        Integer[] arr = new Integer[(int) Math.pow(2, 30)];
    }
}
