package baekjoon_2024;

import java.io.*;
import java.util.Arrays;

public class P1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[i] = s;
        }
        int[] dpRed = new int[n];
        int[] dpGreen = new int[n];
        int[] dpBlue = new int[n];
        dpRed[0] = arr[0][0];
        dpGreen[0] = arr[0][1];
        dpBlue[0] = arr[0][2];
        for (int i = 1; i < n; i++) {
            dpRed[i] = Math.min(dpGreen[i - 1], dpBlue[i - 1]) + arr[i][0];
            dpGreen[i] = Math.min(dpRed[i - 1], dpBlue[i - 1]) + arr[i][1];
            dpBlue[i] = Math.min(dpRed[i - 1], dpGreen[i - 1]) + arr[i][2];
        }

        int answer = Math.min(dpGreen[n - 1], dpRed[n - 1]);
        answer = Math.min(answer, dpBlue[n - 1]);
        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}
