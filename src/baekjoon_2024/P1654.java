package baekjoon_2024;

import java.io.*;
import java.util.Arrays;

public class P1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] s = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long k = s[0];
        long n = s[1];
        long[] lines = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long min = 0;
        long max = Arrays.stream(lines).max().getAsLong();
        while (min < max) {
            long mid = (min + max) / 2;
            long cnt = 0;

            System.out.println("min = " + min);
            System.out.println("max = " + max);
            System.out.println("mid = " + mid);

            for (long line : lines) {
                cnt += line / mid;
            }

            System.out.println("cnt = " + cnt);
            System.out.println();

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
