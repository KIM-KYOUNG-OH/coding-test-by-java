package baekjoon_2024;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P15650 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0];
        int m = s[1];
        boolean[] visit = new boolean[n + 1];
        List<Integer> container = new ArrayList<>();
        recursive(n, m, 0, visit, container);

        bw.close();
        br.close();
    }

    private static void recursive(int n, int m, int depth, boolean[] visit, List<Integer> container) throws IOException {
        if (depth == m) {
            for (Integer num : container) {
                bw.write(num + " ");
            }
            bw.write("\n");

            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visit[i]) continue;
            else if (container.size() > 0 && Collections.max(container) >= i) continue;
            visit[i] = true;
            container.add(i);
            recursive(n, m, depth + 1, visit, container);
            visit[i] = false;
            container.remove(depth);
        }
    }
}
