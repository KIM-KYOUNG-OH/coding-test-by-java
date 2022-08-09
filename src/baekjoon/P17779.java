package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class P17779 {
    static int n;
    static int[][] matrix;
    static int answer;
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n + 1][n + 1];
        for(int i = 1; i < n + 1; i++) {
            String[] s = br.readLine().split(" ");
            for(int j = 1; j < n + 1; j++) {
                matrix[i][j] = Integer.parseInt(s[j - 1]);
            }
        }

        answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n - 2; i++) {
            for(int j = 2; j <= n - 1; j++) {
                recursive(i, j, 1, 1);
            }
        }

        System.out.println(answer);

        br.close();
    }

    private static void recursive(int y, int x, int d1, int d2) {
        for(int p = 0; p < x && p < n - y; p++) {
            for(int q = 0; q < n - x && q < n - y; q++) {
                int curD1 = d1 + p;
                int curD2 = d2 + q;
                if(y + curD1 + curD2 <= n && 1 <= x - curD1 && x + curD2 <= n) {
                    int[][] zone = new int[n + 1][n + 1];
                    LinkedList<Coordinate> queue = new LinkedList<>();

                    // 경계 구역5로 채우기
                    for(int k = 0; k <= curD1; k++) {
                        zone[y + k][x - k] = 5;
                        zone[y + curD2 + k][x + curD2 - k] = 5;
                    }
                    for(int k = 0; k <= curD2; k++) {
                        zone[y + k][x + k] = 5;
                        zone[y + curD1 + k][x - curD1 + k] = 5;
                    }

                    // 경계 내부 구역5 채우기
                    for(int k = x - curD1 + 1; k < x + curD2; k++) {
                        boolean isZone5 = false;
                        for(int l = 1; l <= n; l++) {
                            if(zone[l][k] == 5) isZone5 = !isZone5;
                            else if(isZone5) zone[l][k] = 5;
                        }
                    }

                    // 구역 1, 2, 3, 4 채우기
                    for(int i = 1; i <= n; i++) {
                        for(int j = 1; j <= n; j++) {
                            if(zone[i][j] != 0) continue;
                            if(1 <= i && i <= y + curD2 && 1 <= j && j <= n) {
                                zone[i][j] = 2;
                            }
                            if(1 <= i && i < y + curD1 && 1 <= j && j <= x) {
                                zone[i][j] = 1;
                            }
                            if(y + curD2 < i && i <= n && x - curD1 + curD2 <= j && j <= n) {
                                zone[i][j] = 4;
                            }
                            if(y + curD1 <= i && i <= n && 1 <= j && j < x - curD1 + curD2) {
                                zone[i][j] = 3;
                            }

                        }
                    }

                    // 구역별 인구 계산
                    int[] population = new int[6];
                    for(int i = 1; i <= n; i++) {
                        for(int j = 1; j <= n; j++) {
                            int curZone = zone[i][j];
                            switch (curZone) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                    population[curZone] += matrix[i][j];
                                    break;
                            }
                        }
                    }
                    Arrays.sort(population);

                    // 최소 인구 구역과 최대 인구 구역의 인구차이 최소값 answer로 업데이트
                    answer = Math.min(answer, population[5] - population[1]);
                }
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
