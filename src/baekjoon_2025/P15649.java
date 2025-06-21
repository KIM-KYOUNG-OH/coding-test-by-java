package baekjoon_2025;

import java.io.*;
import java.util.*;

public class P15649 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int n;
    private static int m;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        boolean[] visit = new boolean[n + 1];

        dfs(visit, new LinkedList<>());
        bw.flush();
    }

    private static void dfs(boolean[] visit, Deque<Integer> cur) throws IOException {
        if (cur.size() == m) {
            cur.stream().forEach(a -> {
                try {
                    bw.write(a + " ");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                cur.add(i);
                dfs(visit, cur);
                cur.removeLast();
                visit[i] = false;
            }
        }
    }

}
