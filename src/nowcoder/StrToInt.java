package nowcoder;

public class StrToInt {
    public static int StrToInt(String str) {
        if (str.equals("0") || str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        int i = 0;
        int intValue = 0;
        if (chars[0] == '+' || chars[0] == '-') i = 1;
        for (; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') return 0;
            int charValue = chars[i] - '0';
            if (i == chars.length - 1) {
                intValue += charValue;
                break;
            }
            intValue += Math.pow(10, chars.length - i - 1) * charValue;
        }
        if (chars[0] == '-') return 0 - intValue;
        return intValue;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt.StrToInt("1a33"));
    }
}
