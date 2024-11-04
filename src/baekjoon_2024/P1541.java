package baekjoon_2024;

import java.io.*;

public class P1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] operators = {"-", "+"};
        boolean hasMinus = false;
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String ch = s.substring(i, i + 1);
            if (ch.equals("-")) {
                if (hasMinus) answer -= Integer.parseInt(sb.toString());
                else answer += Integer.parseInt(sb.toString());

                hasMinus = true;
                sb.delete(0, sb.length());
            } else if (ch.equals("+")) {
                if (hasMinus) answer -= Integer.parseInt(sb.toString());
                else answer += Integer.parseInt(sb.toString());

                sb.delete(0, sb.length());
            } else {
                sb.append(ch);
            }
        }

        if (hasMinus) answer -= Integer.parseInt(sb.toString());
        else answer += Integer.parseInt(sb.toString());

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
