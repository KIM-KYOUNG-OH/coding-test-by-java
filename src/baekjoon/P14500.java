package baekjoon;

import java.io.*;

public class P14500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] matrix = new int[n][m];

        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(s[j]);
            }
        }

        int max = 0;

        // 가로 막대
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m - 3; j++) {
                int sum = 0;
                for(int k = 0; k < 4; k++) {
                    sum += matrix[i][j + k];
                }
                max = Math.max(max, sum);
            }
        }

        // 세로 막대
        for(int i = 0; i < n - 3; i++) {
            for(int j = 0; j < m; j++) {
                int sum = 0;
                for(int k = 0; k < 4; k++) {
                    sum += matrix[i + k][j];
                }
                max = Math.max(max, sum);
            }
        }

        // 정사각형
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < m - 1; j++) {
                int sum = matrix[i][j] + matrix[i + 1][j] + matrix[i][j + 1] + matrix[i + 1][j + 1];
                max = Math.max(max, sum);
            }
        }

        // 세로 기억 + ㅏ
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int sum1 = matrix[i][j] + matrix[i + 1][j] + matrix[i + 2][j] + Math.max(Math.max(matrix[i][j + 1], matrix[i + 1][j + 1]), matrix[i + 2][j + 1]);
                int sum2 = matrix[i][j + 1] + matrix[i + 1][j + 1] + matrix[i + 2][j + 1] + Math.max(Math.max(matrix[i][j], matrix[i + 2][j]), matrix[i + 1][j]);
                max = Math.max(max, Math.max(sum1, sum2));
            }
        }

        // 가로 기억 + ㅗ
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < m - 2; j++) {
                int sum1 = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] + Math.max(Math.max(matrix[i + 1][j], matrix[i + 1][j + 2]), matrix[i + 1][j + 1]);
                int sum2 = matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] + Math.max(Math.max(matrix[i][j], matrix[i][j + 2]), matrix[i][j + 1]);
                max = Math.max(max, Math.max(sum1, sum2));
            }
        }

        // 세로 N
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                int sum = matrix[i + 1][j] + matrix[i + 1][j + 1] + Math.max(matrix[i][j] + matrix[i + 2][j + 1], matrix[i][j + 1] + matrix[i + 2][j]);
                max = Math.max(max, sum);
            }
        }

        // 가로 N
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < m - 2; j++) {
                int sum = matrix[i][j + 1] + matrix[i + 1][j + 1] + Math.max(matrix[i][j] + matrix[i + 1][j + 2], matrix[i + 1][j] + matrix[i][j + 2]);
                max = Math.max(max, sum);
            }
        }

        bw.write(String.valueOf(max));

        br.close();
        bw.close();
    }
}
