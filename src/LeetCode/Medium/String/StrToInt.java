package LeetCode.Medium.String;

public class StrToInt {
    public static void main(String[] args) {
//        System.out.println(new StrToInt().strToInt("   -132147483648"));
//        System.out.println(new StrToInt().strToInt("   4193 with words"));
//        System.out.println(new StrToInt().strToInt("   words and 987"));
//        System.out.println(new StrToInt().strToInt("   -132147483648"));
//        System.out.println(new StrToInt().strToInt("-91283472332"));
//        System.out.println(new StrToInt().strToInt("3.14159"));
//        System.out.println(new StrToInt().strToInt("  -0012a42"));
//        System.out.println(new StrToInt().strToInt("  -2147483647"));
//        System.out.println(new StrToInt().strToInt("  -1010023630o4"));
//        System.out.println(new StrToInt().strToInt("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459"));
        System.out.println(new StrToInt().strToInt("20000000000000000000"));
        System.out.println(new StrToInt().strToInt("9223372036854775807"));
    }

    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (c[0] == '-') sign = -1;
        else if (c[0] != '+') i = 0;
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') break;
            if (res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }
}
