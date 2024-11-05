package baekjoon_2024;

import java.io.*;
import java.util.Arrays;

public class P2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] s = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long n = s[0];
        long m = s[1];
        long[] trees = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long min = 0;
        long max = Arrays.stream(trees).max().getAsLong();

        while (min < max) {
            long mid = (min + max) / 2;
            long sum = 0;

            for (long tree : trees) {
                long temp = tree - mid;
                if (temp > 0) {
                    sum += temp;
                }
            }

            if (sum < m) {  // 상한선을 낮춰야함
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        bw.write(String.valueOf(max - 1));

        bw.close();
        br.close();
    }
}
