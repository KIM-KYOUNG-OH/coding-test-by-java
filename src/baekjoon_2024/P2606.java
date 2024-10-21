package baekjoon_2024;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int l = Integer.parseInt(br.readLine());
        int[][] edge = new int[n + 1][n + 1];
        for (int i = 0; i < l; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = s[0];
            int b = s[1];
            edge[a][b] = 1;
            edge[b][a] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] visit = new boolean[n + 1];
        int answer = 0;
        visit[1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= n; i++) {
                if (edge[cur][i] == 0) continue;
                if (!visit[i]) {
                    visit[i] = true;
                    q.add(i);
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}
