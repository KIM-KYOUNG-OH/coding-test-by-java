package baekjoon_2025;

import java.io.*;
import java.util.Arrays;

public class P1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = s[0];
        int n = s[1];
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long max = Arrays.stream(arr).max().getAsInt();
        long left = 0;
        long right = max + 1;

        while (left < right) {
            long mid = (left + right) / 2;

            long cnt = 0;
            for (long line : arr) {
                cnt += line / mid;
            }

            if (n <= cnt) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        bw.write(left - 1 + "");
        bw.flush();
    }
}
