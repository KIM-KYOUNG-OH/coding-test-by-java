package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16967 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int h = Integer.parseInt(s[0]);
        int w = Integer.parseInt(s[1]);
        int x = Integer.parseInt(s[2]);
        int y = Integer.parseInt(s[3]);

        int[][] a = new int[h][w];
        int[][] b = new int[h + x][w + y];
        for(int i = 0; i < h + x; i++) {
            String[] ss = br.readLine().split(" ");
            for(int j = 0; j < w + y; j++) {
                b[i][j] = Integer.parseInt(ss[j]);
            }
        }

        for(int i = 0; i < h + x; i++) {
            for(int j = 0; j < w + y; j++) {
                if((i < x && j < w) || (j < y && i < h)) {
                    a[i][j] = b[i][j];
                } else if(i >= x && j >= y && j < w && i < h) {
                    a[i][j] = b[i][j] - a[i - x][j - y];
                }
            }
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(j == w - 1) {
                    System.out.print(a[i][j] + "\n");
                } else {
                    System.out.print(a[i][j] + " ");
                }
            }
        }

        br.close();
    }
}
