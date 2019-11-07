package LeetCode.Easy.Trick;

public class IsPowerOfFour {
    public static void main(String[] args) {
        System.out.println(new IsPowerOfFour().isPowerOfFour(21));
    }

    public boolean isPowerOfFour(int num) {
        //前者判断是否2的次幂，后者判断是否4的次幂
        return (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }

    public boolean greatIsPowerOfFour(int num) {
        String str = Integer.toBinaryString(num);
        str = str.replace("00", "");
        return str.equals("1");
    }
}
