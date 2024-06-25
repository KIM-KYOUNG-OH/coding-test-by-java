package programmers_2024.stackQueue;

import java.util.Stack;

public class RightBracket {
    boolean solution(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.size() == 0) {
                stack.add(ch);
                continue;
            }

            if (ch == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.add(ch);
            }
        }

        if (stack.size() > 0) {
            return false;
        } else {
            return true;
        }
    }
}
