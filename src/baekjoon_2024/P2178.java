package baekjoon_2024;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P2178 {
    private static int[] dy = new int[]{-1, 0, 1, 0};
    private static int[] dx = new int[]{0, 1, 0, -1};
    private static int n;
    private static int m;
    private static int[][] miro;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = s[0];
        m = s[1];
        miro = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String ss = br.readLine();
            for (int j = 0; j < m; j++) {
                int val = Integer.parseInt(String.valueOf(ss.charAt(j)));
                miro[i][j + 1] = val;
            }
        }

        bfs();

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }

    private static void bfs() {
        boolean[][] visit = new boolean[n + 1][m + 1];
        visit[1][1] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 1, 1});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int distance = cur[2];
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (0 < ny && ny <= n && 0 < nx && nx <= m && !visit[ny][nx] && miro[ny][nx] == 1) {
                    if (ny == n && nx == m) {
                        answer = distance + 1;
                        return;
                    }
                    visit[ny][nx] = true;
                    q.add(new int[]{ny, nx, distance + 1});
                }
            }
        }
    }
}
