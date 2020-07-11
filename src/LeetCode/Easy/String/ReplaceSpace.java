package LeetCode.Easy.String;

public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char oneChar = s.charAt(i);
            if (oneChar == ' ') sb.append("%20");
            else sb.append(oneChar);
        }
        return sb.toString();
    }
}
