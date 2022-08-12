package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P20056 {
    static int n;
    static int m;
    static int k;
    static List<FireBall> fireBalls;
    static int[] dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        fireBalls = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            fireBalls.add(new FireBall(arr[0], arr[1], arr[2], arr[3], arr[4], 1, true));
        }

        while (k-- > 0) {
            // 이동
            for(int i = fireBalls.size() - 1; i >= 0; i--) {
                FireBall cur = fireBalls.get(i);
                cur.move();
            }

            // 파이어볼 합치기
            List<FireBall> fixedFireBalls = new ArrayList<>();
            for(int i = 0; i < fireBalls.size(); i++) {
                FireBall cur = fireBalls.get(i);
                boolean isAlreadyExist = false;
                for (FireBall addedOne : fixedFireBalls) {
                    if (cur.r == addedOne.r && cur.c == addedOne.c) {
                        isAlreadyExist = true;
                        addedOne.mass += cur.mass;
                        addedOne.speed += cur.speed;
                        addedOne.combinedCount++;
                        if (!addedOne.isAllEvenOrOdd) break;
                        if (addedOne.direction % 2 != cur.direction % 2) addedOne.isAllEvenOrOdd = false;
                        break;
                    }
                }

                if (!isAlreadyExist) fixedFireBalls.add(cur);
            }

            fireBalls = fixedFireBalls;

            // 파이어볼 4분할
            // 질량 / 5  질량 0인 건 스킵
            // 속력 / 개수
            // 방향 다 짝수거나 홀수면 수평 아니면 대각선으로
            fixedFireBalls = new ArrayList<>();
            for (FireBall curr : fireBalls) {
                if(curr.combinedCount < 2) {
                    fixedFireBalls.add(curr);
                    continue;
                }
                int mass = curr.mass / 5;
                if (mass == 0) continue;

                if (curr.isAllEvenOrOdd) {
                    fixedFireBalls.add(new FireBall(curr.r, curr.c, mass, curr.speed / curr.combinedCount, 0, 1, true));
                    fixedFireBalls.add(new FireBall(curr.r, curr.c, mass, curr.speed / curr.combinedCount, 2, 1, true));
                    fixedFireBalls.add(new FireBall(curr.r, curr.c, mass, curr.speed / curr.combinedCount, 4, 1, true));
                    fixedFireBalls.add(new FireBall(curr.r, curr.c, mass, curr.speed / curr.combinedCount, 6, 1, true));
                } else {
                    fixedFireBalls.add(new FireBall(curr.r, curr.c, mass, curr.speed / curr.combinedCount, 1, 1, true));
                    fixedFireBalls.add(new FireBall(curr.r, curr.c, mass, curr.speed / curr.combinedCount, 3, 1, true));
                    fixedFireBalls.add(new FireBall(curr.r, curr.c, mass, curr.speed / curr.combinedCount, 5, 1, true));
                    fixedFireBalls.add(new FireBall(curr.r, curr.c, mass, curr.speed / curr.combinedCount, 7, 1, true));
                }
            }
            fireBalls = fixedFireBalls;

        }

        int answer = 0;
        for (FireBall fireBall : fireBalls) {
            answer += fireBall.mass;
        }

        System.out.println(answer);

        br.close();
    }

    private static class FireBall {
        int r;
        int c;
        int mass;
        int speed;
        int direction;
        int combinedCount;
        boolean isAllEvenOrOdd;

        public FireBall(int r, int c, int mass, int speed, int direction, int combinedCount, boolean isAllEvenOrOdd) {
            this.r = r;
            this.c = c;
            this.mass = mass;
            this.speed = speed;
            this.direction = direction;
            this.combinedCount = combinedCount;
            this.isAllEvenOrOdd = isAllEvenOrOdd;
        }

        public void move() {
            r = (r + n + dy[direction] * (speed % n)) % n;
            c = (c + n + dx[direction] * (speed % n)) % n;
        }

        @Override
        public String toString() {
            return "FireBall{" +
                    "r=" + r +
                    ", c=" + c +
                    ", mass=" + mass +
                    ", speed=" + speed +
                    ", direction=" + direction +
                    ", combinedCount=" + combinedCount +
                    ", isAllEvenOrOdd=" + isAllEvenOrOdd +
                    '}';
        }
    }
}
