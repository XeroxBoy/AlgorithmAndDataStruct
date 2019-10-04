package LeetCode.Easy.DP;

import java.util.ArrayList;
import java.util.List;

public class Generate {
    public static void main(String[] args) {
        List<List<Integer>> generate = new Generate().generate(1);
        for (int i = 0; i < generate.size(); i++) {
            List<Integer> row = generate.get(i);
            for (int j = 0; j < row.size(); j++) {
                System.out.print(row.get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) return new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> rowList = new ArrayList<>(1);
        rowList.add(0, 1);
        resultList.add(rowList);
        for (int i = 1; i < numRows; i++) {
            List<Integer> lastRowList = resultList.get(i - 1);
            List<Integer> eachRowList = new ArrayList<>(i + 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    eachRowList.add(j, 1);
                    continue;
                }
                eachRowList.add(j, lastRowList.get(j - 1) + lastRowList.get(j));
            }
            resultList.add(i, eachRowList);
        }
        return resultList;
    }
}
