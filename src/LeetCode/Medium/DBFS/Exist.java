package LeetCode.Medium.DBFS;

public class Exist {
    public static void main(String[] args) {
        System.out.println(
                new Exist().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
                        "ABCCED"));
        System.out.println(new Exist().exist(new char[][]{{'a', 'b'}},
                "ab"));
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        int m = board.length, n = board[0].length;
        int[][] visited = new int[m][n];
        int val = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                val += dfs("" + board[i][j], i, j, board, word, visited);
                if (val >= 1) return true;
            }
        }
        return false;
    }

    private int dfs(String nowStr, int i, int j, char[][] board, String word, int[][] visited) {
        if (!nowStr.equals(word.substring(0, nowStr.length())) || nowStr.length() > word.length())
            return 0;//substring开销大
        if (nowStr.equals(word)) return 1;
        int valNum = 0;
        visited[i][j] = 1;
        if (i + 1 < board.length && visited[i + 1][j] != 1) {
            valNum += dfs(nowStr + board[i + 1][j], i + 1, j, board, word, visited);
            if (valNum >= 1) return valNum;
        }
        if (j + 1 < board[i].length && visited[i][j + 1] != 1) {
            valNum += dfs(nowStr + board[i][j + 1], i, j + 1, board, word, visited);
            if (valNum >= 1) return valNum;
        }
        if (i - 1 >= 0 && visited[i - 1][j] != 1) {
            valNum += dfs(nowStr + board[i - 1][j], i - 1, j, board, word, visited);
            if (valNum >= 1) return valNum;
        }
        if (j - 1 >= 0 && visited[i][j - 1] != 1) {
            valNum += dfs(nowStr + board[i][j - 1], i, j - 1, board, word, visited);
            if (valNum >= 1) return valNum;
        }
        visited[i][j] = 0;
        return valNum;
    }

    class Solution {
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, words, i, j, 0)) return true;
                }
            }
            return false;
        }

        boolean dfs(char[][] board, char[] word, int i, int j, int k) {
            if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
            if (k == word.length - 1) return true;
            char tmp = board[i][j];
            board[i][j] = '/';
            boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                    dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
            board[i][j] = tmp;
            return res;
        }
    }


}
