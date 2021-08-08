package company.shoppe;

import java.util.*;

public class healthrobot {

    public static int maxHealth = Integer.MAX_VALUE;


    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * @param rooms      int整型二维数组 房间
     * @param startPoint int整型一维数组 起始点
     * @param endPoint   int整型一维数组 终点
     * @return int整型
     */
    public int minimumInitHealth(int[][] rooms, int[] startPoint, int[] endPoint) {
        // write code here
        if (rooms.length <= 0) return 0;
        int startX = startPoint[0];
        int startY = startPoint[1];
        int endX = endPoint[0];
        int endY = endPoint[1];
        maxHealth = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        ArrayList<Integer> path = new ArrayList<>();
        path.add(rooms[startX][startY]);
        dfs(rooms, startX, startY, endX, endY, path, visited);
        return maxHealth;
    }


    private void dfs(int[][] rooms, int startX, int startY, int endX, int endY, ArrayList<Integer> path, boolean[][] visited) {
        visited[startX][startY] = true;

        if (startX == endX && startY == endY) {
            int shortest = 1;
            for (int i = 0; i < path.size(); i++) {
                if (path.get(i) < 0) {
                    shortest = Math.max(Math.abs(path.get(i)), shortest);
                }
            }
            maxHealth = Math.min(maxHealth, shortest);
            return;
        }
        if (startX + 1 < rooms[0].length && !visited[startX + 1][startY]) {
            int nextHealth = path.get(path.size() - 1) + rooms[startX + 1][startY];
            if (nextHealth < 0 && Math.abs(nextHealth) > maxHealth) return;
            path.add(nextHealth);
            dfs(rooms, startX + 1, startY, endX, endY, path, visited);
        }
        if (startX - 1 >= 0 && !visited[startX - 1][startY]) {
            int nextHealth = path.get(path.size() - 1) + rooms[startX - 1][startY];
            if (nextHealth < 0 && Math.abs(nextHealth) > maxHealth) return;
            path.add(nextHealth);
            dfs(rooms, startX - 1, startY, endX, endY, path, visited);
        }
        if (startY + 1 < rooms.length && !visited[startX][startY + 1]) {
            int nextHealth = path.get(path.size() - 1) + rooms[startX][startY + 1];
            if (nextHealth < 0 && Math.abs(nextHealth) > maxHealth) return;
            path.add(nextHealth);
            dfs(rooms, startX, startY + 1, endX, endY, path, visited);
        }
        if (startY - 1 >= 0 && !visited[startX][startY - 1]) {
            int nextHealth = path.get(path.size() - 1) + rooms[startX][startY - 1];
            if (nextHealth < 0 && Math.abs(nextHealth) > maxHealth) return;
            path.add(nextHealth);
            dfs(rooms, startX, startY - 1, endX, endY, path, visited);
        }
        return;
    }

    public static void main(String[] args) {

        int[][] rooms = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int[] startPoint = {0, 0};
        int[] endPoint = {2, 2};
        System.out.println(
                new healthrobot().minimumInitHealth(rooms, startPoint, endPoint)
        );
    }

}
