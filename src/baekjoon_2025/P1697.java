package baekjoon_2025;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int k = arr[1];

        if (n == k) {
            bw.write(String.valueOf(0));
            bw.flush();
            return;
        }

        int result = 0;
        boolean[] visit = new boolean[200001];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0});
        visit[n] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pos = cur[0];
            int move = cur[1];
            if (pos == k) {
                result = move;
                break;
            } else if (pos < 0) {
                continue;
            }

            int next = pos - 1;
            if (0 <= next && !visit[next]) {
                visit[next] = true;
                q.add(new int[]{next, move + 1});
            }

            next = pos + 1;
            if (next <= 200000 && !visit[next]) {
                visit[next] = true;
                q.add(new int[]{next, move + 1});
            }

            next = 2 * pos;
            if (next <= 200000 && !visit[next]) {
                visit[next] = true;
                q.add(new int[]{next, move + 1});
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}
