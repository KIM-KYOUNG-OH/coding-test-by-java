package baekjoon_2025;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int m = arr[1];
        int[][] edges = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int u = arr[0];
            int v = arr[1];
            edges[u][v] = 1;
            edges[v][u] = 1;
        }

        boolean[] visit = new boolean[n + 1];
        int result = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result++;
                q.add(i);

                while (!q.isEmpty()) {
                    int cur = q.poll();
                    for (int k = 1; k <= n; k++) {
                        if (edges[cur][k] == 1 && !visit[k]) {
                            visit[k] = true;
                            q.add(k);
                        }
                    }
                }
            }
        }

        bw.write(result + "");
        bw.flush();
    }
}
