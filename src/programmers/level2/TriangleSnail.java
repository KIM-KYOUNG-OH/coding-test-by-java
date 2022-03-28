package programmers.level2;

public class TriangleSnail {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];

        boolean[][] visited = new boolean[n + 1][n];
        int[][] matrix = new int[n + 1][n];
        visited[0][0] = true;
        int y = 0, x = 0;
        int cur = 1;
        int[] dy = {1, 0, -1};
        int[] dx = {0, 1, -1};

        while(n > 0) {
            for(int i = 0; i < 3; i++) {
                boolean breaker = false;
                for(int j = 0; j < n; j++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if(visited[ny][nx]) {
                        breaker = true;
                        break;
                    }

                    matrix[ny][nx] = cur;
                    visited[ny][nx] = true;
                    cur++;
                }

                n--;
                if (breaker) break;
            }
        }

        int idx = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                answer[idx] = matrix[i][j];
                idx++;
            }
        }

        return answer;
    }
}
