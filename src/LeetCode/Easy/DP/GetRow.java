package LeetCode.Easy.DP;

import java.util.ArrayList;
import java.util.List;

public class GetRow {
    public static void main(String[] args) {
        System.out.println(new GetRow().getRow(4));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        if (rowIndex == 0) return firstRow;
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                    continue;
                }
                row.add(firstRow.get(j - 1) + firstRow.get(j));
            }
            firstRow = row;
        }
        return firstRow;
    }
}
