package baekjoon;

import java.io.*;

public class P17827 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int v = Integer.parseInt(s[2]);
        int[] matrix = new int[n + 1];
        s = br.readLine().split(" ");
        for(int i = 1; i <= n; i++) {
            matrix[i] = Integer.parseInt(s[i - 1]);
        }

        for(int i = 0; i < m; i++) {
            int k = Integer.parseInt(br.readLine());
            if(k < v) {
                bw.write(matrix[k + 1] + "\n");
            } else {
                k = k - v + 1;
                int len = n - v + 1;
                k %= len;
                bw.write(matrix[k + v] + "\n");
            }
        }

        bw.close();
        br.close();
    }
}
