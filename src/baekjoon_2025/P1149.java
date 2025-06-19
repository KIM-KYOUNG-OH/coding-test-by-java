package baekjoon_2025;

import java.io.*;
import java.util.Arrays;

public class P1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (i == 0) {
                dp[i] = arr;
                continue;
            }

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[2];
        }

        int result = Math.min(dp[n - 1][0], dp[n - 1][1]);
        result = Math.min(result, dp[n - 1][2]);

        bw.write(String.valueOf(result));
        bw.flush();
    }
}
