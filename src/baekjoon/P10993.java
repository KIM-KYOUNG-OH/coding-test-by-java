package baekjoon;

import java.io.*;

public class P10993 {
    static char[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(n == 1) {
            System.out.println("*");
            return;
        }

        matrix = new char[][]{{'*'}};
        recursive(n, 2, 1, 1);

        if(n % 2 == 0) {
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length - i; j++) {
                    bw.write(matrix[i][j]);
                }
                bw.write("\n");
            }
        } else {
            int midX = matrix[0].length / 2;
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j <= midX + i; j++) {
                    bw.write(matrix[i][j]);
                }
                bw.write("\n");
            }
        }

        br.close();
        bw.close();
    }

    private static void recursive(int n, int cur, int prevR, int prevC) {
        if(n < cur) return;

        int curR = prevR + (int) Math.pow(2, cur - 1);
        int curC = prevC + (int) Math.pow(2, cur);
        boolean isTriangle;
        if(cur % 2 == 0) {
            isTriangle = false;
        } else {
            isTriangle = true;
        }

        char[][] temp = new char[curR][curC];
        for(int i = 0; i < curR; i++) {
            for(int j = 0; j < curC; j++) {
                temp[i][j] = ' ';
            }
        }

        int midY = curR / 2;
        int midX = curC / 2;
        int startY;
        int startX;
//        System.out.println("midY = " + midY);
//        System.out.println("midX = " + midX);
//        System.out.println("prevR = " + prevR);
//        System.out.println("prevC = " + prevC);
        if(isTriangle) {
            startY = midY;
            startX = midX - prevC / 2;
        } else {
            startY = midY - prevR + 1;
            startX = midX - prevC / 2;
        }
//        System.out.println("startY = " + startY);
//        System.out.println("startX = " + startX);
//
        for(int i = 0; i < prevR; i++) {
            for(int j = 0; j < prevC; j++) {
                temp[startY + i][startX + j] = matrix[i][j];
            }
        }

        if(isTriangle) {
            // 왼쪽 대각
            for(int k = 0; k < curR; k++) {
                temp[curR  - 1 - k][k] = '*';
            }

            // 오른쪽 대각
            for(int k = 0; k < curR; k++) {
                temp[k][midX + k] = '*';
            }

            // 밑면
            for(int k = 0; k < curC; k++) {
                temp[curR - 1][k] = '*';
            }
        } else {
            // 윗면
            for(int k = 0; k < curC; k++) {
                temp[0][k] = '*';
            }

            // 왼쪽 대각
            for(int k = 0; k < curR; k++) {
                temp[k][k] = '*';
            }

            // 오른쪽 대각
            for(int k = 0; k < curR; k++) {
                temp[curR - 1 - k][midX + k] = '*';
            }
        }

//        System.out.println("curR = " + curR);
//        System.out.println("curC = " + curC);
//        for(int i = 0; i < curR; i++) {
//            for(int j = 0; j < curC; j++) {
//                System.out.print(temp[i][j]);
//            }
//            System.out.println();
//        }

        matrix = temp;
        recursive(n, cur + 1, curR, curC);
    }
}
