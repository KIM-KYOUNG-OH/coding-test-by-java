package baekjoon_2024;

import java.io.*;
import java.util.Arrays;

public class P9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        if (t == 0) return;

        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int maxVal = Arrays.stream(arr).max().getAsInt();
        long[] dp = new long[maxVal + 1];
        if (maxVal >= 1) {
            dp[1] = 1l;
        }

        if (maxVal >= 2) {
            dp[2] = 1l;
        }

        if (maxVal >= 3) {
            dp[3] = 1l;
        }

        for (int i = 4; i <= maxVal; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        for (int n : arr) {
            bw.write(dp[n] + "\n");
        }

        bw.close();
        br.close();
    }
}
