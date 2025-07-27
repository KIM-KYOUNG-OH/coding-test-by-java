package baekjoon_2025;

import java.io.*;

public class P1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        String[] arr = s.split("-");
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            String part = arr[i];
            String[] exp = part.split("\\+");
            int temp = 0;
            for (int j = 0; j < exp.length; j++) {
                int number = Integer.parseInt(exp[j]);
                temp += number;
            }

            if (i == 0) {
                answer += temp;
                continue;
            }

            answer -= temp;
        }

        bw.write(answer + "");
        bw.flush();
    }
}
