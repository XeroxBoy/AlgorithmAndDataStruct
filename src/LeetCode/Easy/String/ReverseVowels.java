package LeetCode.Easy.String;

import java.util.Arrays;
import java.util.HashMap;

public class ReverseVowels {
    private HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new ReverseVowels().reverseVowels("aA"));
    }

    public String reverseVowels(String s) {
        int[] array = new int[s.length()];
        int point = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i'
                    || chars[i] == 'o' || chars[i] == 'u' || chars[i] == 'A' || chars[i] == 'E' || chars[i] == 'I'
                    || chars[i] == 'O' || chars[i] == 'U') {
                array[point++] = i;
            }
        }
        for (int i = 0; i < point / 2; i++) {
            char temp = chars[array[i]];
            chars[array[i]] = chars[array[point - i - 1]];
            chars[array[point - i - 1]] = temp;
        }
        return new String(chars);
    }
}
