public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        int n = matrix.length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = i * 5 + j + 1;
            }
        }

        for(int i = 0; i < n / 2; i++) {
            int op = n - 1 - i;
            int times = n - 2 * i - 1;
            for(int j = 0; j < times; j++) {
                int temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[op - j][i];
                matrix[op - j][i] = matrix[op][op - j];
                matrix[op][op - j] = matrix[i + j][op];
                matrix[i + j][op] = temp;
            }
        }

        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
