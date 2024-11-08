package baekjoon_2024;

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class P15652 {
    private static Deque<Integer> deque = new LinkedList<>();
    private static int n;
    private static int m;
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = s[0];
        m = s[1];

        recursive(0);

        bw.close();
        br.close();
    }

    private static void recursive(int depth) throws IOException {
        if (depth == m) {
            for (Integer integer : deque) {
                bw.write(integer + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
            recursive(depth + 1);
            deque.pollLast();
        }
    }
}
