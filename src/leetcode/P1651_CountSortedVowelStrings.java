package leetcode;

public class P1651_CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        int[][] memo = new int[51][5];
        memo[1] = new int[]{1, 1, 1, 1, 1};
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 5; j++) {
                if(j == 0) {
                    memo[i][j] = 1;
                    continue;
                }
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }

        int result = 0;
        for(int i = 0; i < 5; i++) {
            result += memo[n][i];
        }

        return result;
    }
}
