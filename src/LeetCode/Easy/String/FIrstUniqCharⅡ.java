package LeetCode.Easy.String;

import java.util.HashSet;

public class FIrstUniqCharⅡ {
    public static void main(String[] args) {
        System.out.println(new FIrstUniqCharⅡ().firstUniqChar("abaccdeff"));
        System.out.println(new FIrstUniqCharⅡ().firstUniqChar(" "));

    }

    public char firstUniqChar(String s) {
        HashSet<Character> char_set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char one_char = s.charAt(i);
            if (char_set.contains(one_char)) continue;
            else {
                boolean hasSame = false;
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == one_char) {
                        hasSame = true;
                        break;
                    }
                }
                if (!hasSame) return one_char;
                char_set.add(one_char);
            }
        }
        return ' ';
    }
}
