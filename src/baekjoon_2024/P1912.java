package baekjoon_2024;

import java.io.*;
import java.util.Arrays;

public class P1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];
        dp[0] = numbers[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(numbers[i], dp[i - 1] + numbers[i]);
        }

        int answer = Arrays.stream(dp).max().getAsInt();

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}
