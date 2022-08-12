package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P21610 {
    static int n;
    static int m;
    static int[][] water;
    static Operation[] operations;
    static boolean[][] disappear;
    static int[] dy = new int[]{0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = new int[]{0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] magicDy = new int[]{-1, -1, 1, 1};
    static int[] magicDx = new int[]{-1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        water = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            String[] ss = br.readLine().split(" ");
            for(int j = 1; j <= n; j++) {
                water[i][j] = Integer.parseInt(ss[j - 1]);
            }
        }

        operations = new Operation[m];
        for(int i = 0; i < m; i++) {
            String[] ss = br.readLine().split(" ");
            int direction = Integer.parseInt(ss[0]);
            int speed = Integer.parseInt(ss[1]);
            operations[i] = new Operation(direction, speed);
        }

        List<Cloud> clouds = new ArrayList<>();
        clouds.add(new Cloud(n, 1));
        clouds.add(new Cloud(n, 2));
        clouds.add(new Cloud(n - 1, 1));
        clouds.add(new Cloud(n - 1, 2));

        for (Operation operation : operations) {
            int direction = operation.direction;
            int speed = operation.speed;
//            System.out.println("direction = " + direction + ", speed = " + speed);
//            for (Cloud cloud : clouds) {
//                System.out.println("cloud = " + cloud);
//            }

            // 구름 이동 후 비내림
            disappear = new boolean[n + 1][n + 1];
            for (Cloud cloud : clouds) {
                cloud.move(direction, speed);
                water[cloud.y][cloud.x] += 1;
                disappear[cloud.y][cloud.x] = true;
            }

//            System.out.println("이동 후");
//            for (Cloud cloud : clouds) {
//                System.out.println("cloud = " + cloud);
//            }
//
//            System.out.println("비내림 후");
//            for(int i = 1; i <= n; i++) {
//                for(int j = 1; j <= n; j++) {
//                    System.out.print(water[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            // 구름 삭제
            clouds = new ArrayList<>();

            // 물복사 마법
            int[][] plus = new int[n + 1][n + 1];
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(!disappear[i][j]) {
                        continue;
                    }

                    int cnt = 0;
                    for(int k = 0; k < 4; k++) {
                        int ny = i + magicDy[k];
                        int nx = j + magicDx[k];

                        if(0 < ny && ny <= n && 0 < nx && nx <= n && water[ny][nx] != 0) {
                            cnt++;
                        }
                    }

                    plus[i][j] += cnt;
                }
            }

            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(plus[i][j] == 0) continue;
                    water[i][j] += plus[i][j];
                }
            }

//            System.out.println("물복사 마법 후");
//            for(int i = 1; i <= n; i++) {
//                for(int j = 1; j <= n; j++) {
//                    System.out.print(water[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            // 물의 양이 2 이상이면 구름 생성
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(disappear[i][j]) {
                        continue;
                    }

                    if(water[i][j] >= 2) {
                        water[i][j] -= 2;
                        clouds.add(new Cloud(i, j));
                    }
                }
            }

//            System.out.println("구름 생성 후");
//            for(int i = 1; i <= n; i++) {
//                for(int j = 1; j <= n; j++) {
//                    System.out.print(water[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

        // 물 양 총 계산
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                answer += water[i][j];
            }
        }

        System.out.println(answer);

        br.close();
    }

    private static class Cloud {
        int y;
        int x;

        public Cloud(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public void move(int direction, int speed) {
            y = y + (n + dy[direction] * (speed % n)) % n;
            if(y > n) {
                y = y % n;
            }
            x = x + (n + dx[direction] * (speed % n)) % n;
            if(x > n) {
                x = x % n;
            }
        }

        @Override
        public String toString() {
            return "Cloud{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }

    private static class Operation {
        int direction;
        int speed;

        public Operation(int direction, int speed) {
            this.direction = direction;
            this.speed = speed;
        }
    }
}
