package LeetCode.Easy.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers {
    public static void main(String[] args) {
//        System.out.println(new FindDisappearedNumbers().findDisappearedNumbers(new int[]{5,4,6,7,9,3,10,9,5,6}));
        System.out.println(new FindDisappearedNumbers().greatFindDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        if (nums[0] != 1) {
            list.add(1);
            int sub = nums[0] - 1;
            int addNum = 1;
            while (sub > 1) {
                list.add(1 + addNum);
                addNum++;
                sub--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            if (i != nums.length - 1 && nums[i + 1] - nums[i] > 1) {
                int sub = nums[i + 1] - nums[i];
                int addNum = 1;
                while (sub > 1) {
                    list.add(nums[i] + addNum);
                    addNum++;
                    sub--;
                }
            }
        }
        if (nums[nums.length - 1] != nums.length) {
            int sub = nums.length - nums[nums.length - 1];
            int addNum = 1;
            while (sub >= 1) {
                list.add(nums[nums.length - 1] + addNum);
                addNum++;
                sub--;
            }
        }
        return list;
    }

    public List<Integer> greatFindDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) list.add(i + 1);
        }
        return list;
    }
}
