package LeetCode.Easy.String;

public class FindTheDifference {
    public static void main(String[] args) {
        System.out.println(new FindTheDifference().
                findTheDifference("abc", "abcc"));
    }

    public char findTheDifference(String s, String t) {
        int[] si = new int[128];
        int[] ti = new int[128];
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        for (char oneChar : sCharArray
        ) {
            si[oneChar]++;
        }
        for (char oneChar : tCharArray
        ) {
            ti[oneChar]++;
        }
        for (int i = 0; i < t.length(); i++) {
            char oneChar = t.charAt(i);
            if (ti[oneChar] != si[oneChar]) return oneChar;
        }
        return 'a';
    }
}
