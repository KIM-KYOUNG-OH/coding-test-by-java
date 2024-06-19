package baekjoon;

import java.io.*;

public class P10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        for (int i = 0; i < 26; i++) {
            int idx = s.indexOf(('a' + i));
            bw.write(idx + " ");
        }

        bw.flush();
        br.close();
    }
}
