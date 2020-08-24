package LeetCode.Medium.String;

public class Exist {
    int[][] direction = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) {
        char[][] chars = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        boolean result = new Exist().exist(chars, "ABCCED");
        System.out.println(result);
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != word.charAt(0)) continue;
                char temp = board[i][j];
                board[i][j] = '0';
                boolean result = dfs(board, i, j, word, 1);
                if (result) return true;
                board[i][j] = temp;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int nowLen) {
        if (nowLen == word.length()) return true;
        int m = board.length, n = board[0].length;
        for (int k = 0; k < 4; k++) {
            int row = i + direction[k][0];
            int col = j + direction[k][1];
            if (row < 0 || row >= m || col < 0 || col >= n) continue;
            if (board[row][col] == '0' || board[row][col] != word.charAt(nowLen)) continue;
            char temp = board[row][col];
            board[row][col] = '0';
            if (dfs(board, row, col, word, nowLen + 1)) return true;
            board[row][col] = temp;
        }
        return false;
    }
}
