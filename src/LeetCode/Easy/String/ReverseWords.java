package LeetCode.Easy.String;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

public class ReverseWords {
    public static void main(String[] args) {

        System.out.println(new ReverseWords().reverseWords("the sky is blue"));
        System.out.println(new ReverseWords().reverseWords("a good   example"));
        System.out.println(new ReverseWords().reverseWords("  hello world! "));
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] split_s = s.split(" ");
        int len = split_s.length - 1;
        for (int i = 0; i <= len / 2; i++) {
            String temp = split_s[i];
            split_s[i] = split_s[len - i];
            split_s[len - i] = temp;
        }
        StringBuilder results = new StringBuilder();
        for (int i = 0; i <= len; i++) {
            if (split_s[i].length() == 0 || split_s[i].equals(" ") || split_s[i].contains(" ")) {
                continue;
            }
            results.append(split_s[i]);
            if (i == len) break;
            results.append(" ");
        }
        return results.toString();
    }
}
