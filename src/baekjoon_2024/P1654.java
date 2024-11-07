package baekjoon_2024;

import java.io.*;
import java.util.Arrays;

public class P1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] s = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int k = (int) s[0];
        long n = s[1];
        long[] lines = new long[k];
        for (int i = 0; i < k; i++) {
            lines[i] = Long.parseLong(br.readLine());
        }

        long min = 0;
        long max = Arrays.stream(lines).max().getAsLong();
        while (min < max) {
            long mid = (min + max) / 2;
            long cnt = 0;

            for (long line : lines) {
                cnt += line / mid;
            }

            if (cnt > n) {
                min = mid + 1;
            } else if (cnt == n) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        bw.write(String.valueOf(max - 1));

        bw.close();
        br.close();
    }
}
