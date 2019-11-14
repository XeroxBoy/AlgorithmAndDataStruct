package LeetCode.Easy.String;

import java.util.HashMap;
import java.util.Set;

public class CanConstruct {
    private HashMap<Character, Integer> ransomMap = new HashMap<>();
    private HashMap<Character, Integer> magazineMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new CanConstruct().canConstruct("aa", "aab"));
    }

    public boolean greatCanConstruct(String ransomNote, String magazine) {
        int[] is = new int[128];
        for (char c : magazine.toCharArray())
            is[c]++;
        for (char c : ransomNote.toCharArray())
            if (--is[c] < 0)
                return false;
        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        for (Character oneChar : ransomNote.toCharArray()
        ) {
            if (!ransomMap.containsKey(oneChar)) ransomMap.put(oneChar, 1);
            else {
                ransomMap.replace(oneChar, ransomMap.get(oneChar) + 1);
            }
        }
        for (Character oneChar : magazine.toCharArray()
        ) {
            if (!magazineMap.containsKey(oneChar)) magazineMap.put(oneChar, 1);
            else {
                magazineMap.replace(oneChar, magazineMap.get(oneChar) + 1);
            }
        }
        Set<Character> ransomChars = ransomMap.keySet();
        for (Character ransomChar : ransomChars
        ) {
            if (!magazineMap.containsKey(ransomChar) || magazineMap.get(ransomChar) < ransomMap.get(ransomChar)) {
                return false;
            }
        }
        return true;
    }
}
