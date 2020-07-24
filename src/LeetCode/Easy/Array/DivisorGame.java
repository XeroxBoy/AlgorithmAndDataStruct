package LeetCode.Easy.Array;

public class DivisorGame {
    public static void main(String[] args) {
        System.out.println(new DivisorGame().divisorGame(2));
        System.out.println(new DivisorGame().divisorGame(3));

    }

    public boolean divisorGame(int N) {
        if (N == 1) return false;
        boolean isBob = false;
        int n = N;
        int x = n - 1;
        while (n > 0) {
            while (x > 0 && n % x != 0) {
                x--;
            }
            if (x <= 0) break;
            n -= x;
            isBob = !isBob;
        }
        return !isBob;
    }
}
