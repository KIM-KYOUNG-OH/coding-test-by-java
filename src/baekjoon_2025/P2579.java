package baekjoon_2025;

import java.io.*;

public class P2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[t];
        dp[0] = arr[0];
        if (t >= 2) {
            dp[1] = arr[1] + arr[0];
        }

        if (t >= 3) {
            dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
        }

        for (int i = 3; i < t; i++) {
            dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
        }

        bw.write(String.valueOf(dp[t - 1]));
        bw.flush();
    }
}
