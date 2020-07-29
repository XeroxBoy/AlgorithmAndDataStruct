package LeetCode.Easy.String;

public class IsSubSequenceⅡ {
    public static void main(String[] args) {
        System.out.println(new IsSubSequenceⅡ().isSubsequence("axc", "ahbgdc"));
        System.out.println(new IsSubSequenceⅡ().isSubsequence("abc", "ahbgdc"));
        System.out.println(new IsSubSequenceⅡ().isSubsequence("acb", "ahbgdc"));
        System.out.println(new IsSubSequenceⅡ().isSubsequence("b", "c"));
        System.out.println(
                new IsSubSequenceⅡ().isSubsequence("bb", "ahbgdc")
        );
    }

    public boolean isSubsequence(String s, String t) {
//        if (s.length() == 1 && t.length() == 1) return s.equals(t);
        int t_index = 0;
        int s_index = 0;
        while (s_index < s.length() && t_index < t.length()) {
            char nowChar = s.charAt(s_index);
            boolean isMatch = false;
            while (t_index < t.length() && t.charAt(t_index++) != nowChar) ;
            if (t.charAt(t_index - 1) == nowChar) isMatch = true;
            if (isMatch)
                ++s_index;
        }
        return s_index == s.length();
    }
}
