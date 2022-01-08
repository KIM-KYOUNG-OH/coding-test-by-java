package programmers.dp;

/**
 * 1차: 통과
 */
public class WayToSchool {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] matrix = new int[n + 1][m + 1];
        matrix[1][1] = 1;

        for (int[] puddle : puddles) {
            int y = puddle[1];
            int x = puddle[0];
            matrix[y][x] = -1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;
                if(matrix[i][j] == -1) continue;

                int up = matrix[i - 1][j];
                if(up == -1) up = 0;
                int left = matrix[i][j - 1];
                if(left == -1) left = 0;
                matrix[i][j] = (up + left) % 1000000007;
            }
        }

        answer = matrix[n][m];

        return answer;
    }

    public static void main(String[] args) {
        WayToSchool s = new WayToSchool();
        System.out.println(s.solution(4, 3, new int[][]{{2, 2}}));
    }
}
