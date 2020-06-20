package LeetCode.Top100.String;

import java.util.*;

public class LengthOfLongestSubstring {
    private Set<Character> set = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char oneChar = s.charAt(i);
            if (set.contains(oneChar)) {
                int setSize = set.size();
                maxLen = Math.max(maxLen, setSize);
                i -= setSize;
                set = new HashSet<>();
            } else {
                set.add(oneChar);
                int setSize = set.size();
                maxLen = Math.max(maxLen, setSize);
            }
        }
        return maxLen;
    }
    public int greatLengthOfLongestSubstring(String s) {
        //如果s为空，length不大于0，是一个空串，就没有向下执行的必要了
        if (s != null && s.length() > 0 && !s.equals("")) {
            //String -> char[]
            char[] strChar = s.toCharArray();
            // 存储最长字串 key:char值，value:index下标
            ArrayList<String> maxStr = new ArrayList<>();
            //临时的字串存储空间
            ArrayList<String> tempStr = new ArrayList<>();
            //循环
            for (char c : strChar) {
                //char -> String
                String str = new String(new char[]{c});
                //判断str是否存在于tempStr中
                if (tempStr.contains(str)) {
                    //先判断tempStr的长度是否大于等于maxStr的长度,大于，才能将最长字串覆盖
                    if (tempStr.size() > maxStr.size()) {
                        maxStr = new ArrayList<>(tempStr);
                    }
                    //存储重复字符
                    int reIndex = tempStr.indexOf(str);
                    // 删除tempStr中的重复字节及其之前的字符
                    if (reIndex >= 0) {
                        tempStr.subList(0, reIndex + 1).clear();
                    }
                }
                //将当前字符存入tempStr中
                tempStr.add(str);
            }
            //最终判断
            if (tempStr.size() > maxStr.size()) {
                maxStr = tempStr;
            }
            //返回最长字串的长度
            return maxStr.size();
        }
        return 0;
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> dic = new HashMap<>();
            int res = 0, tmp = 0;
            for (int j = 0; j < s.length(); j++) {
                int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
                dic.put(s.charAt(j), j); // 更新哈希表
                tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
                res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
            }
            return res;
        }
    }
}
