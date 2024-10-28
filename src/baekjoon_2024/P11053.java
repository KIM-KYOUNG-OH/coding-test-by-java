package baekjoon_2024;

import java.io.*;
import java.util.Arrays;

public class P11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            int maxVal = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < cur && dp[j] + 1 > maxVal) {
                    maxVal = dp[j] + 1;
                }
            }

            dp[i] = maxVal;
        }

        int answer = Arrays.stream(dp).max().getAsInt();

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}
