package Algorithm;

import java.util.HashSet;
import java.util.Random;

public class hashsetTest {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 2500000; i++) {
            set.add(getRandomString(25));
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 2500000; i++) {
            String getRandomString = getRandomString(5) +
                    getRandomString(5) +
                    getRandomString(5) +
                    getRandomString(5) +
                    getRandomString(5);
            set.contains(getRandomString);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("拼接+过滤用时:" + (endTime - startTime) / 1000 + "s");
    }

    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
