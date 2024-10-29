package baekjoon_2024;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0];
        int m = s[1];
        boolean[] visit = new boolean[n + 1];
        boolean[][] edges = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int[] ss = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int u = ss[0];
            int v = ss[1];
            edges[u][v] = true;
            edges[v][u] = true;
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                answer++;
                bfs(n, edges, visit, i);
            }
        }

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }

    private static void bfs(int n, boolean[][] edges, boolean[] visit, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            for (int i = 1; i <= n; i++) {
                if (!visit[i] && edges[cur][i]) {
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
