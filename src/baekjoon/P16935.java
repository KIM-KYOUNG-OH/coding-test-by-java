package baekjoon;

import java.io.*;
import java.util.Arrays;

public class P16935 {
    static int n;
    static int m;
    static int r;
    static int[][] matrix;
    static int[][] rotateMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        r = Integer.parseInt(s[2]);
        matrix = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] ss = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(ss[j]);
            }
        }

        String s2 = br.readLine();
        int[] operations;
        if(s2.length() == 1) {
            operations = new int[]{Integer.parseInt(s2)};
        } else {
            operations = Arrays.stream(s2.split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int operation : operations) {
            if(operation == 1) {
                switchUpDown();
            } else if(operation == 2) {
                switchLeftRight();
            } else if(operation == 3) {
                rotateRight();
            } else if(operation == 4) {
                rotateLeft();
            }  else if(operation == 5) {
                switchClockwise();
            }  else if(operation == 6) {
                switchCounterClockwise();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(j == m - 1) {
                    bw.write(matrix[i][j] + "\n");
                } else {
                    bw.write(matrix[i][j] + " ");
                }
            }
        }

        br.close();
        bw.close();
    }

    private static void switchCounterClockwise() {
        rotateMatrix = new int[n][m];

        // 영역1
        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < m / 2; j++) {
                rotateMatrix[i + n / 2][j] = matrix[i][j];
            }
        }

        // 영역2
        for(int i = 0; i < n / 2; i++) {
            for(int j = m / 2; j < m; j++) {
                rotateMatrix[i][j - m / 2] = matrix[i][j];
            }
        }

        // 영역3
        for(int i = n / 2; i < n; i++) {
            for(int j = m / 2; j < m; j++) {
                rotateMatrix[i - n / 2][j] = matrix[i][j];
            }
        }

        // 영역4
        for(int i = n / 2; i < n; i++) {
            for(int j = 0; j < m / 2; j++) {
                rotateMatrix[i][j + m / 2] = matrix[i][j];
            }
        }

        matrix = rotateMatrix;
    }

    private static void switchClockwise() {
        rotateMatrix = new int[n][m];

        // 영역1
        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < m / 2; j++) {
                rotateMatrix[i][j + m / 2] = matrix[i][j];
            }
        }

        // 영역2
        for(int i = 0; i < n / 2; i++) {
            for(int j = m / 2; j < m; j++) {
                rotateMatrix[i + n / 2][j] = matrix[i][j];
            }
        }

        // 영역3
        for(int i = n / 2; i < n; i++) {
            for(int j = m / 2; j < m; j++) {
                rotateMatrix[i][j - m / 2] = matrix[i][j];
            }
        }

        // 영역4
        for(int i = n / 2; i < n; i++) {
            for(int j = 0; j < m / 2; j++) {
                rotateMatrix[i - n / 2][j] = matrix[i][j];
            }
        }

        matrix = rotateMatrix;
    }

    private static void rotateLeft() {
        rotateMatrix = new int[m][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                rotateMatrix[m - 1 - j][i] = matrix[i][j];
            }
        }

        int temp = n;
        n = m;
        m = temp;
        matrix = rotateMatrix;
    }

    private static void rotateRight() {
        rotateMatrix = new int[m][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                rotateMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }

        int temp = n;
        n = m;
        m = temp;
        matrix = rotateMatrix;
    }

    private static void switchLeftRight() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m / 2; j++) {
                int temp = matrix[i][j];
                int opposite = matrix[i][m - 1 - j];
                matrix[i][j] = opposite;
                matrix[i][m - 1 - j] = temp;
            }
        }
    }

    private static void switchUpDown() {
        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < m; j++) {
                int temp = matrix[i][j];
                int opposite = matrix[n - 1 - i][j];
                matrix[i][j] = opposite;
                matrix[n - 1 - i][j] = temp;
            }
        }
    }
}
