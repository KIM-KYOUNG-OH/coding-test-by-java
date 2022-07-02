package leetcode;

import java.util.Stack;

public class P20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.add(ch);
                continue;
            }

            if(ch == ')') {
                if(stack.size() == 0 || stack.peek() != '(') return false;

                stack.pop();
            } else if(ch == '}') {
                if(stack.size() == 0 || stack.peek() != '{') return false;

                stack.pop();
            } else if(ch == ']') {
                if(stack.size() == 0 || stack.peek() != '[') return false;

                stack.pop();
            }
        }

        return stack.size() == 0;
    }
}
