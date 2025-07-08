package baekjoon_2025;

import java.io.*;
import java.util.Arrays;

public class P11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            int num = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < num) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = Arrays.stream(dp).max().getAsInt();

        bw.write(result + "");
        bw.flush();
    }
}
