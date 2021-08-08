package company.baidu;


import java.util.HashMap;
import java.util.HashSet;

public class MaxNotReaptedSubStr {
    static int maxLen = 0;

    public static String maxNotReaptedSubStr(String str1) {
        if (str1.length() == 0 || str1 == null) return null;
        maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int nowLen = 0;
        int maxStartIndex = 0;
        int windowStarter = 0;
        for (int i = 0; i < str1.length(); i++) {
            char oneChar = str1.charAt(i);
            if (map.containsKey(oneChar)) {
                nowLen = 0;
                windowStarter = map.get(oneChar) + 1;
                i = map.get(oneChar);
                map = new HashMap<>();
            } else {
                map.put(oneChar, i);
                nowLen += 1;
                if (nowLen > maxLen) {
                    maxStartIndex = windowStarter;
                    maxLen = nowLen;
                }
            }
        }
        return str1.substring(maxStartIndex, maxStartIndex + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(MaxNotReaptedSubStr.maxNotReaptedSubStr("abcabaaa"));
    }
}
