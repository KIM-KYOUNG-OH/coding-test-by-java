package dongbinNa.implementation;

import java.io.*;

public class DevelopGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int y = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        int dir = Integer.parseInt(s[2]);

        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }

        boolean[][] visit = new boolean[n][m];
        visit[y][x] = true;
        while (true) {
            if (!visit[y][x] && graph[y][x] == 0){
                visit[y][x] = true;
            }

            boolean isTurnSuccess = false;
            for (int k = 0; k < 4; k++) {
                int nDir = (dir - k - 1 + 4) % 4;
                int ny = y + dy[nDir];
                int nx = x + dx[nDir];

                if (0 <= ny && ny < n && 0 <= nx && nx < m && graph[ny][nx] == 0 && !visit[ny][nx]) {
                    y = ny;
                    x = nx;
                    dir = nDir;
                    visit[ny][nx] = true;
                    isTurnSuccess = true;
                    break;
                }
            }

            if (!isTurnSuccess) {
                int ndir = (dir + 2) % 4;
                int ny = y + dy[ndir];
                int nx = x + dx[ndir];

                if ((0 <= ny && ny < n && 0 <= nx && nx < m && graph[ny][nx] == 0)) {
                    visit[ny][nx] = true;
                    y = ny;
                    x = nx;
                } else {
                    break;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j]) answer++;
            }
        }

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }

    private static class Node {

        private int y;
        private int x;
        private int dir;

        private Node(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }

        private int getY() {
            return y;
        }

        private int getX() {
            return x;
        }

        private int getDir() {
            return dir;
        }
    }
}
