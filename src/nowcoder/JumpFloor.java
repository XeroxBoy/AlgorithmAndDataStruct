package nowcoder;

public class JumpFloor {
    public static int JumpFloor(int target) {
        if (target == 2) return 2;
        if (target == 1) return 1;
        return JumpFloor(target - 2) + JumpFloor(target - 1);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(4));
    }
}
