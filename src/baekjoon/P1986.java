package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1986 {
    static int[] dyQueen = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dxQueen = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dyKnight = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};
    static int[] dxKnight = new int[]{2, 2, 1, -1, -2, -2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        char[][] matrix = new char[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                matrix[i][j] = 'Y';
            }
        }
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int t = nums[0];
        for(int i = 1; i < t * 2; i = i + 2) {
            int r = nums[i];
            int c = nums[i + 1];
            matrix[r][c] = 'Q';
        }

        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        t = nums[0];
        for(int i = 1; i < t * 2; i = i + 2) {
            int r = nums[i];
            int c = nums[i + 1];
            matrix[r][c] = 'K';
        }

        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        t = nums[0];
        for(int i = 1; i < t * 2; i = i + 2) {
            int r = nums[i];
            int c = nums[i + 1];
            matrix[r][c] = 'P';
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(matrix[i][j] == 'Q') {
                    for(int k = 0; k < 8; k++) {
                        int l = 0;
                        while(true) {
                            l++;
                            int ny = i + dyQueen[k] * l;
                            int nx = j + dxQueen[k] * l;
                            if(0 < ny && ny <= n && 0 < nx && nx <= m) {
                                if(matrix[ny][nx] == 'P' || matrix[ny][nx] == 'K' || matrix[ny][nx] == 'Q') break;
                                matrix[ny][nx] = 'N';
                            } else {
                                break;
                            }
                        }
                    }
                } else if(matrix[i][j] == 'K') {
                    for(int k = 0; k < 8; k++) {
                        int ny = i + dyKnight[k];
                        int nx = j + dxKnight[k];
                        if(0 < ny && ny <= n && 0 < nx && nx <= m && matrix[ny][nx] == 'Y') {
                            matrix[ny][nx] = 'N';
                        }
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(matrix[i][j] == 'Y') answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
