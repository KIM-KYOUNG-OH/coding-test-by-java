package baekjoon_2024;

import java.io.*;
import java.util.*;

public class P1012 {
    private static int[] dy = new int[]{-1, 0, 1, 0};
    private static int[] dx = new int[]{0, 1, 0, -1};
    private static int[][] graph;
    private static boolean[][] visit;
    private static Queue<int[]> q;
    private static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        result = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = s[0];
            int n = s[1];
            int k = s[2];
            q = new LinkedList<>();
            graph = new int[n][m];
            visit = new boolean[n][m];
            for (int j = 0; j < k; j++) {
                int[] ss = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int x = ss[0];
                int y = ss[1];
                graph[y][x] = 1;
            }

            bfs(n, m);
        }

        for (Integer num : result) {
            bw.write(num + "\n");
        }

        bw.close();
        br.close();
    }

    private static void bfs(int n, int m) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && graph[i][j] == 1) {
                    answer++;
                    q.add(new int[]{i, j});
                    visit[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int cy = cur[0];
                        int cx = cur[1];
                        for (int k = 0; k < 4; k++) {
                            int ny = cy + dy[k];
                            int nx = cx + dx[k];
                            if (0 <= ny && ny < n && 0 <= nx && nx < m) {
                                if (!visit[ny][nx] && graph[ny][nx] == 1) {
                                    visit[ny][nx] = true;
                                    q.add(new int[]{ny, nx});
                                }
                            }
                        }
                    }
                }
            }
        }

        result.add(answer);
    }
}
