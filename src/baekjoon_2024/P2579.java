package baekjoon_2024;

import java.io.*;

public class P2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dpWithPrev = new int[n + 1];
        int[] dpWithoutPrev = new int[n + 1];
        int[] scores = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        dpWithPrev[1] = scores[1];
        dpWithoutPrev[1] = scores[1];

        if (n >= 2) {
            dpWithPrev[2] = scores[1] + scores[2];
            dpWithoutPrev[2] = scores[2];
        }

        for (int i = 3; i <= n; i++) {
            dpWithPrev[i] = dpWithoutPrev[i - 1] + scores[i];
            dpWithoutPrev[i] = Math.max(dpWithPrev[i - 2], dpWithoutPrev[i - 2]) + scores[i];
        }

        int answer = Math.max(dpWithPrev[n], dpWithoutPrev[n]);
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
