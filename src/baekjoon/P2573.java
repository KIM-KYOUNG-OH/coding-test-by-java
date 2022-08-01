package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P2573 {
    static int n;
    static int m;
    static int[][] matrix;
    static LinkedList<Ice> q = new LinkedList<>();
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, -1, 0, 1};
    static int answer;
    static List<Ice> melting = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        matrix = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] ss = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(ss[j]);
            }
        }

        answer = 0;
        while(!isMoreThanTwoPieces()) {
            if(!isThereAnyIce()) {
                answer = 0;
                break;
            }

            answer++;
            fillQ();
            melting = new ArrayList<>();
            while (!q.isEmpty()) {
                Ice current = q.poll();
                int minus = 0;
                for(int k = 0; k < 4; k++) {
                    int ny = current.y + dy[k];
                    int nx = current.x + dx[k];
                    if(0 <= ny && ny < n && 0 <= nx && nx < m && matrix[ny][nx] == 0) {
                        minus++;
                    }
                }

                int fixedLife = current.life - minus;
                if(fixedLife < 0) fixedLife = 0;
                current.life = fixedLife;
                melting.add(current);
            }

            for (Ice ice : melting) {
                matrix[ice.y][ice.x] = ice.life;
            }

        }

        System.out.println(answer);
    }

    private static boolean isThereAnyIce() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] != 0) return true;
            }
        }
        return false;
    }

    private static boolean isMoreThanTwoPieces() {
        boolean[][] visited = new boolean[n][m];
        LinkedList<Ice> queue = new LinkedList<>();
        int islandCount = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    if(matrix[i][j] == 0) {
                        continue;
                    }

                    islandCount++;
                    if(islandCount >= 2) return true;

                    queue.add(new Ice(i, j, matrix[i][j]));
                    while (!queue.isEmpty()) {
                        Ice current = queue.poll();
                        for(int k = 0; k < 4; k++) {
                            int ny = current.y + dy[k];
                            int nx = current.x + dx[k];
                            if(0 <= ny && ny < n && 0 <= nx && nx < m) {
                                if(!visited[ny][nx] && matrix[ny][nx] != 0) {
                                    visited[ny][nx] = true;
                                    queue.add(new Ice(ny, nx, matrix[ny][nx]));
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    private static void fillQ() {
        q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] != 0) {
                    q.add(new Ice(i, j, matrix[i][j]));
                }
            }
        }
    }

    private static class Ice {
        int y;
        int x;
        int life;

        public Ice(int y, int x, int life) {
            this.y = y;
            this.x = x;
            this.life = life;
        }
    }
}
