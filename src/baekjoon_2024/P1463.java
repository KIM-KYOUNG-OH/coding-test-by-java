package baekjoon_2024;

import java.io.*;

public class P1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x + 1];
        dp[1] = 0;
        for (int i = 2; i < x + 1; i++) {
            int minVal = dp[i - 1];
            if (i % 3 == 0) {
                minVal = Math.min(minVal, dp[i / 3]);
            }

            if (i % 2 == 0) {
                minVal = Math.min(minVal, dp[i / 2]);
            }

            dp[i] = minVal + 1;
        }

        bw.write(String.valueOf(dp[x]));

        bw.close();
        br.close();
    }
}
