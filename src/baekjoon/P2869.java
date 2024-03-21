package baekjoon;

import java.io.*;
import java.util.Arrays;

public class P2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int a = arr[0];
        int b = arr[1];
        int v = arr[2];

        v -= a;
        if (v <= 0) {
            bw.write("1");
            return;
        }

        if (v % (a - b) == 0) {
            bw.write(String.valueOf(v / (a - b) + 1));
        } else {
            bw.write(String.valueOf(v / (a - b) + 2));
        }

        bw.flush();
        br.close();
    }
}
