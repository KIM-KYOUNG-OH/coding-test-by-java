package baekjoon;

import java.io.*;

public class P1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n + 1][n + 1];
        int center = n / 2 + 1;
        int idx = 1;
        int gap = 1;
        int direction = 0;
        int[] dy = new int[]{-1, 0, 1, 0};
        int[] dx = new int[]{0, 1, 0, -1};
        int y = center;
        int x = center;
        int targetY = center;
        int targetX = center;
        matrix[y][x] = 1;

        while (true) {
            boolean breaker = false;
            for(int i = 0; i < (gap + 1) / 2; i++) {
                y = y + dy[direction];
                x = x + dx[direction];
                if(y <= 0 || y > n || x <= 0 || x > n) {
                    breaker = true;
                    break;
                }

                matrix[y][x] = ++idx;
                if(matrix[y][x] == target) {
                    targetY = y;
                    targetX = x;
                }
            }

            if(breaker) break;

            gap++;
            direction = (direction + 1) % 4;
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                bw.write(String.valueOf(matrix[i][j]));
                if(j != n) {
                    bw.write(" ");
                } else {
                    bw.write("\n");
                }
            }
        }

        bw.write(targetY + " " + targetX);

        bw.close();
        br.close();
    }
}
