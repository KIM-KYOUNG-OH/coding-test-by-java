package baekjoon_2024;

import java.io.*;
import java.util.Arrays;

public class P1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int[][] dp = new int[max + 1][2];
        dp[0] = new int[]{1, 0};
        if (max >= 1) {
            dp[1] = new int[]{0, 1};
        }

        for (int i = 2; i <= max; i++) {
            int zeroCnt = dp[i - 1][0] + dp[i - 2][0];
            int oneCnt = dp[i - 1][1] + dp[i - 2][1];
            dp[i] = new int[]{zeroCnt, oneCnt};
        }

        for (int i : arr) {
            bw.write(dp[i][0] + " " + dp[i][1] + "\n");
        }

        bw.close();
        br.close();
    }
}
