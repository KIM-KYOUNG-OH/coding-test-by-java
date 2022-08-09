package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P17952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Assignment> stack = new Stack<>();

        int answer = 0;
        for(int i = 0; i < n; i++) {
            String temp = br.readLine();
            if(temp.equals("0")) {
                if(!stack.isEmpty()) {
                    Assignment peek = stack.peek();
                    peek.minute--;

                    if(peek.minute == 0) {
                        Assignment pop = stack.pop();
                        answer += pop.grade;
                    }
                }
            } else {
                String[] s = temp.split(" ");
                stack.add(new Assignment(Integer.parseInt(s[1]), Integer.parseInt(s[2])));
                Assignment peek = stack.peek();
                peek.minute--;

                if(peek.minute == 0) {
                    Assignment pop = stack.pop();
                    answer += pop.grade;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }

    private static class Assignment {
        int grade;
        int minute;

        public Assignment(int grade, int minute) {
            this.grade = grade;
            this.minute = minute;
        }
    }
}
