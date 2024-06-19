package baekjoon;

import java.io.*;

public class P2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int h = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        m -= 45;
        if (m < 0) {
            h -= 1;
            m += 60;
        }

        if (h < 0) {
            h += 24;
        }

        bw.write(h + " " + m);

        bw.flush();
        br.close();
    }
}
