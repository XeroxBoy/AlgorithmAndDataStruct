package LeetCode.Easy.String;

import java.util.*;
import java.util.stream.Collectors;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
    }

    public int longestPalindrome(String s) {
        int pathLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else map.put(s.charAt(i), 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                pathLen += entry.getValue() - 1;
            } else if (entry.getValue() % 2 == 0) pathLen += entry.getValue();
        }
        return pathLen < s.length() ? pathLen + 1 : pathLen;
    }

    class Solution {
        public int longestPalindrome(String s) {
            Map<Integer, Integer> count = s.chars().boxed()
                    .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
            int ans = count.values().stream().mapToInt(i -> i - (i & 1)).sum();
            return ans < s.length() ? ans + 1 : ans;
        }

        public int GreatlongestPalindrome(String s) {
            int[] cnt = new int[58];
            for (char c : s.toCharArray()) {
                cnt[c - 'A'] += 1;
            }

            int ans = 0;
            for (int x : cnt) {
                // 字符出现的次数最多用偶数次。
                ans += x - (x & 1);
            }
            // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
            return ans < s.length() ? ans + 1 : ans;
        }
    }
}
