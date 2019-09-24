package LeetCode.Easy;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello"));
    }

    public int lengthOfLastWord(String s) {
        if (s.trim().length() == 0) return 0;
        return s.split(" ")[s.split(" ").length - 1].length();

    }
}
