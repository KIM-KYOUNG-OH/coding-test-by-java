package dongbinNa.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class NumberCardGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] ss = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(ss[j]);
            }
        }

        ArrayList<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int min = Arrays.stream(graph[i]).min().getAsInt();
            candidates.add(min);
        }
        candidates.sort(Comparator.reverseOrder());

        bw.write(String.valueOf(candidates.get(0)));

        bw.close();
        br.close();
    }
}
