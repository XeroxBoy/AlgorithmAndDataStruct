package LeetCode.Easy.String;

import java.util.HashMap;

public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> tMap =new HashMap<>();
        HashMap<Character,Character> sMap =new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char eachSChar = s.charAt(i);
            char eachTChar = t.charAt(i);
            if(tMap.containsKey(eachTChar) && !tMap.get(eachTChar).equals(eachSChar)){
                return false;
            }
            if(sMap.containsKey(eachSChar) && !sMap.get(eachSChar).equals(eachTChar)){
                return false;
            }
            tMap.put(eachTChar,eachSChar);
            sMap.put(eachSChar,eachTChar);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsIsomorphic().isIsomorphic("paper","title"));
    }
}

