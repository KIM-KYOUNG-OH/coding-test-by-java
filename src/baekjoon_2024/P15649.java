package baekjoon_2024;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15649 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0];
        int m = s[1];
        boolean[] visit = new boolean[n + 1];
        int[] number = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            number[i] = i;
        }

        recursive(n, m, number, visit, 0, new ArrayList<>());

        bw.close();
        br.close();
    }

    private static void recursive(int n, int m, int[] number, boolean[] visit, int len, List<Integer> container) throws IOException {
        if (len == m) {
            for (Integer num : container) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            container.add(i);
            recursive(n, m, number, visit, len + 1, container);
            container.remove(len);
            visit[i] = false;
        }
    }
}
