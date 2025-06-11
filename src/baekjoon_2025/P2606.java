package baekjoon_2025;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = s[0];
            int b = s[1];
            graph[a][b] = true;
            graph[b][a] = true;
        }

        boolean[] visit = new boolean[n + 1];
        visit[1] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        int infected = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int k = 1; k <= n; k++) {
                if (graph[cur][k] && !visit[k]) {
                    visit[k] = true;
                    infected++;
                    q.add(k);
                }
            }
        }

        bw.write(String.valueOf(infected));
        bw.flush();
    }
}
