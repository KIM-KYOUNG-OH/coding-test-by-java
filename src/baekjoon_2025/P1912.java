package baekjoon_2025;

import java.io.*;
import java.util.Arrays;

public class P1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[n];
        dp[0] = arr[0];
        int result = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            result = Math.max(result, dp[i]);
        }

        bw.write(result + "");
        bw.flush();
    }
}
