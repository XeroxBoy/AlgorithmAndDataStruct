package LeetCode.Easy.Trick;

public class AddDigits {
    public int addDigits(int num) {
        while (num >= 10) {
            num = toSumOfPos(num);
        }
        return num;
    }

    private int toSumOfPos(int num) {
        int sum = 0;
        while (num != 0) {
            int lastNum = num % 10;
            num /= 10;
            sum += lastNum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(100));
    }
}

