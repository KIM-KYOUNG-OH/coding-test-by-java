package baekjoon_2024;

import java.io.*;

public class P2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int b3 = b % 10;
        int b2 = (b % 100) / 10;
        int b1 = b / 100;

        int result1 = a * b3;
        int result2 = a * b2;
        int result3 = a * b1;
        int result4 = a * b;

        bw.write(String.valueOf(result1) + "\n");
        bw.write(String.valueOf(result2) + "\n");
        bw.write(String.valueOf(result3) + "\n");
        bw.write(String.valueOf(result4));

        bw.close();
        br.close();
    }
}
