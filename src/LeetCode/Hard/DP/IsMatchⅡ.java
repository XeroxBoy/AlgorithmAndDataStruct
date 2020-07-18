package LeetCode.Hard.DP;

public class IsMatchⅡ {
    public static void main(String[] args) {
        System.out.println(new IsMatchⅡ().isMatch("aa", "a"));
        System.out.println(new IsMatchⅡ().isMatch("aa", "a*"));
        System.out.println(new IsMatchⅡ().isMatch("ab", ".*"));
        System.out.println(new IsMatchⅡ().isMatch("aab", "c*a*b"));
        System.out.println(new IsMatchⅡ().isMatch("aab", "c*a*b"));
        System.out.println(new IsMatchⅡ().isMatch("mississippi",
                "mis*is*p*."));
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0) { //空正则
                    dp[i][j] = i == 0;
                } else {
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && p.charAt(j - 1) == '.')
                            dp[i][j] = dp[i - 1][j - 1];
                        if (i > 0 && s.charAt(i - 1) == p.charAt(j - 1))
                            dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        if (j - 2 >= 0)
                            dp[i][j] |= dp[i][j - 2];
                        if (i >= 1 && j >= 2 && s.charAt(i - 1) == p.charAt(j - 2))//不止0个，能匹配，让*抵掉s中字符
                            dp[i][j] |= dp[i - 1][j];
                        if (i >= 1 && j >= 2 && p.charAt(j - 2) == '.') //不止0个，能匹配，让*抵掉s中字符
                            dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][m];
    }

    class Solution {
        public boolean isMatch(String A, String B) {
            // 如果字符串长度为0，需要检测下正则串
            if (A.length() == 0) {
                // 如果正则串长度为奇数，必定不匹配，比如 "."、"ab*",必须是 a*b*这种形式，*在奇数位上
                if (B.length() % 2 != 0) return false;
                int i = 1;
                while (i < B.length()) {
                    if (B.charAt(i) != '*') return false;
                    i += 2;
                }
                return true;
            }
            // 如果字符串长度不为0，但是正则串没了，return false
            if (B.length() == 0) return false;
            // c1 和 c2 分别是两个串的当前位，c3是正则串当前位的后一位，如果存在的话，就更新一下
            char c1 = A.charAt(0), c2 = B.charAt(0), c3 = 'a';
            if (B.length() > 1) {
                c3 = B.charAt(1);
            }
            // 和dp一样，后一位分为是 '*' 和不是 '*' 两种情况
            if (c3 != '*') {
                // 如果该位字符一样，或是正则串该位是 '.',也就是能匹配任意字符，就可以往后走
                if (c1 == c2 || c2 == '.') {
                    return isMatch(A.substring(1), B.substring(1));
                } else {
                    // 否则不匹配
                    return false;
                }
            } else {
                // 如果该位字符一样，或是正则串该位是 '.'，和dp一样，有看和不看两种情况
                if (c1 == c2 || c2 == '.') {
                    return isMatch(A.substring(1), B) || isMatch(A, B.substring(2));
                } else {
                    // 不一样，那么正则串这两位就废了，直接往后走
                    return isMatch(A, B.substring(2));
                }
            }
        }
    }

}
