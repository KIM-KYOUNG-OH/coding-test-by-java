package programmers.dp;

/**
 * 1차: solution 참고
 */
public class ExpressByN {
    static int answer = -1;

    private void dfs(int n, int target, int count, int cur) {
        if(count > 8) return;

        if(cur == target) {
            if(answer == -1) {
                answer = count;
            }else {
                answer = Math.min(count, answer);
            }
        }

        int nn = 0;
        for(int i = 0; i < 8; i++) {
            nn = nn * 10 + n;
            dfs(n, target, count + 1 + i, cur + nn);
            dfs(n, target, count + 1 + i, cur - nn);
            dfs(n, target, count + 1 + i, cur * nn);
            dfs(n, target, count + 1 + i, cur / nn);
        }
    }

    public int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return answer;
    }
}
