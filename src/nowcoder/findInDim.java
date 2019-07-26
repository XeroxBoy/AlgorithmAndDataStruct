package nowcoder;

import jdk.nashorn.internal.runtime.FindProperty;

public class findInDim {
    public static boolean Find(int target, int[][] array) {
        if (array.length == 0) return false;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length == 0) return false;
        }
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < array[0].length; i++) {
            if (array[0][i] == target) return true;
            if (startIndex == 0) {
                if (array[0][i] < target && array[array.length - 1][i] >= target) startIndex = i;
            }
            if (endIndex == 0 && startIndex != 0) {
                if (array[0][i] > target || array[array.length - 1][i] < target) endIndex = i - 1;
            }
        }
        if (endIndex == 0 && startIndex > 0) endIndex = array[0].length - 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = startIndex; j <= endIndex; j++) {
                if (array[i][j] == target) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[5][5];
        array[0] = new int[]{1, 3, 5, 7, 8};
        array[1] = new int[]{4, 5, 6, 8, 11};
        array[2] = new int[]{6, 7, 8, 13, 14};
        array[3] = new int[]{9, 10, 15, 16, 20};
        array[4] = new int[]{11, 15, 18, 20, 25};
        boolean find = Find(18, array);
        System.out.println(find);
    }
}
