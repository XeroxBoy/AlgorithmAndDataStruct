package LeetCode.Hard.String;

import java.util.Stack;

public class Calculate {
    public static void main(String[] args) {
        System.out.println(new Calculate().calculate("1+1"));
        System.out.println(
                new Calculate().calculate("2-1+2")
        );
        System.out.println(new Calculate().calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public int calculate(String s) {
        Stack<Character> symbolStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int temp = i;
                int len = 0;
                while (temp < s.length() && Character.isDigit(s.charAt(temp))) {
                    len += 1;
                    temp++;
                }
                int result = 0;
                int tempLen = len;
                for (int j = i; j < temp; j++) {
                    result += Math.pow(10, len - 1) * (s.charAt(j) - '0');
                    len -= 1;
                }
                numStack.push(result);
                if (temp == s.length()) break;
                i += tempLen - 1;
            } else {
                char oneChar = s.charAt(i);
                if (oneChar == '(') {
                    symbolStack.push(oneChar);
                } else if (oneChar == '-' || oneChar == '+') {
                    if (symbolStack.isEmpty()) {
                        symbolStack.push(oneChar);
                    } else if (symbolStack.peek() == '+' || symbolStack.peek() == '-') {
                        Character symbol = symbolStack.pop();
                        Integer back = numStack.pop();
                        Integer forward = numStack.pop();
                        if (symbol == '+') numStack.push(back + forward);
                        else if (symbol == '-') numStack.push(forward - back);
                        symbolStack.push(oneChar);
                    } else {
                        symbolStack.push(oneChar);
                    }
                } else if (oneChar == ')') {
                    while (symbolStack.peek() != '(') {
                        Character symbol = symbolStack.pop();
                        Integer back = numStack.pop();
                        Integer forward = numStack.pop();
                        if (symbol == '+') numStack.push(back + forward);
                        else if (symbol == '-') numStack.push(forward - back);
                    }
                    if (symbolStack.peek() == '(') symbolStack.pop();
                }
            }
        }
        while (!symbolStack.isEmpty()) {
            Character symbol = symbolStack.pop();
            Integer back = numStack.pop();
            Integer forward = numStack.pop();
            if (symbol == '+') numStack.push(back + forward);
            else if (symbol == '-') numStack.push(forward - back);
        }

        return numStack.pop();
    }
}
