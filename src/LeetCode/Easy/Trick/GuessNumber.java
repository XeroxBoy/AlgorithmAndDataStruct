package LeetCode.Easy.Trick;

public class GuessNumber extends GuessGame {
    GuessNumber(int num) {
        super(num);
    }

    public static void main(String[] args) {
        System.out.println(new GuessNumber(1677).guessNumber(1000000000));
    }

    public int guessNumber(int n) {
        int high = n;
        int low = 1;
        while (high > low) {
            int mid = low + (high - low) / 2;
            int midGuess = guess(mid);
            if (midGuess == 0) return mid;
            else if (midGuess == 1) low = mid + 1;
            else {
                high = mid;
            }
        }
        return high;
    }
}
