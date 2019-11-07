package LeetCode.Easy.Trick;

import java.util.ArrayList;
import java.util.Arrays;

public class CanWinNim {
    public static void main(String[] args) {
        System.out.println(new CanWinNim().canWinNim(5));
    }

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public boolean tuidaoCanWin(int n) {
        Boolean[] dp = new Boolean[n + 1];
        Arrays.fill(dp, false);
        dp[1] = true;
        dp[2] = true;
        dp[3] = true;
        for (int i = 4; i < n + 1; i++) {
            boolean a = !dp[i - 1];
            boolean b = !dp[i - 2];
            boolean c = !dp[i - 3];
            dp[i] = dp[i] || a || b || c;
        }
        return dp[n];
    }
}
