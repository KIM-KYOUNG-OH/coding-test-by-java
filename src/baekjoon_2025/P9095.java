package baekjoon_2025;

import java.io.*;
import java.util.Arrays;

public class P9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] tasks = new int[t];
        for (int i = 0; i < t; i++) {
            tasks[i] = Integer.parseInt(br.readLine());
        }

        int max = Arrays.stream(tasks).max().getAsInt();
        int[] dp;
        if (max <= 3) {
            dp = new int[4];
        } else {
            dp = new int[max + 1];
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int n : tasks) {
            bw.write(dp[n] + "\n");
        }

        bw.flush();
    }
}
