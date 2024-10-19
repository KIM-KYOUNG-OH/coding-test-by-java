package baekjoon_2024;

import java.io.*;
import java.util.Arrays;

public class P1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = s[0];
        int n = s[1];
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 0; i < isPrime.length; i++) {
            if (i == 0 || i == 1) continue;
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }

        for (int i = m; i <= n; i++) {
            if (isPrime[i]) bw.write(i + "\n");
        }

        bw.close();
        br.close();
    }
}
