package LeetCode.Easy.Array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FloodFill {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};
    private int oldColor;

    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        Arrays.stream(new FloodFill().floodFill(image, 1, 1, 2)).flatMapToInt(Arrays::stream)
                .forEach(System.out::println);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        oldColor = image[sr][sc];
        if (oldColor != newColor)
            floodColor(image, sr, sc, newColor);
        return image;
    }

    private void floodColor(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        if (image[sr][sc] != oldColor) return;
        image[sr][sc] = newColor;
        for (int i = 0; i < 4; i++) {
            int mx = sr + dx[i], my = sc + dy[i];
            if (mx >= 0 && mx < m && my >= 0 && my < n)
                floodColor(image, mx, my, newColor);
        }
    }
}
