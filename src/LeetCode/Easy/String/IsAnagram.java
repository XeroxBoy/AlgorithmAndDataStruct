package LeetCode.Easy.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IsAnagram {


    public static void main(String[] args) {
        System.out.println(new IsAnagram().isAnagram("a", "ab"));
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> wordSMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> wordtMap = new HashMap<Character, Integer>();
        for (char sChar : s.toCharArray()
        ) {
            if (!wordSMap.containsKey(sChar)) {
                wordSMap.put(sChar, 1);
            } else {
                wordSMap.put(sChar, wordSMap.get(sChar) + 1);
            }
        }
        for (char tChar : t.toCharArray()) {
            if (!wordtMap.containsKey(tChar)) {
                wordtMap.put(tChar, 1);
            } else {
                wordtMap.put(tChar, wordtMap.get(tChar) + 1);
            }
        }
        if (wordSMap.size() != wordtMap.size()) return false;
        Set<Character> sCharacters = wordSMap.keySet();

        for (char oneChar : sCharacters) {
            int scount = wordSMap.getOrDefault(oneChar, -1);
            int tCount = wordtMap.getOrDefault(oneChar, -1);
            if (tCount == -1 || tCount != scount) return false;
        }
        return true;
    }

    public boolean isAnagram_1(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return String.valueOf(sChars).equals(String.valueOf(tChars));
    }

    public boolean isAnagram_2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                return false;
            } else if (count > 1) {
                map.put(ch, count - 1);
            } else {
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }

    public boolean isAnagram_3(String s, String t) {
        int[] sCounts = new int[26];
        int[] tCounts = new int[26];
        for (char ch : s.toCharArray()) {
            sCounts[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            tCounts[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCounts[i] != tCounts[i]) {
                return false;
            }
        }
        return true;
    }
}
