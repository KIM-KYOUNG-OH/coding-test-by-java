package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class P16509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int sr = Integer.parseInt(s[0]);
        int sc = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int kr = Integer.parseInt(s[0]);
        int kc = Integer.parseInt(s[1]);

        int[] step1Y = new int[]{-1, -1, 0, 0, 1, 1, 0, 0};
        int[] step1X = new int[]{0, 0, 1, 1, 0, 0, -1, -1};
        int[] step2Y = new int[]{-1, -1, -1, 1, 1, 1, 1, -1};
        int[] step2X = new int[]{-1, 1, 1, 1, 1, -1, -1, -1};
        int[] step3Y = new int[]{-1, -1, -1, 1, 1, 1, 1, -1};
        int[] step3X = new int[]{-1, 1, 1, 1, 1, -1, -1, -1};

        int[][] matrix = new int[10][9];
        matrix[sr][sc] = 1;
        LinkedList<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(sr, sc, 0));
        int answer = -1;
        loop1 :
            while (!q.isEmpty()) {
                Coordinate cur = q.poll();
                int y = cur.y;
                int x = cur.x;
                for (int k = 0; k < 8; k++) {
                    int ny = y + step1Y[k];
                    int nx = x + step1X[k];
                    if (ny < 0 || ny > 9 || nx < 0 || nx > 8 || (ny == kr && nx == kc)) continue;

                    ny += step2Y[k];
                    nx += step2X[k];
                    if (ny < 0 || ny > 9 || nx < 0 || nx > 8 || (ny == kr && nx == kc)) continue;

                    ny += step3Y[k];
                    nx += step3X[k];
                    if (ny == kr && nx == kc) {
                        answer = cur.cnt + 1;
                        break loop1;
                    } else if(ny < 0 || ny > 9 || nx < 0 || nx > 8) continue;

                    if (matrix[ny][nx] == 0) {
                        matrix[ny][nx] = cur.cnt + 1;
                        q.add(new Coordinate(ny, nx, cur.cnt + 1));
                    }
                }
            }

        System.out.println(answer);

        br.close();
    }

    private static class Coordinate {
        int y;
        int x;
        int cnt;

        public Coordinate(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
}
