package LeetCode.Easy.Trick;

import dataStructure.VersionControl;

public class FirstBadVersion extends VersionControl {
    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(2));
    }

    public int firstBadVersion(int n) {
        int high = n;
        int low = 0;
        int mid;
        while (high > low) {
            mid = low + (high - low) / 2;
            if (isBadVersion((mid))) high = mid;
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}
