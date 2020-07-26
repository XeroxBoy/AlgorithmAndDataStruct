package LeetCode.Medium.Math;

public class FindNthDigit {
    int digit_count;

    public static void main(String[] args) {
        System.out.println(new FindNthDigit().findNthDigit(3));
        System.out.println(new FindNthDigit().findNthDigit(11));
        System.out.println(new FindNthDigit().findNthDigit(100000000));
        long startTime = System.currentTimeMillis();
        System.out.println(new FindNthDigit().findNthDigit(1000000000));
        System.out.println(System.currentTimeMillis() - startTime);
    }


//    private int count_digit(int i, int count) {
//        if (i == 0) return 1;
//        int count_num = count;
//        i /= Math.pow(10, count_num);
//        while (i > 0) {
//            i /= 10;
//            count_num++;
//            digit_count++;
//        }
//        return count_num;
//    }

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

}
