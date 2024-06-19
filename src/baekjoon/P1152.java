package baekjoon;

import java.io.*;

public class P1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine().trim();
        if (s.isEmpty()) {
            bw.write("0");
        } else {
            bw.write(String.valueOf(s.split(" ").length));
        }

        bw.flush();
        br.close();
    }
}
