package LeetCode.Medium.Stack;

import java.util.LinkedList;
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder string = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    string.insert(0, stack.pop());
                }
                stack.pop();

                StringBuilder countString = new StringBuilder();
                while ((!stack.isEmpty()) && (stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9')) {
                    countString.insert(0, stack.pop());
                }
                int count = Integer.parseInt(countString.toString());

                StringBuilder retString = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    retString.append(string);
                }
                stack.push(retString.toString());
            } else {
                String str = "" + s.charAt(i);
                stack.push(str);
            }
        }

        StringBuilder aaa = new StringBuilder();
        while (!stack.isEmpty()) {
            aaa.insert(0, stack.pop());
        }
        return aaa.toString();
    }

    class Solution {
        public String decodeString(String s) {
            StringBuilder res = new StringBuilder();
            int multi = 0;
            LinkedList<Integer> stack_multi = new LinkedList<>();
            LinkedList<String> stack_res = new LinkedList<>();
            for (Character c : s.toCharArray()) {
                if (c == '[') {
                    stack_multi.addLast(multi);
                    stack_res.addLast(res.toString());
                    multi = 0;
                    res = new StringBuilder();
                } else if (c == ']') {
                    StringBuilder tmp = new StringBuilder();
                    int cur_multi = stack_multi.removeLast();
                    for (int i = 0; i < cur_multi; i++) tmp.append(res);
                    res = new StringBuilder(stack_res.removeLast() + tmp);
                } else if (c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
                else res.append(c);
            }
            return res.toString();
        }
    }
}