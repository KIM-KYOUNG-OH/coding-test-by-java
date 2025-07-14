package baekjoon_2025;

import java.io.*;
import java.util.Arrays;

public class P11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0];
        int m = s[1];
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = arr[i - 1] + dp[i - 1];
        }

        for (int k = 0; k < m; k++) {
            s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int i = s[0];
            int j = s[1];
            int result = dp[j] - dp[i - 1];
            bw.write(result + "\n");
        }

        bw.flush();
    }
}
