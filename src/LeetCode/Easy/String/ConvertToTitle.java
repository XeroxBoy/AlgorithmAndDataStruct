package LeetCode.Easy.String;

public class ConvertToTitle {
    public static void main(String[] args) {
        System.out.println(new ConvertToTitle().convertToTitle(1));
//        System.out.println(Character.valueOf((char)('a'+25)));
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            n -= 1;
            int yushu = n % 26;
            sb.append(Character.valueOf((char) ('A' + yushu)));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
