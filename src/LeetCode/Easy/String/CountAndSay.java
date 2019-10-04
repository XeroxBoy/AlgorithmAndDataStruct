package LeetCode.Easy.String;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(6));
    }

    public String countAndSay(int n) {
        StringBuilder originStr = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            StringBuilder newStr = new StringBuilder();
            char[] chars = originStr.toString().toCharArray();
            int count = 1;
            for (int j = 0; j < chars.length; j++) {
                while (j + 1 < chars.length - 1 && chars[j] == chars[j + 1]) {
                    count++;
                    j++;
                }
                if (j == chars.length - 1) {
                    if (j == 0) {
                        newStr.append(count);
                        newStr.append(chars[j]);
                        break;
                    }
                    if (chars[j] == chars[j - 1]) {
                        count++;
                        newStr.append(count);
                        newStr.append(chars[j]);
                    } else {
                        newStr.append(1);
                        newStr.append(chars[j]);
                    }
                } else {
                    if (chars[j] == chars[j + 1]) {
                        count++;
                        j++;
                    }
                    newStr.append(count);
                    newStr.append(chars[j]);
                    count = 1;
                }
            }
            originStr = newStr;
        }
        return originStr.toString();
    }

    public String greatCountAndSay(int n) {
        if (n == 1) return "1";
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            StringBuffer sb = new StringBuffer();
            char t = s.charAt(0);
            int count = 0;
            int j = 0;
            for (j = 0; j < s.length(); j++) {
                if (t != s.charAt(j)) {
                    sb.append(count);
                    sb.append(t);
                    t = s.charAt(j);
                    count = 1;
                } else {
                    count++;
                }

            }
            sb.append(count);
            sb.append(s.charAt(s.length() - 1));
            s = sb.toString();


        }

        return s;
    }
}
