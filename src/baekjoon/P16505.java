package baekjoon;

import java.io.*;

public class P16505 {
    static char[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        matrix = new char[][]{{'*'}};

        if(n == 0) {
            System.out.println("*");
            return;
        }

        recursive(n);

        int l = matrix.length;
        for(int i = 0; i < l; i++) {
            for(int j = 0; j <= l; j++) {
                if(j >= l - i) {
                    bw.write("\n");
                    break;
                }
                bw.write(matrix[i][j]);
            }
        }

        bw.close();
    }

    private static void recursive(int n) {
        if(n == 0) return;

        int l = matrix.length;
        char[][] temp = new char[l * 2][l * 2];
        for(int i = 0; i < temp.length; i++) {
            for(int j = 0; j < temp.length; j++) {
                temp[i][j] = ' ';
            }
        }

//        System.out.println("l = " + l);
//        for(int i = 0; i < l; i++) {
//            for(int j = 0; j < l; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        // 복사
        for(int i = 0; i < l; i++) {
            for(int j = 0; j < l; j++) {
                temp[i][j] = matrix[i][j];
                temp[i][j + l] = matrix[i][j];
                temp[i + l][j] = matrix[i][j];
            }
        }

        matrix = temp;

        recursive(n - 1);
    }
}
