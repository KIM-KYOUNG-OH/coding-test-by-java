package programmers.level2;

public class Friends4Block {
    char[][] matrix;

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        matrix = new char[m][n];

        for(int i = 0; i < m; i++) {
            matrix[i] = board[i].toCharArray();
        }

        while(true) {
            boolean[][] check = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(matrix[i][j] != '*') {
                        checkBlock(check, m, n, i, j);
                    }
                }
            }

            int delCnt = dropCheckBlock(check, m, n);
            if(delCnt == 0) break;
            answer += delCnt;
        }

        return answer;
    }

    private int dropCheckBlock(boolean[][] check, int m, int n) {
        int cnt = 0;

        for(int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) {
                if(!check[i][j]) continue;
                cnt++;
                for(int k = i; k >= 0; k--) {
                    if(k == 0) matrix[k][j] = '*';
                    else matrix[k][j] = matrix[k - 1][j];
                }
            }
        }

        return cnt;
    }

    private void checkBlock(boolean[][] check, int m, int n, int y, int x) {
        int[] dy = new int[]{0, 0, 1, 1}, dx = new int[]{0, 1, 0, 1};

        for(int i = 1; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || m <= ny || nx < 0 || n <= nx || matrix[ny][nx] != matrix[y][x]) {
                return;
            }
        }

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            check[ny][nx] = true;
        }
    }

}
