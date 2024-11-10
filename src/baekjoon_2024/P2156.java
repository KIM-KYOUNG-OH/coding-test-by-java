package baekjoon_2024;

import java.io.*;

public class P2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        dp[1] = numbers[1];

        if (n > 1) {
            dp[2] = numbers[1] + numbers[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + numbers[i], dp[i - 3] + numbers[i - 1] + numbers[i]));
        }

        System.out.println(dp[n]);
    }
}
