package baekjoon_2024;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P1260 {
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0];
        int m = s[1];
        int v = s[2];
        int[][] edge = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edge[temp[0]][temp[1]] = 1;
            edge[temp[1]][temp[0]] = 1;
        }

        dfs(n, edge, new int[n + 1], v);
        bw.write("\n");
        bfs(n, edge, new int[n + 1], v);

        bw.close();
        br.close();
    }

    private static void dfs(int n, int[][] edge, int[] visit, int cur) throws IOException {
        if (visit[cur] == 0) {
            bw.write(cur + " ");
            visit[cur] = 1;
        } else {
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (edge[cur][i] == 1) {
                dfs(n, edge, visit, i);
            }
        }
    }

    private static void bfs(int n, int[][] edge, int[] visit, int start) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = 1;
        bw.write(start + " ");
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            for (int i = 1; i <= n; i++) {
                if (edge[cur][i] == 1 && visit[i] == 0) {
                    visit[i] = 1;
                    q.add(i);
                    bw.write(i + " ");
                }
            }
        }
    }
}
