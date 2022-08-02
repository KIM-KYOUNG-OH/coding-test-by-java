package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class P17144 {
    static int r;
    static int c;
    static int t;
    static int[][] matrix;
    static int[][] airConditioner;
    static LinkedList<Dust> q;
    static int[][] dustMovement;
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        t = Integer.parseInt(s[2]);
        matrix = new int[r + 1][c + 1];
        AirConditioner upAirConditioner = null;
        AirConditioner downAirConditioner = null;
        int index = 0;
        for(int i = 1; i <= r; i++) {
            String[] ss = br.readLine().split(" ");
            for(int j = 1; j <= c; j++) {
                int num = Integer.parseInt(ss[j - 1]);
                if(num == -1 && index == 0) {
                    upAirConditioner = new AirConditioner(i, j);
                    index++;
                } else if(num == -1 && index == 1) {
                    downAirConditioner = new AirConditioner(i, j);
                }

                matrix[i][j] = num;
            }
        }




        while (t-- > 0) {
            fillQ();
            dustMovement = new int[r + 1][c + 1];
            while (!q.isEmpty()) {
                Dust current = q.poll();
                int moveAmount = current.amount / 5;
                int moveCount = 0;

                for(int k = 0; k < 4; k++) {
                    int ny = current.y + dy[k];
                    int nx = current.x + dx[k];
                    if(0 < ny && ny <= r && 0 < nx && nx <= c) {
                        if(matrix[ny][nx] == -1) continue;
                        moveCount++;
                        dustMovement[ny][nx] += moveAmount;
                    }
                }

                dustMovement[current.y][current.x] -= moveAmount * moveCount;
            }

            // refresh matrix
            for(int i = 1; i <= r; i++) {
                for(int j = 1; j <= c; j++) {
                    if(i == upAirConditioner.y && j == upAirConditioner.x) continue;
                    else if(i == downAirConditioner.y && j == downAirConditioner.x) continue;

                    matrix[i][j] += dustMovement[i][j];
                }
            }



            // air conditioning
            upAirConditioner.airConditioningByCounterClockwise();
            downAirConditioner.airConditioningByClockwise();


        }

        int answer = 0;
        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= c; j++) {
                if(matrix[i][j] == -1) continue;
                answer += matrix[i][j];
            }
        }

        System.out.println(answer);

        br.close();
    }

    private static void fillQ() {
        q = new LinkedList<>();
        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= c; j++) {
                if(matrix[i][j] == -1 || matrix[i][j] == 0) continue;
                q.add(new Dust(i, j, matrix[i][j]));
            }
        }
    }

    private static class Dust {
        int y;
        int x;
        int amount;

        public Dust(int y, int x, int amount) {
            this.y = y;
            this.x = x;
            this.amount = amount;
        }
    }

    private static class AirConditioner {
        int y;
        int x;

        public AirConditioner(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public void airConditioningByCounterClockwise() {
            // left
            for(int k = y - 1; k >= 1; k--) {
                matrix[k][x] = matrix[k - 1][x];
            }

            // up
            for(int k = 1; k <= c; k++) {
                matrix[1][k - 1] = matrix[1][k];
            }

            // right
            for(int k = 2; k <= y; k++) {
                matrix[k - 1][c] = matrix[k][c];
            }

            // down
            for(int k = c - 1; k >= 1; k--) {
                if(k == 1) {
                    matrix[y][x + 1] = 0;
                    continue;
                }
                matrix[y][k + 1] = matrix[y][k];
            }
        }

        public void airConditioningByClockwise() {
            // left
            for(int k = y + 2; k <= r; k++) {
                matrix[k - 1][1] = matrix[k][1];
            }

            // down
            for(int k = 1; k <= c; k++) {
                matrix[r][k - 1] = matrix[r][k];
            }

            // right
            for(int k = r - 1; k >= y; k--) {
                matrix[k + 1][c] = matrix[k][c];
            }

            // up
            for(int k = c - 1; k >= 1; k--) {
                if(k == 1) {
                    matrix[y][k + 1] = 0;
                    continue;
                }
                matrix[y][k + 1] = matrix[y][k];
            }
        }
    }
}
