package programmers.level2;

public class Fatigue {
    boolean[] visited;
    int answer;

    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];

        dfs(0, k, dungeons);

        return answer;
    }

    private void dfs(int cnt, int k, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && (dungeons[i][0] <= k)) {
                visited[i] = true;
                dfs(cnt + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }

        answer = Math.max(answer, cnt);
    }
}
