package programmers.level2;

public class TriangleSnail {
//    public int[] solution(int n) {
//        int[] answer = new int[n * (n + 1) / 2];
//
//        boolean[][] visited = new boolean[n + 1][n];
//        int[][] matrix = new int[n + 1][n];
//        visited[0][0] = true;
//        int y = 0, x = 0;
//        int cur = 1;
//        int[] dy = {1, 0, -1};
//        int[] dx = {0, 1, -1};
//
//        while(n > 0) {
//            for(int i = 0; i < 3; i++) {
//                boolean breaker = false;
//                for(int j = 0; j < n; j++) {
//                    int ny = y + dy[i];
//                    int nx = x + dx[i];
//
//                    if(visited[ny][nx]) {
//                        breaker = true;
//                        break;
//                    }
//
//                    matrix[ny][nx] = cur;
//                    visited[ny][nx] = true;
//                    cur++;
//                }
//
//                n--;
//                if (breaker) break;
//            }
//        }
//
//        int idx = 0;
//        for(int i = 1; i < n; i++) {
//            for(int j = 0; j < i; j++) {
//                answer[idx] = matrix[i][j];
//                idx++;
//            }
//        }
//
//        return answer;
//    }

    static int[] dy = {1, 0, -1};
    static int[] dx = {0, 1, -1};

    public int[] solution(int n) {
        int[][] matrix = new int[n][n];
        int startY = -1;
        int startX = 0;
        int depth = n;
        int direction = 0;
        int seq = 1;
        while(depth > 0) {
            for(int i = 0; i < depth; i++) {
                int ny = startY + (i + 1) * dy[direction];
                int nx = startX + (i + 1) * dx[direction];
                matrix[ny][nx] = seq++;
            }

            startY += depth * dy[direction];
            startX += depth * dx[direction];
            direction = (direction + 1) % 3;
            depth--;
        }

        int[] answer = new int[(n * (n + 1)) / 2];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[idx++] = matrix[i][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        TriangleSnail s = new TriangleSnail();
        s.solution(6);
    }
}
