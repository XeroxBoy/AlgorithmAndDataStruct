package LeetCode.Easy;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class IsValidBracket {
    public static void main(String[] args) {
        System.out.println(new IsValidBracket().isValidPerfect("([)]"));
        System.out.println(new IsValidBracket().isValidPerfect("  "));
        System.out.println(new IsValidBracket().isValidPerfect("{{[[]]}}"));
        System.out.println(new IsValidBracket().isValid("([)]"));
        System.out.println(new IsValidBracket().isValid("  "));
        System.out.println(new IsValidBracket().isValid("{{[[]]}}"));
    }

    boolean isValidPerfect(String s) {
        if (s.trim().length() == 0) return true;
        char[] chars = s.toCharArray();
        ConcurrentHashMap<Character, Character> bracketMap = new ConcurrentHashMap<>();
        bracketMap.put('{', '}');
        bracketMap.put('[', ']');
        bracketMap.put('(', ')');

        char[] ptr = new char[chars.length + 1];
        Arrays.fill(ptr, '.');
        int a = 0;
        for (char aChar : chars) {
            if (bracketMap.containsKey(aChar)) {
                a++;
                ptr[a] = aChar;
            } else if (aChar == ptr[a] + 1 || aChar == ptr[a] + 2) {
                a--;
            } else return false;
        }
        if (a != 0) return false;
        return true;
    }

    boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> bracketStack = new Stack<>();
        ConcurrentHashMap<Character, Character> bracketMap = new ConcurrentHashMap<>();
        bracketMap.put('(', ')');
        bracketMap.put('[', ']');
        bracketMap.put('{', '}');
        for (char aChar : chars) {
            if (bracketMap.containsKey(aChar)) {
                bracketStack.push(aChar);
            } else {
                if (bracketStack.isEmpty()) return false;
                if (bracketMap.get(bracketStack.peek()).equals(aChar)) {
                    bracketStack.pop();
                } else {
                    return false;
                }
            }
        }
        return bracketStack.isEmpty();
    }
}
