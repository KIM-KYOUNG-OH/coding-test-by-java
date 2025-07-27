package baekjoon_2025;

import java.io.*;
import java.util.Arrays;

public class P9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        if (t == 0) {
            return;
        }

        int[] numbers = new int[t];
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            numbers[i] = n;
        }

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        for (int number : numbers) {
            bw.write(dp[number] + "\n");
        }

        bw.flush();
    }
}
