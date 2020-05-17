package LeetCode.Hard.Math;

public class Trap {
    public static void main(String[] args) {
//        System.out.println(new Trap().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new Trap().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new Trap().trap(new int[]{2, 0, 2}));
        System.out.println(new Trap().trap(new int[]{4, 2, 3}));
        System.out.println(new Trap().trap(new int[]{5, 4, 1, 2}));
        System.out.println(new Trap().trap(new int[]{0, 7, 1, 4, 6}));
        System.out.println(new Trap().trap(new int[]{2, 8, 5, 5, 6, 1, 7, 4, 5}));
    }

    public int trap(int[] height) {
        int capacity = 0;
        for (int i = 0; i < height.length; i++) {
            if (i + 1 < height.length && height[i] < height[i + 1]) continue;
            int lastLeft = i;
            int lastRight = i;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] >= height[lastLeft]) {
                    lastRight = j;
                    break;
                }
                while (j == height.length - 1) {
                    for (int k = lastLeft + 1; k < height.length; k++) {
                        if (height[k] > height[k - 1]) {
                            int nextIndex = k;
                            int tempMax = height[k];
                            int tempMaxIndex = k;
                            while (nextIndex <= height.length - 1) {
                                if (height[nextIndex] > tempMax) {
                                    tempMaxIndex = nextIndex;
                                    tempMax = height[nextIndex];
                                }
                                nextIndex++;
                            }
//                            if (k < height.length - 1 && height[k + 1] > height[k]) k++;
                            lastRight = tempMaxIndex;
                            break;
                        }
                    }
                    int lower_in_high = Math.min(height[lastLeft], height[lastRight]);
                    for (int k = lastLeft + 1; k < lastRight; k++) {
                        if (lower_in_high > height[k])
                            capacity += lower_in_high - height[k];
                    }
                    lastLeft = lastRight;
                    lastRight++;
                    if (lastRight >= j)
                        return capacity;
                }
            }
            int lower_in_high = Math.min(height[lastLeft], height[lastRight]);
            for (int j = lastLeft + 1; j < lastRight; j++) {
                capacity += lower_in_high - height[j];
            }
            if (lastLeft < lastRight)
                i = lastRight - 1;
        }
//        return Math.abs(capacity);
        return capacity;
    }
}
