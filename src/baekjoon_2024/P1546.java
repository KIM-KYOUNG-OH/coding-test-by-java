package baekjoon_2024;

import java.io.*;
import java.util.Arrays;

public class P1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Arrays.stream(arr).max().getAsInt();
        double answer = Arrays.stream(arr).mapToDouble(a -> a * 100.0 / m).sum() / n;

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}
