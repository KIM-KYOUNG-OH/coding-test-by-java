package baekjoon_2025;

import java.io.*;
import java.util.Arrays;

public class P15650 {
    private static int n;
    private static int m;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        boolean[] visit = new boolean[n];
        int[] container = new int[m];

        dfs(visit, container, 0);
        bw.flush();
    }

    private static void dfs(boolean[] visit, int[] container, int depth) throws IOException {

        if (depth == m) {
            for (int num : container) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (depth >= 1 && i + 1 <= container[depth - 1]) continue;

            if (!visit[i]) {
                visit[i] = true;
                container[depth] = i + 1;
                dfs(visit, container, depth + 1);
                visit[i] = false;
            }
        }
    }
}
