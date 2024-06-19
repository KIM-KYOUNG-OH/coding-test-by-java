package baekjoon;

import java.io.*;

public class P11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int num = Integer.parseInt(s.substring(i, i + 1));
            result += num;
        }

        bw.write(String.valueOf(result));

        bw.flush();
        br.close();
    }
}
