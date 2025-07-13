package baekjoon_2025;

import java.io.*;
import java.util.Arrays;

public class P1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < i; j++) {
                graph[i][j + 1] = arr[j];
            }
        }

        int[][] dp = new int[n + 1][n + 1];
        dp[1][1] = graph[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + graph[i][j];
            }
        }

        int result = Arrays.stream(dp[n]).max().getAsInt();

        bw.write(result + "");
        bw.flush();
    }
}
