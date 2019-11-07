package LeetCode.Easy.Trick;

public class IsPowerOfThree {
    public static void main(String[] args) {
        System.out.println(new IsPowerOfThree().isPowerOfThree(8));
    }

    //    public boolean isPowerOfThree(int n) {
//        if(n==1) return true;
//        if(n<1) return false;
//        while(n!=1){
//            int yushu = n%3;
//            if(yushu!=0) return false;
//            n /= 3;
//        }
//        return true;
//    }
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        if (n == 1) return true;
        if (n % 3 != 0) return false;
        return isPowerOfThree(n / 3);
    }
}
