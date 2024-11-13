package baekjoon_2024;

import java.io.*;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class P10844 {
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        bw.close();
        br.close();
    }

    private static void recursive(int depth) {
        if (depth == n) {
            answer++;
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (depth == 0 && i == 0) continue;

            if (!deque.isEmpty() && Math.abs(deque.getLast() - i) == 1) {
                deque.addLast(i);
                recursive(depth + 1);
                deque.pollLast();
            } else if (deque.isEmpty()) {
                deque.addLast(i);
                recursive(depth + 1);
                deque.pollLast();
            }
        }
    }
}
