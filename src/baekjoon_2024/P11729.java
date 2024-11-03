package baekjoon_2024;

import java.io.*;

public class P11729 {
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        sb.append((int) Math.pow(2, n) - 1);
        sb.append("\n");

        hanoi(n, 1, 2, 3);
        bw.write(sb.toString());

        bw.close();
        br.close();
    }

    private static void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            sb.append(start);
            sb.append(" ");
            sb.append(end);
            sb.append("\n");
            return;
        }

        hanoi(n - 1, start, end, mid);

        sb.append(start);
        sb.append(" ");
        sb.append(end);
        sb.append("\n");

        hanoi(n - 1, mid, start, end);
    }
}
