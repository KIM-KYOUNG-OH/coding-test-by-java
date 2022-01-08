package programmers.dp;

import java.util.Arrays;
import java.util.Collections;

/**
 * 1차: 통과, get last index in array, get max value in array 참고
 */
public class IntegerTriangle {
    public int solution(int[][] triangle) {
        int len = triangle.length;

        int[][] dp = new int[len][];
        for(int i = 0; i < len; i++) {
            dp[i] = new int[i + 1];
        }

        for(int i = 0; i < len; i++) {
            if(i == 0){
                dp[0][0] = triangle[0][0];
                continue;
            }

            for(int j = 0; j < i + 1; j++) {
               if(j == 0) {
                   dp[i][j] = dp[i - 1][0] + triangle[i][0];
               }else if(j == i) {
                   dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
               }else {
                   dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
               }
            }
        }
        int max = -1;
        for(int i = 0; i < dp[len - 1].length; i++) {
            if(dp[len - 1][i] > max) {
                max = dp[len - 1][i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        IntegerTriangle s = new IntegerTriangle();
        System.out.println(s.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}
