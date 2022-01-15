package programmers.graph;

/**
 * 1차: solution 참고
 */
public class Rank {
    // 플로이드 워셜 알고리즘
    public int solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n + 1][n + 1];
        int answer = 0;
        for(int i = 1; i < results.length + 1; i++) {
            graph[results[i][0]][results[i][1]] = true;
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                for(int k = 1; k < n + 1; k++) {
                    if(graph[j][i] && graph[i][k]) {
                        graph[j][k] = true;
                    }
                }
            }
        }

        for(int i = 1; i < n + 1; i++) {
            int result = 0;
            for(int j = 1; j < n + 1; j++) {
                if(graph[i][j] || graph[j][i]) result++;
            }
            if(result == n - 1) answer++;
        }

        return answer;
    }
}
