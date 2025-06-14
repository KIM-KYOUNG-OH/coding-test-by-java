package baekjoon_2025;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class P2667 {
    private static int n;
    private static int[][] graph;
    private static boolean[][] visit;
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                graph[i][j + 1] = arr[j];
            }
        }

        visit = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j);
                }
            }
        }

        List<Integer> sortedResult = result.stream().sorted().collect(Collectors.toList());
        bw.write(sortedResult.size() + "\n");
        for (int size : sortedResult) {
            bw.write(size + "\n");
        }
        bw.flush();
    }

    private static void bfs(int sy, int sx) {
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sy, sx});
        visit[sy][sx] = true;
        int townSize = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (0 < ny && ny <= n && 0 < nx && nx <= n) {
                    if (graph[ny][nx] == 1 && !visit[ny][nx]) {
                        visit[ny][nx] = true;
                        townSize++;
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }

        result.add(townSize);
    }
}
