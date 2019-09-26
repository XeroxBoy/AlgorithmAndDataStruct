package LeetCode.Easy;

public class CLimbStairs {
    public int climbStairs(int n){
        if(n<=2) return n;
        int i1 = 1;
        int i2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = i1 + i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }

    public static void main(String[] args) {
        System.out.println(new CLimbStairs().climbStairs(45));
    }
}

