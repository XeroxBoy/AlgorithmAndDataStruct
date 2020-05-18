package LeetCode.Medium.String;

public class Myatoi {
    public static void main(String[] args) {
//        System.out.println(new Myatoi().myAtoi("    words and 987"));
//        System.out.println(new Myatoi().myAtoi("    -42"));
//        System.out.println(new Myatoi().myAtoi("    -91283472332"));
//        System.out.println(new Myatoi().myAtoi("    3.14"));
//        System.out.println(new Myatoi().myAtoi("    -0012a42"));
//        System.out.println(new Myatoi().myAtoi("    0012a42"));
//        System.out.println(new Myatoi().myAtoi("    2147483648"));
//        System.out.println(new Myatoi().myAtoi("-6147483648"));
//        System.out.println(new Myatoi().myAtoi("2147483648"));
        System.out.println(new Myatoi().myAtoi("    10522545459"));
//        System.out.println(new Myatoi().myAtoi("4193 with words"));
    }

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        if (!Character.isDigit(str.charAt(0))
                && str.charAt(0) != '-' && str.charAt(0) != '+')
            return 0;
        long ans = 0L;
        boolean neg = str.charAt(0) == '-';
        int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            ans = ans * 10 + (str.charAt(i++) - '0');
            if (!neg && ans > Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                break;
            }
            if (neg && ans > 1L + Integer.MAX_VALUE) {
                ans = 1L + Integer.MAX_VALUE;
                break;
            }
        }
        return neg ? (int) -ans : (int) ans;
    }
}
