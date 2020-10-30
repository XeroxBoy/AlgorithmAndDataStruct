package LeetCode.Medium.List;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {
    static LinkedList<String> list;

    public static void main(String[] args) {
        new LetterCombinations().letterCombinations("2357774353252364364374743").forEach(System.out::println);
        new LetterCombinations().letterCombinations("7").forEach(System.out::println);
        new LetterCombinations().letterCombinations("8").forEach(System.out::println);
        new LetterCombinations().letterCombinations("9").forEach(System.out::println);
    }

    public List<String> letterCombinations(String digits) {
        list = new LinkedList<>();
        if (digits.equals("")) return list;
        traverseFindLetter(digits, 0, new StringBuilder());
        return list;
    }

    private void traverseFindLetter(String digits, int index, StringBuilder nowStr) {
        if (index == digits.length()) {
            String nowString = nowStr.toString();
            if (!list.contains(nowString))
                list.add(nowString);
            return;
        }
        int charNum = digits.charAt(index) - '0';
        if (digits.charAt(index) == '1') return;
        if (charNum <= 7) {
            traverseFindLetter(digits, index + 1, new StringBuilder(nowStr).append((char) ('a' + ((charNum - 2) * 3))));
            traverseFindLetter(digits, index + 1, new StringBuilder(nowStr).append((char) ('a' + ((charNum - 2) * 3 + 1))));
            traverseFindLetter(digits, index + 1, new StringBuilder(nowStr).append((char) ('a' + ((charNum - 2) * 3 + 2))));
        }
        if (charNum == 7) {
            traverseFindLetter(digits, index + 1, new StringBuilder(nowStr).append((char) ('a' + ((charNum - 1) * 3))));
        }
        if (charNum == 8) {
            traverseFindLetter(digits, index + 1, new StringBuilder(nowStr).append('t'));
            traverseFindLetter(digits, index + 1, new StringBuilder(nowStr).append('u'));
            traverseFindLetter(digits, index + 1, new StringBuilder(nowStr).append('v'));
        }
        if (charNum == 9) {
            traverseFindLetter(digits, index + 1, new StringBuilder(nowStr).append('w'));
            traverseFindLetter(digits, index + 1, new StringBuilder(nowStr).append('x'));
            traverseFindLetter(digits, index + 1, new StringBuilder(nowStr).append('y'));
            traverseFindLetter(digits, index + 1, new StringBuilder(nowStr).append('z'));
        }
    }
}
