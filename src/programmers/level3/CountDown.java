package programmers.level3;

import java.util.HashSet;
import java.util.Set;

public class CountDown {
    public int[] solution(int target) {
        int[][] dp = new int[target + 1][2];
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= 20; i++) {
            set.add(i);
            set.add(i * 2);
            set.add(i * 3);
        }
        set.add(50);

        for(int i = 1; i <= Math.min(target, 60); i++) {
            if(set.contains(i)) {
                dp[i][0] = 1;
                if(i <= 20 || i == 50) {
                    dp[i][1] = 1;
                }
            } else if(i <= 40 || i > 50){
                dp[i][0] = 2;
                dp[i][1] = 2;
            } else {
                dp[i][0] = 2;
                dp[i][1] = 1;
            }
        }

        for(int i = 61; i <= target; i++) {
            if(dp[i - 50][0] <= dp[i - 60][0]) {
                dp[i][0] = dp[i - 50][0] + 1;
                dp[i][1] = dp[i - 50][1] + 1;
            } else {
                dp[i][0] = dp[i - 60][0] + 1;
                dp[i][1] = dp[i - 60][1];
            }
        }

        return dp[target];
    }
}
