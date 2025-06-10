package baekjoon_2025;

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
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i + i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }

        for (int i = m; i <= n; i++) {
            if (isPrime[i]) bw.write(i + "\n");
        }

        bw.flush();
    }
}
