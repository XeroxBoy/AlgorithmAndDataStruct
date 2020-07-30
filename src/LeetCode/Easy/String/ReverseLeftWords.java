package LeetCode.Easy.String;

public class ReverseLeftWords {
    public static void main(String[] args) {
        System.out.println(new ReverseLeftWords().reverseLeftWords("abcdefg", 2));
        System.out.println(new ReverseLeftWords().reverseLeftWords("lrloseumgh", 6));

    }

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
