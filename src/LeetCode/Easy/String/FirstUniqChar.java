package LeetCode.Easy.String;

public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        int[] ci = new int[128];
        char[] charArray = s.toCharArray();
        for (char oneChar : charArray
        ) {
            ci[oneChar]++;
        }
        for (int i = 0; i < s.length(); i++
        ) {
            char oneChar = s.charAt(i);
            if (ci[oneChar] == 1) return i;
        }
        return -1;
    }
}
