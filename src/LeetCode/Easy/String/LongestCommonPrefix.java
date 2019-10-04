package LeetCode.Easy.String;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arg = {"a", "ac"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(arg));
    }

    public String longestCommonPrefix(String[] strs) {
        boolean flag = true;
        if (strs.length == 1) return strs[0];
        if (strs.length < 1) return "";
        int indexFlag = 0;
        StringBuilder prefix = new StringBuilder();
        while (flag) {
            int length = strs[0].length();
            String str = strs[0].substring(indexFlag);
            if (str.length() == 0 || indexFlag == length) return prefix.toString();
            char indexChar = strs[0].charAt(indexFlag++);
            for (int i = 1; i < strs.length; i++) {
                int compareLength = strs[i].length();
                String compareStr = strs[i].substring(indexFlag - 1);
                if (indexFlag - 1 == compareLength) return prefix.toString();
                if (compareStr.indexOf(indexChar) != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                prefix.append(indexChar);
        }
        return prefix.toString();
    }
}
