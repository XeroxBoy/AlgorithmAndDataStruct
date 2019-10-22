package LeetCode.Easy.Trick;

public class UglyNum {
    public boolean isUgly(int num) {
        if (num < 1) return false;
        while (true) {
            if (num == 2 || num == 3 || num == 5 || num == 1) return true;
            if (num % 2 != 0 && num % 3 != 0 && num % 5 != 0) return false;
            if (num % 2 == 0) num /= 2;
            else if (num % 3 == 0) num /= 3;
            else num /= 5;
        }
    }

    public static void main(String[] args) {
        System.out.println(new UglyNum().isUgly(6));
    }
}

