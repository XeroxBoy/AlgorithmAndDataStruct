package LeetCode.Easy.String;

public class TitleToNumber {
    public int titleToNumber(String s){
        int length = s.length()-1;
        int mutiply = 1;
        int sum = 0;
        for (int i = length; i>=0 ; i--) {
            char eachNum = s.charAt(i);
            int wordNum = eachNum - 'A'+1;
            sum += mutiply * wordNum;
            mutiply *= 26;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new TitleToNumber().titleToNumber("A"));
    }
}

