package dongbinNa.greedy;

import java.io.*;

public class UntilBecomeOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int answer = 0;
        while (n != 1) {
            answer++;

            if (n % k == 0) {
                n /= k;
            } else {
                n -= 1;
            }
        }

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}
