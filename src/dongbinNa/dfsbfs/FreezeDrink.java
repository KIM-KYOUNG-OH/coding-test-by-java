package dongbinNa.dfsbfs;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class FreezeDrink {
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] graph = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j + 1] = Integer.parseInt(temp.substring(j, j + 1));
            }
        }

        answer = 0;
        boolean[][] visit = new boolean[n + 1][m + 1];
        Deque<int[]> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (graph[i][j] == 0 && !visit[i][j]) {
                    visit[i][j] = true;
                    answer++;
                    q.add(new int[]{i, j});
                    bfs(graph, n, m, q, visit);
                } else {
                    visit[i][j] = true;
                }
            }
        }

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }

    private static void bfs(int[][] graph, int n, int m, Deque<int[]> q, boolean[][] visit) {
        while (!q.isEmpty()) {
            int[] poll = q.pollFirst();
            int y = poll[0];
            int x = poll[1];

            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (0 < ny && ny <= n && 0 < nx && nx <= m) {
                    if (graph[ny][nx] == 0 && !visit[ny][nx]) {
                        visit[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
