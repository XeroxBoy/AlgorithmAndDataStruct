package LeetCode.Easy.String;

import java.util.HashMap;

public class GetHint {
    private HashMap<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String secret = "1123";
        String guess = "0111";
        System.out.println(new GetHint().getHint(secret, guess));
    }

    public String getHint(String secret, String guess) {
        char[] secretArray = secret.toCharArray();
        HashMap<Character, Integer> duplicateMap = new HashMap<>();
        char[] guessArray = guess.toCharArray();
        int A = 0, B = 0;
        for (int i = 0; i < secretArray.length; i++) {
            if (!map.containsKey(secretArray[i]))
                map.put(secretArray[i], 1);
            else
                map.replace(secretArray[i], map.get(secretArray[i]) + 1);
        }
        for (int i = 0; i < secretArray.length; i++) {
            if (secretArray[i] == guessArray[i]) {
                A += 1;
                map.replace(secretArray[i], map.get(secretArray[i]) - 1);
            }
        }
        for (int i = 0; i < secretArray.length; i++) {
            if (secretArray[i] != guessArray[i]) {
                if (map.containsKey(guessArray[i])) {
                    if (map.get(guessArray[i]) > 0) {
                        B += 1;
                        map.replace(guessArray[i], map.get(guessArray[i]) - 1);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(A).append("A").append(B).append("B");
        return sb.toString();
    }
}
