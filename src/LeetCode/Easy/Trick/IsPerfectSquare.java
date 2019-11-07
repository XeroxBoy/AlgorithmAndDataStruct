package LeetCode.Easy.Trick;

public class IsPerfectSquare {
    public static void main(String[] args) {
        System.out.println(new IsPerfectSquare().isPerfectSquare(25));
    }

    public boolean isPerfectSquare(int num) {
        long l = 1;
        long r = num;
        while (l < r) {
            long mid = (l + r) / 2;
            if (mid * mid < num) {
                l = mid + 1;
            } else r = mid;
        }
        return num == r * r;
    }
}
