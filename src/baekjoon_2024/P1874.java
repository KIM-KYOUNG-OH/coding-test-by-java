package baekjoon_2024;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] targets = new int[n];
        for (int i = 0; i < n; i++) {
            targets[i] = Integer.parseInt(br.readLine());
        }

        int cursor = 0;
        Stack<Integer> stack = new Stack<>();
        List<String> answer = new ArrayList<>();
        for (int num = 1; num <= n; num++) {
            if (num <= targets[cursor]) {
                stack.push(num);
                answer.add("+");
            }

            while (!stack.isEmpty() && stack.peek() == targets[cursor]) {
                stack.pop();
                answer.add("-");
                cursor++;
            }
        }

        if (!stack.isEmpty() || cursor < n) {
            bw.write("NO");
        } else {
            for (String s : answer) {
                bw.write(s + "\n");
            }
        }

        bw.close();
        br.close();
    }
}
