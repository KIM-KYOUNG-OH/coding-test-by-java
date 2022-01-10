package programmers.dp;

/**
 * 1차: solution 참고, dpWhenStealFirst[1] = 0이면 [10, 2, 2, 100, 2] 반례 주의
 * 2차: 통과
 */
public class Steal {
    public int solution(int[] money) {
        int answer = 0;

        // dp[i] = i까지 최대값
        int[] dpWhenSkipFirst = new int[money.length];
        int[] dpWhenStealFirst = new int[money.length];

        dpWhenSkipFirst[0] = 0;
        dpWhenSkipFirst[1] = money[1];

        dpWhenStealFirst[0] = money[0];
        dpWhenStealFirst[1] = money[0];

        for(int i = 2; i < money.length; i++) {
            dpWhenSkipFirst[i] = Math.max(dpWhenSkipFirst[i - 1], dpWhenSkipFirst[i - 2] + money[i]);
            answer = Math.max(dpWhenSkipFirst[i], answer);

            if(i == money.length - 1) {
                dpWhenStealFirst[i] = Math.max(dpWhenStealFirst[i - 2], dpWhenStealFirst[i - 1]);
            }else {
                dpWhenStealFirst[i] = Math.max(dpWhenStealFirst[i - 1], dpWhenStealFirst[i - 2] + money[i]);
            }
            answer = Math.max(dpWhenStealFirst[i], answer);
        }

        return answer;
    }
}
