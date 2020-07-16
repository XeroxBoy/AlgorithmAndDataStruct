package LeetCode.Medium.DBFS;

public class MovingCount {
    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(2, 3, 1)
        );
        System.out.println(new MovingCount().movingCount(3, 1, 0));

    }

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int count = dfs(visited, m, n, 0, 0, k);


        return count;
    }

    private int dfs(boolean[][] visited, int m, int n, int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n) return 0;
        if (visited[i][j]) return 0;
        int val = 1;
        visited[i][j] = true;
        if (i + 1 < m && !visited[i + 1][j] && num_sum(i + 1) + num_sum(j) <= k) val += dfs(visited, m, n, i + 1, j, k);
        if (j + 1 < n && !visited[i][j + 1] && num_sum(i) + num_sum(j + 1) <= k) val += dfs(visited, m, n, i, j + 1, k);
        if (i - 1 >= 0 && !visited[i - 1][j] && num_sum(i - 1) + num_sum(j) <= k)
            val += dfs(visited, m, n, i - 1, j, k);
        if (j - 1 >= 0 && !visited[i][j - 1] && num_sum(i) + num_sum(j - 1) <= k)
            val += dfs(visited, m, n, i, j - 1, k);
        return val;
    }

    public int num_sum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
