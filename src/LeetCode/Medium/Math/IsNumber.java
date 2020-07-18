package LeetCode.Medium.Math;

import java.util.HashMap;
import java.util.Map;

public class IsNumber {
    public static void main(String[] args) {
        System.out.println(new IsNumber().isNumber("+100"));
        System.out.println(new IsNumber().isNumber("5e2"));
        System.out.println(new IsNumber().isNumber("-123"));
        System.out.println(new IsNumber().isNumber("3.1416"));
        System.out.println(new IsNumber().isNumber("12e"));
        System.out.println(new IsNumber().isNumber("1a3.14"));
        System.out.println(new IsNumber().isNumber("1.2.3"));
        System.out.println(new IsNumber().isNumber("+-5"));
        System.out.println(new IsNumber().isNumber("-1E16"));
        System.out.println(new IsNumber().isNumber("12e+5.4"));
        System.out.println(new IsNumber().isNumber("   "));
        System.out.println(new IsNumber().isNumber(" .1  "));
        System.out.println(new IsNumber().isNumber(" .  "));
        System.out.println(new IsNumber().isNumber(" 0e  "));
        System.out.println(new IsNumber().isNumber(" .  1  "));
        System.out.println(new IsNumber().isNumber(" .  "));
        System.out.println(new IsNumber().isNumber("G76  "));
    }

    /*
    * 按照字符串从左到右的顺序，定义以下 9 种状态。

    开始的空格
    幂符号前的正负号
    小数点前的数字
    小数点、小数点后的数字
    当小数点前为空格时，小数点、小数点后的数字
    幂符号
    幂符号后的正负号
    幂符号后的数字
    结尾的空格
    结束状态：

    合法的结束状态有 2, 3, 7, 8 。

    * */
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap<Character, Integer>() {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }}, // 0.
                new HashMap<Character, Integer>() {{
                    put('d', 2);
                    put('.', 4);
                }},                           // 1.
                new HashMap<Character, Integer>() {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }}, // 2.
                new HashMap<Character, Integer>() {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},              // 3.
                new HashMap<Character, Integer>() {{
                    put('d', 3);
                }},                                        // 4.
                new HashMap<Character, Integer>() {{
                    put('s', 6);
                    put('d', 7);
                }},                           // 5.
                new HashMap<Character, Integer>() {{
                    put('d', 7);
                }},                                        // 6.
                new HashMap<Character, Integer>() {{
                    put('d', 7);
                    put(' ', 8);
                }},                           // 7.
                new HashMap<Character, Integer>() {{
                    put(' ', 8);
                }}                                         // 8.
        };
        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') t = 'd';
            else if (c == '+' || c == '-') t = 's';
            else if (c == '.' || c == 'e' || c == 'E' || c == ' ') t = c;
            else t = '?';
            if (!states[p].containsKey(t)) return false;
            p = (int) states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}
