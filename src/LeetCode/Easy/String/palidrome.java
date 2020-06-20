package LeetCode.Easy.String;

public class palidrome {
    public static void main(String[] args) {
        System.out.println(new palidrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new palidrome().isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char oneChar = s.charAt(i);
            if (Character.isDigit(oneChar) || Character.isLetter(oneChar)) {
                sb.append(oneChar);
            }
        }
        String coped_str = sb.toString().toLowerCase();
        int size = coped_str.length();
        boolean isPalin = true;
        for (int i = 0; i < coped_str.length(); i++) {
            if (i > size / 2) break;
            if (coped_str.charAt(i) != coped_str.charAt(size - i - 1)) {
                isPalin = false;
                break;
            }
        }
        return isPalin;
    }
}
