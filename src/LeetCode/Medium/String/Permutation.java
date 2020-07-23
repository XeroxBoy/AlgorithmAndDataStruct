package LeetCode.Medium.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Permutation {
    LinkedList<String> permutationList = new LinkedList<>();
    char[] c;

    public static void main(String[] args) {
        Arrays.stream(
                new Permutation().permutation("dkjphedy"))
                .forEach(System.out::println);
    }

    public String[] permutation(String s) {
        c = s.toCharArray();
        generate_str(0);
        return permutationList.toArray(new String[0]);
    }

    private void generate_str(int index) {
        if (index == c.length - 1) {
            permutationList.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < c.length; i++) {
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i, index);
            generate_str(index + 1);
            swap(i, index);
        }
    }

    void swap(int x, int y) {
        char temp = c[x];
        c[x] = c[y];
        c[y] = temp;
    }
}
