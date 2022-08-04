package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class P5212 {
    static int r;
    static int c;
    static char[][] matrix;
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        matrix = new char[r][c];
        for(int i = 0; i < r; i++) {
            String ss = br.readLine();
            for(int j = 0; j < c; j++) {
                matrix[i][j] = ss.charAt(j);
            }
        }

        after50Years();

        char[][] temp = getMinimumMatrix();

        for(int i = 0; i < temp.length; i++) {
            for(int j = 0; j < temp[0].length; j++) {
                bw.write(temp[i][j]);
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }

    private static char[][] getMinimumMatrix() {
        int minR = 10;
        int minC = 10;
        int maxR = 0;
        int maxC = 0;
        List<Coordinate> list = new ArrayList<>();

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(matrix[i][j] == '.') continue;
                minR = Math.min(minR, i);
                maxR = Math.max(maxR, i);
                minC = Math.min(minC, j);
                maxC = Math.max(maxC, j);
                list.add(new Coordinate(i, j));
            }
        }

        int fixedR = maxR - minR + 1;
        int fixedC = maxC - minC + 1;
        char[][] result = new char[fixedR][fixedC];
        for(int i = 0; i < fixedR; i++) {
            for(int j = 0; j < fixedC; j++) {
                result[i][j] = '.';
            }
        }

        for (Coordinate coordinate : list) {
            result[coordinate.y - minR][coordinate.x - minC] = 'X';
        }

        return result;
    }

    private static void after50Years() {
        boolean[][] isSink = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(matrix[i][j] == 'X') {
                    int exposureCount = 0;
                    for(int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(0 <= ny && ny < r && 0 <= nx && nx < c) {
                            if(matrix[ny][nx] == '.') exposureCount++;
                        } else {
                            exposureCount++;
                        }
                    }

                    if(exposureCount >= 3) isSink[i][j] = true;
                }
            }
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(isSink[i][j]) matrix[i][j] = '.';
            }
        }
    }

    private static class Coordinate {
        int y;
        int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
