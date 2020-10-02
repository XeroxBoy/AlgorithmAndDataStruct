package LeetCode.Easy.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class NumJewelsInStones {
    public static void main(String[] args) {
        System.out.println(new NumJewelsInStones().numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(new NumJewelsInStones().numJewelsInStones("z", "ZZ"));

    }

    public int numJewelsInStones(String J, String S) {
//        return (int) S.chars().mapToObj(ch -> (char) ch).filter(data -> J.contains("" + data)).count();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            result += set.contains(S.charAt(i)) ? 1 : 0;
        }
        return result;
    }
}
