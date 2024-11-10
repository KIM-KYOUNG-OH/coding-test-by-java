package baekjoon_2024;

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class P15651 {
    private static Deque<Integer> deque;
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = s[0];
        m = s[1];
        deque = new LinkedList<>();

        recursive(0);

        bw.close();
        br.close();
    }

    private static void recursive(int depth) throws IOException {
        if (depth == m) {
            for (Integer num : deque) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
            recursive(depth + 1);
            deque.removeLast();
        }
    }
}
