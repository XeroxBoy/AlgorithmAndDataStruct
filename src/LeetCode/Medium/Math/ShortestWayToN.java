package LeetCode.Medium.Math;


public class ShortestWayToN {
    static int shortestWay = Integer.MAX_VALUE;

    public static void main(String[] args) {
        ShortestWayToN shortestWayToN = new ShortestWayToN();
//        System.out.println(shortestWayToN.shortestWayToN(1));
//        System.out.println(shortestWayToN.shortestWayToN(7));
//        System.out.println(shortestWayToN.shortestWayToN(10000));
//        System.out.println(shortestWayToN.shortestWayToN(40000));
//        System.out.println(shortestWayToN.shortestWayToN(80000));
        System.out.println(shortestWayToN.shortestWayToN(100000));
    }

    public int shortestWayToN(int n) {
        shortestWay = Integer.MAX_VALUE;
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        recurseFindN(5, 2, n, 3);
        recurseFindN(3, 5, n, 3);
        recurseFindN(4, 3, n, 3);
        recurseFindN(1, 4, n, 3);
//        recurseFindN(2, 1, n, 1);
//        recurseFindN(2, 1, n, 1);
        return shortestWay;
    }

    private void recurseFindN(int x, int y, int target, int times) {
        if (x > target || y > target) {
            return;
        }
//        if (times >= shortestWay) return;
        if (x == target || y == target) {
            shortestWay = Math.min(shortestWay, times);
            return;
        }
        if (x + y > target) return;
        if (x + y == target) {
            shortestWay = Math.min(shortestWay, times + 1);
            return;
        }
        if (x + y < target && y < target && times + 1 <= shortestWay)
            recurseFindN(x + y, y, target, times + 1);
        if (x + y < target && times + 1 <= shortestWay)
            recurseFindN(x, x + y, target, times + 1);
    }
}
