package baekjoon_2024;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P7576 {
    private static class Tomato {
        private int y;
        private int x;

        private Tomato(int y, int x) {
            this.y = y;
            this.x = x;
        }

        private int getY() {
            return y;
        }

        private int getX() {
            return x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = s[0];
        int n = s[1];
        int[][] graph = new int[n][m];
        Queue<Tomato> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int[] ss = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                graph[i][j] = ss[j];
                if (ss[j] == 1) {
                    q.add(new Tomato(i, j));
                }
            }
        }

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Tomato cur = q.poll();
            int y = cur.getY();
            int x = cur.getX();
            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (0 <= ny && ny < n && 0 <= nx && nx < m) {
                    if (graph[ny][nx] == 0) {
                        graph[ny][nx] = graph[y][x] + 1;
                        q.add(new Tomato(ny, nx));
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    bw.write("-1");
                    bw.close();
                    br.close();
                    return;
                } else if (graph[i][j] == -1) {
                    continue;
                }

                answer = Math.max(answer, graph[i][j]);
            }
        }

        bw.write(String.valueOf(answer - 1));

        bw.close();
        br.close();
    }
}
