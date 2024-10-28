package baekjoon_2024;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
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
                cursor++;
            } else {
                boolean isPossible = true;
                while (true) {
                    System.out.println("temp");
                    if (!stack.isEmpty() && cursor >= n) {
                        break;
                    }

                    if (stack.isEmpty() && cursor < n) {
                        isPossible = false;
                        break;
                    }

                    if (stack.peek() != targets[cursor]) {
                        isPossible = false;
                        break;
                    }

                    stack.pop();
                    answer.add("-");
                    cursor++;
                }

                if (!isPossible) {
                    bw.write("NO");
                    return;
                }
            }
        }

        System.out.println("answer.size() = " + answer.size());
        answer.stream().forEach(num -> {
            try {
                bw.write(String.valueOf(num));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bw.close();
        br.close();
    }
}
