package baekjoon_2025;

import java.io.*;
import java.util.Arrays;

public class P2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0];
        long m = s[1];
        int[] trees = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = 0;
        int end = Arrays.stream(trees).max().getAsInt();
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            long total = 0;
            for (int tree : trees) {
                if (tree > mid) {
                    total += tree - mid;
                }
            }

            if (total < m) {
                end = mid - 1;
            } else if (m <= total) {
                result = Math.max(result, mid);
                start = mid + 1;
            }
        }

        bw.write(result + "");
        bw.flush();
    }
}
