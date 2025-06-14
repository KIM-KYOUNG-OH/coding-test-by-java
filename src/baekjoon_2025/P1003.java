package baekjoon_2025;

import java.io.*;
import java.util.Arrays;

public class P1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] cases = new int[t];
        for (int i = 0; i < t; i++) {
            cases[i] = Integer.parseInt(br.readLine());
        }

        int max = Arrays.stream(cases).max().getAsInt();
        int[][] dp = new int[max + 1][2];
        if (max >= 1) {
            dp[1] = new int[]{0, 1};
        }
        dp[0] = new int[]{1, 0};

        for (int i = 2; i <= max; i++) {
            dp[i] = new int[]{dp[i - 1][0] + dp[i - 2][0], dp[i - 1][1] + dp[i - 2][1]};
        }

        for (int num : cases) {
            bw.write(dp[num][0] + " " + dp[num][1] + "\n");
        }

        bw.flush();
    }
}
