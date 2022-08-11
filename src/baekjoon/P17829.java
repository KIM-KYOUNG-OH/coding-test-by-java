package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P17829 {
    static int n;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(s[j]);
            }
        }

        System.out.println(recursive(0, 0, n));

        br.close();
    }

    private static int recursive(int i, int j, int size) {
        int[] arr = new int[4];
        if(size == 2) {
            int idx = 0;
            for(int r = i; r < i + 2; r++) {
                for(int c = j; c < j + 2; c++) {
                    arr[idx++] = matrix[r][c];
                }
            }
        } else {
            size = size / 2;

            arr[0] = recursive(i, j, size);
            arr[1] = recursive(i, j + size, size);
            arr[2] = recursive(i + size, j, size);
            arr[3] = recursive(i + size, j + size, size);
        }

        Arrays.sort(arr);
        return arr[2];
    }
}
