package baekjoon_2024;

import java.io.*;
import java.util.*;

public class P2667 {
    private static List<Integer> groups;
    private static int n;
    private static int[][] graph;
    private static boolean[][] visit;
    private static Queue<int[]> q;
    private static int[] dy = new int[]{-1, 0, 1, 0};
    private static int[] dx = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        groups = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0 || visit[i][j]) continue;
                bfs(i, j);
            }
        }

        Collections.sort(groups);

        bw.write(groups.size() + "\n");
        for (Integer cnt : groups) {
            bw.write(cnt + "\n");
        }

        bw.close();
        br.close();
    }

    private static void bfs(int sy, int sx) {
        q.add(new int[]{sy, sx});
        visit[sy][sx] = true;
        int memberCnt = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (0 <= ny && ny < n && 0 <= nx && nx < n) {
                    if (graph[ny][nx] == 1 && !visit[ny][nx]) {
                        visit[ny][nx] = true;
                        memberCnt++;
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }

        groups.add(memberCnt);
    }
}
