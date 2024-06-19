package baekjoon;

import java.io.*;

public class P1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        int current = n;

        while (true) {
            if (result != 0 && current == n) {
                break;
            }
            result += 1;

            if (current < 10) {
                current = current * 10 + current;
                continue;
            }

            int first = (current % 10) * 10;
            int second = 0;
            String temp = String.valueOf(current);
            for (int i = 0; i < temp.length(); i++) {
                second += Integer.parseInt(temp.substring(i, i + 1));
            }
            second %= 10;
            current = first + second;
        }

        bw.write(String.valueOf(result));

        bw.flush();
        br.close();
    }
}
