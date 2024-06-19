package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class P4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int len = arr[0];
            int[] slice = IntStream.range(1, len + 1)
                    .map(j -> arr[j])
                    .toArray();
            int total = Arrays.stream(slice).sum();
            double avg = total * 1.0 / len;
            int cnt = 0;
            for (int num : slice) {
                if (num > avg) {
                    cnt += 1;
                }
            }

            String result = String.format("%.3f%%\n", (cnt * 100.0 / len) );
            bw.write(result);
        }

        bw.flush();
        br.close();
    }
}
