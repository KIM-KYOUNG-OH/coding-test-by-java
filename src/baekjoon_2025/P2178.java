package baekjoon_2025;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0];
        int m = s[1];

        int[][] graph = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j <= m; j++) {
                graph[i][j] = arr[j - 1];
            }
        }

        boolean[][] visit = new boolean[n + 1][m + 1];
        visit[1][1] = true;

        int[] dy = new int[]{-1, 0, 1, 0};
        int[] dx = new int[]{0, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 1});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (0 < ny && ny <= n && 0 < nx && nx <= m) {
                    if (!visit[ny][nx] && graph[ny][nx] > 0) {
                        visit[ny][nx] = true;
                        graph[ny][nx] += graph[y][x];
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }

        bw.write(String.valueOf(graph[n][m]));
        bw.flush();
    }
}
