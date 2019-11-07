package LeetCode.Easy.String;

public class ReverseString {
    public static void main(String[] args) {
        char[] chars = {'h', 'a', 'l', 'n', 'a', 'h'};
        new ReverseString().reverseString(chars);
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }

    }
}
