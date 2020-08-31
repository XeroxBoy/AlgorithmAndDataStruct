package LeetCode.Easy.String;

public class ReverseWordsⅡ {
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            StringBuilder s2 = new StringBuilder(s1[i]);
            sb.append(s2.reverse().toString());
            if (i != s1.length - 1)
                sb.append(" ");
        }
        return sb.toString();
    }
}
