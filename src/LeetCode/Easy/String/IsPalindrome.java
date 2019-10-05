package LeetCode.Easy.String;

public class IsPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal:Panama";
        String a = "race a car";
        System.out.println(new IsPalindrome().isPalindrome(a));
    }

    public boolean isPalindrome(String s) {
        if (s.trim().length() == 0) return true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char eachChar = s.charAt(i);
            if (eachChar <= 'Z' && eachChar >= 'A') sb.append(Character.toLowerCase(eachChar));
            if (eachChar <= 'z' && eachChar >= 'a') sb.append(eachChar);
            if (eachChar <= '9' && eachChar >= '0') sb.append(eachChar);
        }
        String reverseString = sb.reverse().toString();
        String originString = sb.reverse().toString();
        System.out.println(reverseString + " " + originString);
        return reverseString.equals(originString);
    }
}
