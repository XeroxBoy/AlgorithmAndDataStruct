package LeetCode.Easy;

public class romanToInt {
    public static void main(String[] args) {
        System.out.println(new romanToInt().romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        char[] roman = s.toCharArray();
        int result = 0;
        for (int i = 0; i < roman.length; i++) {
            int num = 0;
            if (roman[i] == 'I') {
                if (i + 1 < roman.length && roman[i + 1] == 'V') {
                    num = 4;
                    result += num;
                    i += 1;
                    continue;
                }
                if (i + 1 < roman.length && roman[i + 1] == 'X') {
                    num = 9;
                    result += num;
                    i += 1;
                    continue;
                }
                num = 1;
            }
            if (roman[i] == 'V') {
                num = 5;
            }
            if (roman[i] == 'X') {
                if (i + 1 < roman.length && roman[i + 1] == 'L') {
                    num = 40;
                    result += num;
                    i += 1;
                    continue;
                }
                if (i + 1 < roman.length && roman[i + 1] == 'C') {
                    num = 90;
                    result += num;
                    i += 1;
                    continue;
                }
                num = 10;
            }
            if (roman[i] == 'L') {
                num = 50;
            }
            if (roman[i] == 'C') {
                if (i + 1 < roman.length && roman[i + 1] == 'D') {
                    num = 400;
                    result += num;
                    i += 1;
                    continue;
                }
                if (i + 1 < roman.length && roman[i + 1] == 'M') {
                    num = 900;
                    result += num;
                    i += 1;
                    continue;
                }
                num = 100;
            }
            if (roman[i] == 'D') {
                num = 500;
            }
            if (roman[i] == 'M') {
                num = 1000;
            }
            result += num;
        }
        return result;
    }
}
