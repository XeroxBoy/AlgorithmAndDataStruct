package company.shoppe;

public class PetalsBreak {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * @param petals int整型一维数组 花瓣数
     * @return int整型
     */
    public int petalsBreak(int[] petals) {
        // write code here
        int allCount = 0;
        for (int i = 0; i < petals.length; i++) {
            allCount += minCount(petals[i]);
        }
        return allCount;
    }

    private int minCount(int petal) {
        if (petal == 0) return 0;
        if (petal == 1 || petal == 2) return 1;
        int timesOfTwo = petal / 2;
        int yushuOfTwo = petal % 2;
        return timesOfTwo + yushuOfTwo;
    }
}
