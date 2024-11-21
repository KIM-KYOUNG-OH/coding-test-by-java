package baekjoon_2024;

import java.io.*;

public class P10844 {
    private static int mod = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i = " + i);
                System.out.println("j = " + j);
                System.out.println();
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % mod;
                } else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

        long result = 0;
        for (long i : dp[n]) {
            result += i;
        }

        bw.write(String.valueOf(result % mod));

        bw.close();
        br.close();
    }
}
