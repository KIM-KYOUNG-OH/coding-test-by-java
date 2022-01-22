package baekjoon;

import java.io.*;

public class P11060 {
    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] numbers = new int[n];
        int[] dp = new int[n];

        for(int i = 1; i < n; i++) {
            dp[i] = INF;
        }

        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(arr[i]);
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(numbers[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        int answer = dp[n - 1];
        if(answer == INF) answer = -1;

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}
