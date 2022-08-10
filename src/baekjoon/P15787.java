package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P15787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] trains = new int[n + 1][21];

        // m 번 작업
        for(int i = 0; i < m; i++) {
            int[] order = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            switch (order[0]) {
                case 1:  // 탑승
                    if(trains[order[1]][order[2]] == 0) {
                        trains[order[1]][order[2]] = 1;
                    }
                    break;

                case 2:  // 하차
                    if(trains[order[1]][order[2]] == 1) {
                        trains[order[1]][order[2]] = 0;
                    }
                    break;

                case 3:  // 한 칸씩 뒤로
                    for(int j = 20; j >= 2; j--) {
                        trains[order[1]][j] = trains[order[1]][j - 1];
                    }
                    trains[order[1]][1] = 0;
                    break;

                case 4:  // 한 칸씩 앞으로
                    for(int j = 1; j <= 19; j++) {
                        trains[order[1]][j] = trains[order[1]][j + 1];
                    }
                    trains[order[1]][20] = 0;

                    break;
            }
        }

        // 은하수를 건너
        Set<String> set = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j <= 20; j++) {
                sb.append(trains[i][j]);
            }
            String train = sb.toString();
            set.add(train);
        }

        System.out.println(set.size());

        br.close();
    }
}
