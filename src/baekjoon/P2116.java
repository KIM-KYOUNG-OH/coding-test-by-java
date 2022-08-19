package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2116 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dices = new int[n][6];
        for(int i = 0; i < n; i++) {
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            dices[i] = nums;
        }

        int answer = 0;
        for(int i = 1; i <= 6; i++) {
            int max = 0;
            int up = i;
            for(int j = 0; j < n; j++) {
                int downIdx = 0;
                for(int k = 0; k < 6; k++) {
                    if(dices[j][k] == up) {
                        downIdx = k;
                        break;
                    }
                }
                int upIdx = opposite(downIdx);
                up = dices[j][upIdx];
                int temp = 0;
                for(int k = 0; k < 6; k++) {
                    if(k != downIdx && k != upIdx) {
                        temp = Math.max(temp, dices[j][k]);
                    }
                }
                max += temp;
            }

            answer = Math.max(answer, max);
        }

        System.out.println(answer);

        br.close();
    }

    private static int opposite(int idx) {
        switch (idx) {
            case 0:
                return 5;
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 0;
        }

        return 0;
    }
}
