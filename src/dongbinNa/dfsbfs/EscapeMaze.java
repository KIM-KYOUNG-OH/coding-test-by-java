package dongbinNa.dfsbfs;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class EscapeMaze {
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};

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

        Deque<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[n + 1][m + 1];
        q.add(new int[]{1, 1});
        visit[1][1] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];

            if (y == n && x == m) {
                break;
            }

            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (0 < ny && ny <= n && 0 < nx && nx <= m) {
                    if (graph[ny][nx] == 1 && !visit[ny][nx]) {
                        graph[ny][nx] = graph[y][x] + 1;
                        visit[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }

        bw.write(String.valueOf(graph[n][m]));

        bw.close();
        br.close();
    }
}
