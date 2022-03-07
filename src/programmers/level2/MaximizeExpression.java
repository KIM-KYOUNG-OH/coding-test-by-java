package programmers.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * 1차: solution 참고
 */
public class MaximizeExpression {
    char[] prior = {'+', '-', '*'};
    List<Character> ops = new ArrayList<>();
    List<Long> nums = new ArrayList<>();
    boolean[] check = new boolean[3];
    long answer;

    public long solution(String expression) {
        answer = 0;
        String num = "";
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(ch >= '0' && ch <= '9') {
                num += ch;
            } else {
                nums.add(Long.parseLong(num));
                ops.add(ch);
                num = "";
            }
        }
        nums.add(Long.parseLong(num));
        dfs(0, new char[3]);
        return answer;
    }

    private void dfs(int count, char[] p) {
        if(count == 3) {
            List<Character> cOps = new ArrayList<>(ops);
            List<Long> cNums = new ArrayList<>(nums);

            for(int i = 0; i < p.length; i++) {
                for(int j = 0; j < cOps.size(); j++) {
                    if(cOps.get(j) == p[i]) {
                        long res = calc(cNums.remove(j), cNums.remove(j), cOps.remove(j));
                        cNums.add(j, res);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(cNums.get(0)));
            return;
        }

        for (int i = 0; i < check.length; i++) {
            if(!check[i]) {
                check[i] = true;
                p[count] = prior[i];
                dfs(count + 1, p);
                check[i] = false;
            }
        }
    }

    private long calc(Long num1, Long num2, Character op) {
        if(op == '+') {
            return num1 + num2;
        } else if(op == '-') {
            return num1 - num2;
        } else {
            return num1 * num2;
        }
    }
}
