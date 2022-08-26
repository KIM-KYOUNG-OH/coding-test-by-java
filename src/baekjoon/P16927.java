package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16927 {
    static int n;
    static int m;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        int r = Integer.parseInt(s[2]);
        matrix = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] ss = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(ss[j]);
            }
        }

        rotate(r);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        br.close();
    }

    private static void rotate(int r) {
        int cycle = Math.min(n / 2, m / 2);
        for(int k = 0; k < cycle; k++) {
            int width = m - k * 2;
            int height = n - k * 2;
            int startY = k;
            int startX = k;
            int endY = n - 1 - k;
            int endX = m - 1 - k;

            int distance = (width - 1) * 2 + (height - 1) * 2;
            int repeatTimes = r % distance;
            while(repeatTimes-- > 0) {
                // 위
                int temp = matrix[startY][startX];
                for(int i = 0; i < width - 1; i++) {
                    matrix[startY][startX + i] = matrix[startY][startX + i + 1];
                }

                // 오른
                for(int i = 0; i < height - 1; i++) {
                    matrix[startY + i][endX] = matrix[startY + i + 1][endX];
                }

                // 아래
                for(int i = 0; i < width - 1; i++) {
                    matrix[endY][endX - i] = matrix[endY][endX - i - 1];
                }

                // 왼
                for(int i = 0; i < height - 1; i++) {
                    if(i == height - 2) matrix[endY - i][startX] = temp;
                    else matrix[endY - i][startX] = matrix[endY - i - 1][startX];
                }
            }
        }

    }
}
