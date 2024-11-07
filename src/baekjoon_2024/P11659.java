package baekjoon_2024;

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
        for (int i = 0; i < n; i++) {
            dp[i + 1] = arr[i] + dp[i];
        }

        for (int i = 0; i < m; i++) {
            int[] ss = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = ss[0];
            int end = ss[1];
            int c = dp[end] - dp[start - 1];
            bw.write(c + "\n");
        }

        bw.close();
        br.close();
    }
}
