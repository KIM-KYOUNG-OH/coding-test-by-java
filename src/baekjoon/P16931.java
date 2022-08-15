package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] ss = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(ss[j]);
            }
        }

        int answer = 0;
        // 아래
        answer += n * m;

        // 왼쪽
        for(int i = 0; i < n; i++) {
            answer += matrix[i][0];
            for(int j = 1; j < m; j++) {
                if(matrix[i][j] > matrix[i][j - 1]) {
                    answer += matrix[i][j] - matrix[i][j - 1];
                }
            }
        }

        // 오른쪽
        for(int i = 0; i < n; i++) {
            answer += matrix[i][m - 1];
            for(int j = m - 2; j >= 0; j--) {
                if(matrix[i][j] > matrix[i][j + 1]) {
                    answer += matrix[i][j] - matrix[i][j + 1];
                }
            }
        }

        // 앞쪽
        for(int j = 0; j < m; j++) {
            answer += matrix[n - 1][j];
            for(int i = n - 2; i >= 0; i--) {
                if(matrix[i][j] > matrix[i + 1][j]) {
                    answer += matrix[i][j] - matrix[i + 1][j];
                }
            }
        }

        // 뒤쪽
        for(int j = 0; j < m; j++) {
            answer += matrix[0][j];
            for(int i = 1; i < n; i++) {
                if(matrix[i][j] > matrix[i - 1][j]) {
                    answer += matrix[i][j] - matrix[i - 1][j];
                }
            }
        }

        // 위쪽
        answer += n * m;

        System.out.println(answer);

        br.close();
    }
}
