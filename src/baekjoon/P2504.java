package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        int multiple = 1;
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.add('(');
                multiple *= 2;
            } else if(c == '[') {
                stack.add('[');
                multiple *= 3;
            } else if(c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }
                stack.pop();
                if(s.charAt(i - 1) == '(') answer += multiple;
                multiple /= 2;
            } else if(c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                stack.pop();
                if(s.charAt(i - 1) == '[') answer += multiple;
                multiple /= 3;
            }
        }

        if(!stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(answer);
    }
}
