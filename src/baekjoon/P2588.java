package baekjoon;

import java.io.*;

public class P2588 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int first = b % 10;
        int second = (b % 100) / 10;
        int third = b / 100;

        bw.write(first * a + "\n");
        bw.write(second * a + "\n");
        bw.write(third * a + "\n");
        bw.write(b * a + "\n");

        bw.flush();
        br.close();
    }
}
