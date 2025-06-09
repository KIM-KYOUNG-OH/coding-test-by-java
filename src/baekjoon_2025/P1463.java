package baekjoon_2025;

import java.io.*;

public class P1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            int temp = dp[i - 1] + 1;

            if (i % 3 == 0) {
                temp = Math.min(temp, dp[i / 3] + 1);
            }

            if (i % 2 == 0) {
                temp = Math.min(temp, dp[i / 2] + 1);
            }

            dp[i] = temp;
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
    }
}
