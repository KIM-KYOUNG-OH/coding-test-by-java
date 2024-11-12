package baekjoon_2024;

import java.io.*;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

public class P10844 {
    private static Set<String> set = new HashSet<>();
    private static int n;
    private static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        deque = new LinkedList<>();

        recursive(0);

        bw.write(String.valueOf(set.size()));

        bw.close();
        br.close();
    }

    private static void recursive(int depth) {
        if (depth == n) {
            set.add(deque.stream().map(String::valueOf).collect(Collectors.joining()));
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
