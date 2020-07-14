package LeetCode.Easy.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectⅡ {
    public static void main(String[] args) {
        Arrays.stream(new IntersectⅡ().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})).forEach(System.out::println);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int s1point = 0;
        int s2point = 0;
        while (s1point < m && s2point < n) {
            if (nums1[s1point] < nums2[s2point]) {
                s1point++;
                continue;
            } else if (nums2[s2point] < nums1[s1point]) {
                s2point++;
                continue;
            } else {
                while (s1point < m && s2point < n && nums1[s1point] == nums2[s2point]) {
                    list.add(nums1[s1point]);
                    s1point++;
                    s2point++;
                }
            }
        }
        int[] results = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            results[i] = list.get(i);
        }
        return results;
    }
}
