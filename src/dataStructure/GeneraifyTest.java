package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneraifyTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] sbs = new int[5];
        Integer[] isbs = new Integer[list.size()];
        for (int value : sbs) {
            list.add(value);
        }
//        list.toArray();
//        Object[] asb = list.toArray(new Object[sbs.length]);
        Integer[] asb = list.toArray(isbs);
//        asb.
        int[] ints = Arrays.stream(asb)
                .mapToInt(Integer::valueOf).toArray();
        for (int sb : ints
        ) {
            System.out.println(sb);
        }
//        list.toArray(Arrays.stream(sbs).boxed().toArray(Integer[]::new));
    }
}
