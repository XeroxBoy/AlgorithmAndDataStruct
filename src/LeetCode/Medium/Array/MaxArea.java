package LeetCode.Medium.Array;

public class MaxArea {
    public static void main(String[] args) {
        int[] area = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new MaxArea().maxArea(area));
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int left = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int right = height[j];
                int bottom = j - i;
                int top = Math.min(left, right);
                maxArea = Math.max(top * bottom, maxArea);
            }
        }
        return maxArea;
    }

    public int greatMaxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int area = (right - left) * (Math.min(height[left], height[right]));
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]) {
                left++; //改变left 而不是为了递增
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return maxArea;
    }
}
