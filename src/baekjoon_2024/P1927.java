package baekjoon_2024;

import java.io.*;
import java.util.PriorityQueue;

public class P1927 {
    private static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) {
                    bw.write("0");
                } else {
                    bw.write(String.valueOf(pq.poll()));
                }
                bw.write("\n");
                continue;
            }

            pq.add(num);
        }

        bw.close();
        br.close();
    }
}
