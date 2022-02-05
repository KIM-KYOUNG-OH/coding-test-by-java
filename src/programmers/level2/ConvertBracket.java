package programmers.level2;

import java.util.Stack;

/**
 * 1차: solution 참고
 */
public class ConvertBracket {
    public String solution(String p) {
        if(isRight(p)) return p;

        return dfs(p);
    }

    private String dfs(String w) {
        if(w.length() == 0) return "";

        String u = "";
        String v = "";
        int rCnt = 0, lCnt = 0;
        for(int i = 0; i < w.length(); i++) {
            char ch = w.charAt(i);
            if(ch == '(') rCnt++;
            else lCnt++;
            if((rCnt != 0 && lCnt != 0) && rCnt == lCnt) {
                u = w.substring(0, i + 1);
                if(i != w.length() - 1) {
                    v = w.substring(i + 1);
                }
                break;
            }
        }

        if(!isRight(u)) {
            String temp = "(" + dfs(v);
            temp += ")";
            u = u.substring(1, u.length() - 1);
            u = u.replace("(", ".");
            u = u.replace(")", "(");
            u = u.replace(".", ")");
            temp += u;
            return temp;
        }else {
            return u + dfs(v);
        }
    }

    private boolean isRight(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') stack.add(ch);
            else {
                if(stack.isEmpty()) return false;
                if(stack.peek() == ')') return false;
                stack.pop();
            }
        }

        if(!stack.isEmpty()) return false;

        return true;
    }
}
