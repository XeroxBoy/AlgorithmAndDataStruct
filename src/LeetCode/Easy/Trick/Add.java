package LeetCode.Easy.Trick;

public class Add {
    public static void main(String[] args) {
        System.out.println(new Add().add(1, 1));
    }

    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1; //进位
            a ^= b;//非进位和
            b = c;
        }
        return a;
    }
}
