package LeetCode.Medium.String;


public class TranslateNum {
    public static void main(String[] args) {
        System.out.println(new TranslateNum().translateNum(12258));
        System.out.println(new TranslateNum().translateNum(26));

    }

    public int translateNum(int num) {
        String num_str = String.valueOf(num);
        return cal_num(num_str, 0);
    }

    private int cal_num(String num_str, int i) {
        if (i >= num_str.length()) return 1;
        int result = 0;
        char num = num_str.charAt(i);
        if (num == '1' || num == '2') {
            result += cal_num(num_str, i + 1);
            if (i + 1 < num_str.length() && ((num_str.charAt(i) == '2' && num_str.charAt(i + 1) < '6') || num_str.charAt(i) == '1'))
                result += cal_num(num_str, i + 2);
        } else {
            result += cal_num(num_str, i + 1);
        }
        return result;
    }
}
