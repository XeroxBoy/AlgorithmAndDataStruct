package LeetCode.Easy.String;

public class AddStrings {
    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("99", "1234"));
    }

    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int num1_index = num1.length() - 1;
        int num2_index = num2.length() - 1;
        int add_count = 0;
        while (num1_index >= 0 && num2_index >= 0) {
            int now_count = num1.charAt(num1_index--) - '0' + num2.charAt(num2_index--) - '0' + add_count;
            add_count = 0;
            if (now_count >= 10) {
                add_count += 1;
                now_count %= 10;
            }
            result.append(now_count);
        }
        while (num1_index >= 0) {
            int now_count = num1.charAt(num1_index--) - '0' + add_count;
            add_count = 0;
            if (now_count >= 10) {
                add_count += 1;
                now_count %= 10;
            }
            result.append(now_count);
        }
        while (num2_index >= 0) {
            int now_count = num2.charAt(num2_index--) - '0' + add_count;
            add_count = 0;
            if (now_count >= 10) {
                add_count += 1;
                now_count %= 10;
            }
            result.append(now_count);
        }
        if (add_count != 0) result.append(add_count);
        return result.reverse().toString();
    }
}
