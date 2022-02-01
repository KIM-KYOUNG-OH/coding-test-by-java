package programmers.level2;

public class RotateMatrixBorder {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows + 1][columns + 1];

        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                matrix[i][j] = (i - 1) * columns + j;
            }
        }

        int[] answer = new int[queries.length];
        for(int k = 0; k < queries.length; k++) {
            int y1 = queries[k][0];
            int x1 = queries[k][1];
            int y2 = queries[k][2];
            int x2 = queries[k][3];
            int diffY = y2 - y1;
            int diffX = x2 - x1;
            int temp = matrix[y2][x2];
            int min = temp;

            for(int i = 0; i < diffY; i++) {
                matrix[y2 - i][x2] = matrix[y2 - i - 1][x2];
                min = Math.min(min, matrix[y2 - i][x2]);
            }

            for(int i = 0; i < diffX; i++) {
                matrix[y1][x2 - i] = matrix[y1][x2 - i - 1];
                min = Math.min(min, matrix[y1][x2 - i]);
            }

            for(int i = 0; i < diffY; i++) {
                matrix[y1 + i][x1] = matrix[y1 + i + 1][x1];
                min = Math.min(min, matrix[y1 + i][x1]);
            }

            for(int i = 0; i < diffX - 1; i++) {
                matrix[y2][x1 + i] = matrix[y2][x1 + i + 1];
                min = Math.min(min, matrix[y2][x1 + i]);
            }

            matrix[y2][x2 - 1] = temp;
            answer[k] = min;
        }

        return answer;
    }

    public static void main(String[] args) {
        RotateMatrixBorder s = new RotateMatrixBorder();
        System.out.println(s.solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}));
    }
}
