package baekjoon_2024;

import java.io.*;
import java.util.Arrays;

public class P1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = s[0];
            int y1 = s[1];
            int r1 = s[2];
            int x2 = s[3];
            int y2 = s[4];
            int r2 = s[5];
            int distancePow = (int) (Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));

            int answer = 0;
            if (distancePow == 0 && r1 == r2) {
                answer = -1;
            } else if (distancePow > Math.pow(r1 + r2, 2)) {
                answer = 0;
            } else if (distancePow == Math.pow(r1 + r2, 2)) {
                answer = 1;
            } else if (distancePow == Math.pow(r2 - r1, 2)) {
                answer = 1;
            } else if (distancePow < Math.pow(r2 - r1, 2)) {
                answer = 0;
            } else {
                answer = 2;
            }

            bw.write(answer + "\n");
        }

        bw.close();
        br.close();
    }
}
