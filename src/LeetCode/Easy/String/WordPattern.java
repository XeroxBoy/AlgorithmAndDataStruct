package LeetCode.Easy.String;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * 不要用static变量跑leetcode
 * 对应关系是双向的 应同时check key和value是否重复
 * */
public class WordPattern {
    private ConcurrentHashMap<Character, String> wordMap = new ConcurrentHashMap();

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abc", "b c a"));
    }

    public boolean wordPattern(String pattern, String str) {
        String[] splitString = str.split(" ");
        if (splitString.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char patternChar = pattern.charAt(i);
            if (!wordMap.containsKey(patternChar)) {
                if (wordMap.containsValue(splitString[i])) return false;
                wordMap.put(patternChar, splitString[i]);
            } else {
                if (!wordMap.get(patternChar).equals(splitString[i])) return false;
            }
        }
        return true;
    }
}
