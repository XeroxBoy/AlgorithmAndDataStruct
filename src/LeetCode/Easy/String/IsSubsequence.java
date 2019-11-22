package LeetCode.Easy.String;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(new IsSubsequence().
                isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        if (sChars.length == 0) return true;
        char[] tChars = t.toCharArray();
        int sIndex = 0;
        for (int i = 0; i < tChars.length; i++) {
            if (sChars[sIndex] == tChars[i]) {
                sIndex++;
                if (sIndex == sChars.length) return true;
                continue;
            }
        }
        return false;
    }
}
