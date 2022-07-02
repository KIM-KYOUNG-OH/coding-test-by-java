package programmers.level2;

public class RotateMatrixBorder {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows + 1][columns + 1];
        for(int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                matrix[i][j] = (i - 1) * columns + j;
            }
        }


        for (int q = 0; q < queries.length; q++) {

            int x1 = queries[q][0];
            int y1 = queries[q][1];
            int x2 = queries[q][2];
            int y2 = queries[q][3];

            int min = matrix[x1][y1];
            int init = matrix[x1][y1];
            for (int i = 0; i < x2 - x1; i++) {
                matrix[x1 + i][y1] = matrix[x1 + i + 1][y1];
                min = Math.min(min, matrix[x1 + i][y1]);
            }

            for(int i = 0; i < y2 - y1; i++) {
                matrix[x2][y1 + i] = matrix[x2][y1 + i + 1];
                min = Math.min(min, matrix[x2][y1 + i]);
            }

            for(int i = 0 ; i < x2 - x1; i++) {
                matrix[x2 - i][y2] = matrix[x2 - i - 1][y2];
                min = Math.min(min, matrix[x2 - i][y2]);
            }

            for (int i = 0; i < y2 - y1 - 1; i++) {
                matrix[x1][y2 - i] = matrix[x1][y2 - i - 1];
                min = Math.min(min, matrix[x1][y2 - i]);
            }

            matrix[x1][y1 + 1] = init;

            answer[q] = min;

            printMatrix(rows, columns, matrix);
            System.out.println();
        }

        return answer;
    }

    private void printMatrix(int rows, int columns, int[][] matrix) {
        for (int i = 1; i < rows + 1; i++) {
            for(int j = 1; j < columns + 1; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RotateMatrixBorder s = new RotateMatrixBorder();
        s.solution(100, 97, new int[][]{{1, 1, 100, 97}});
    }

}
