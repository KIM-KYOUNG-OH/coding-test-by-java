package programmers.level2;

import java.util.Stack;

public class DeletePairedAlphabet {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(stack.empty()) {
                stack.add(cur);
                continue;
            }

            if(stack.peek() == cur) stack.pop();
            else stack.add(cur);
        }

        int answer = 0;
        if(stack.size() == 0) answer = 1;
        return answer;
    }

    public static void main(String[] args) {
        DeletePairedAlphabet s = new DeletePairedAlphabet();
        System.out.println(s.solution("baabaa"));
    }
}
