package LeetCode.Easy;

public class MergeTwoSortArray {
    public static void main(String[] args) {
        int[] nums1 = {4, 0, 0, 0, 0, 0};
        int[] nums2 = {1, 2, 3, 5, 6};
        new MergeTwoSortArray().merge(nums1, 1, nums2, 5);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m > nums1.length || n > nums2.length) return;

        int s1ptr = 0;
        int s1backptr = n;
        int s2ptr = 0;
        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }
        while (s1backptr < m + n && s2ptr < n) {
            if (nums1[s1backptr] > nums2[s2ptr]) {
                nums1[s1ptr++] = nums2[s2ptr++];
            } else {
                nums1[s1ptr++] = nums1[s1backptr++];
            }
        }
        //s1内部有序
        while (s2ptr < n) {
            nums1[s1ptr++] = nums2[s2ptr++];
        }

        for (int i = 0; i < m + n; i++) {
            System.out.println(nums1[i]);
        }
    }
}
