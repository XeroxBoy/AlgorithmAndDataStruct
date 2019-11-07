package LeetCode.Easy.Array;

import java.util.Arrays;
import java.util.HashMap;

public class Intersect {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] result = new Intersect().intersection(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = Math.min(nums1.length, nums2.length);
        int[] intersects = new int[length];
        int point = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i]))
                map.put(nums1[i], 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                intersects[point++] = nums2[i];
                map.remove(nums2[i]);
            }
        }
        return Arrays.copyOfRange(intersects, 0, point);
    }
}
