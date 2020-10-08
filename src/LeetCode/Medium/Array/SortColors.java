package LeetCode.Medium.Array;

public class SortColors {
    public void sortColors(int[] nums) {
        int num0count = 0;
        int num1count = 0;
        int num2count = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    num0count++;
                    break;
                case 1:
                    num1count++;
                    break;
                case 2:
                    num2count++;
                    break;
            }
        }
        for (int i = 0; i < num0count; i++) {
            nums[i] = 0;
        }
        for (int i = num0count; i < num1count + num0count; i++) {
            nums[i] = 1;
        }
        for (int i = num0count + num1count; i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}
