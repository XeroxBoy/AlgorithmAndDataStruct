package LeetCode.Easy.Stack;

import java.util.HashMap;
import java.util.Stack;

public class IsValid {
    private Stack<Character> stack1;
    private HashMap<Character, Character> map;

    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("()"));
        System.out.println(new IsValid().isValid("()[]{}"));
        System.out.println(new IsValid().isValid("(]"));
        System.out.println(new IsValid().isValid("([)]"));
        System.out.println(new IsValid().isValid("{[]}"));
    }

    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        stack1 = new Stack<>();
        map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char oneChar = s.charAt(i);
            if (oneChar == '(' || oneChar == '{' || oneChar == '[') {
                stack1.push(oneChar);
            } else {
                if (!hasLeft(oneChar)) return false;
            }
        }
        return stack1.empty();
    }

    public boolean hasLeft(Character right) {
        if (stack1.empty()) return false;
        if (stack1.peek() == map.get(right)) {
            stack1.pop();
            return true;
        }
        return false;
    }
}
