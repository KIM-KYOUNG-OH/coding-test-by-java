package baekjoon_2025;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P1260 {
    private static boolean[][] graph;
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int n;
    private static int m;
    private static int v;
    private static int depth;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = s[0];
        m = s[1];
        v = s[2];

        graph = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            graph[a][b] = true;
            graph[b][a] = true;
        }

        boolean[] visit = new boolean[n + 1];
        visit[v] = true;
        bw.write(v + " ");
        dfs(visit, v);
        bw.write("\n");
        bfs();
        bw.flush();
    }

    private static void dfs(boolean[] visit, int cur) throws IOException {
        if (depth == n) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (graph[cur][i] && !visit[i]) {
                visit[i] = true;
                bw.write(i + " ");
                depth++;
                dfs(visit, i);
            }
        }
    }

    private static void bfs() throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        boolean[] visit = new boolean[n + 1];
        visit[v] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            bw.write(cur + " ");
            for (int i = 1; i <= n; i++) {
                if (graph[cur][i] && !visit[i]) {
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
