package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1022 {
    static int[][] matrix;
    static int[] dy = new int[]{0, -1, 0, 1};
    static int[] dx = new int[]{1, 0, -1, 0};
    static int r1;
    static int c1;
    static int r2;
    static int c2;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        r1 = Integer.parseInt(s[0]);
        c1 = Integer.parseInt(s[1]);
        r2 = Integer.parseInt(s[2]);
        c2 = Integer.parseInt(s[3]);
        max = 0;

        matrix = new int[r2 - r1 + 1][c2 - c1 + 1];

        fillMatrix();
        print();

        br.close();
    }

    private static void fillMatrix() {
        int y = 0;
        int x = 0;
        int direction = 0;
        int num = 1;
        int dnum = 1;
        int cnt = 0;
        
        while(!isFinish()) {
            if(r1 <= y && y <= r2 && c1 <= x && x <= c2) {
                matrix[y - r1][x - c1] = num;
            }

            num++;
            cnt++;
            y = y + dy[direction];
            x = x + dx[direction];
            if(cnt == dnum) {
                cnt = 0;
                if(direction == 1 || direction == 3) dnum++;
                direction = (direction + 1) % 4;
            }
        }

        max = num - 1;
    }

    private static boolean isFinish() {
        return matrix[0][0] != 0 && matrix[r2 - r1][0] != 0 && matrix[0][c2 - c1] != 0 && matrix[r2 - r1][c2 - c1] != 0;
    }

    private static void print() {
        int maxLength = String.valueOf(max).length();
        for(int i = 0; i <= r2 - r1; i++) {
            for(int j = 0; j <= c2 - c1; j++) {
                String num = String.valueOf(matrix[i][j]);
                for(int k = 0; k < maxLength - num.length(); k++) {
                    System.out.print(" ");
                }
                if(j == c2 - c1) {
                    System.out.print(num);
                } else {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
        }
    }
}
