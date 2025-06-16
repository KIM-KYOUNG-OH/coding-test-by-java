package baekjoon_2025;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P1012 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = s[0];
            int m = s[1];
            int k = s[2];

            int[][] graph = new int[n][m];
            boolean[][] visit = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int y = s[0];
                int x = s[1];
                graph[y][x] = 1;
            }

            bfs(graph, visit, n, m);
        }

        bw.flush();
    }

    private static void bfs(int[][] graph, boolean[][] visit, int n, int m) throws IOException {
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visit[i][j]) {
                    visit[i][j] = true;
                    q.add(new int[]{i, j});
                    result++;
                }

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int y = cur[0];
                    int x = cur[1];
                    for (int k = 0; k < 4; k++) {
                        int ny = y + dy[k];
                        int nx = x + dx[k];
                        if (0 <= ny && ny < n && 0 <= nx && nx < m) {
                            if (graph[ny][nx] == 1 && !visit[ny][nx]) {
                                visit[ny][nx] = true;
                                q.add(new int[]{ny, nx});
                            }
                        }
                    }
                }
            }
        }

        bw.write(result + "\n");
    }
}
