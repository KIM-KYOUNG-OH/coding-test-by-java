package baekjoon_2024;

import java.io.*;
import java.util.Arrays;

public class P12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0];
        int k = s[1];
        int[][] dp = new int[n + 1][k + 1];
        int[] weights = new int[n + 1];
        int[] values = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int[] ss = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int w = ss[0];
            int v = ss[1];
            weights[i] = w;
            values[i] = v;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (weights[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - weights[i]] + values[i], dp[i - 1][j]);
                }
            }
        }

        bw.write(String.valueOf(dp[n][k]));

        bw.close();
        br.close();
    }
}
