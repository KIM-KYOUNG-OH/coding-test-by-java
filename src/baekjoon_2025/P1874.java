package baekjoon_2025;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int current = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int target = Integer.parseInt(br.readLine());
            while (current <= target) {
                stack.push(current++);
                sb.append("+\n");
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                bw.write("NO");
                bw.flush();
                return;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
