package baekjoon_2024;

import java.io.*;
import java.util.Arrays;

public class P1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < s.length; j++) {
                triangle[i][j] = s[j];
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                    continue;
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }

        int answer = Arrays.stream(dp[n - 1]).max().getAsInt();

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}
