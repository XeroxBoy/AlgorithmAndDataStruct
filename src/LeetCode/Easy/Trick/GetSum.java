package LeetCode.Easy.Trick;

public class GetSum {
    public static void main(String[] args) {
        System.out.println(new GetSum().getSum(9, 3));
    }

    public int getSum(int a, int b) {
        int sum, carry;
        sum = a ^ b;
        carry = (a & b) << 1;
        while (carry != 0) {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return sum;
    }
}
