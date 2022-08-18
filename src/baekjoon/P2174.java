package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2174 {
    static int[] dy = new int[]{0, -1, 0, 1};
    static int[] dx = new int[]{1, 0, -1, 0};
    static int a;
    static int b;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        a = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        List<Robot> robots = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String[] ss = br.readLine().split(" ");
            robots.add(new Robot(Integer.parseInt(ss[1]), Integer.parseInt(ss[0]), getDirection(ss[2]), i + 1));
        }

        List<Operation> operations = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            String[] ss = br.readLine().split(" ");
            operations.add(new Operation(Integer.parseInt(ss[0]), ss[1].charAt(0), Integer.parseInt(ss[2])));
        }

        matrix = new int[b + 1][a + 1];
        for (Robot robot : robots) {
            matrix[robot.y][robot.x] = robot.id;
        }

        for (Operation operation : operations) {
            if(operation.order == 'F') {
                for(int i = 0; i < operation.times; i++) {
                    Robot cur = robots.get(operation.robotId - 1);
                    int result = cur.canGoForward();
                    if(result == 0) {  // 가능
                        cur.forward();
                    } else if(result == -1) {  // 벽 충돌
                        System.out.println("Robot " + operation.robotId + " crashes into the wall");
                        return;
                    } else {  // 로봇 충돌
                        System.out.println("Robot " + operation.robotId + " crashes into robot " + result);
                        return;
                    }
                }
            } else if(operation.order == 'L') {
                for(int i = 0; i < operation.times; i++) {
                    Robot cur = robots.get(operation.robotId - 1);
                    cur.turnLeft();
                }
            } else if(operation.order == 'R') {
                for(int i = 0; i < operation.times; i++) {
                    Robot cur = robots.get(operation.robotId - 1);
                    cur.turnRight();
                }
            }
        }

        System.out.println("OK");

        br.close();
    }

    private static int getDirection(String dir) {
        switch (dir) {
            case "E":
                return 0;

            case "S":
                return 1;

            case "W":
                return 2;

            case "N":
                return 3;
        }

        return 0;
    }

    private static class Robot {
        int y;
        int x;
        int direction;
        int id;

        public Robot(int y, int x, int direction, int id) {
            this.y = y;
            this.x = x;
            this.direction = direction;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "y=" + y +
                    ", x=" + x +
                    ", direction=" + direction +
                    ", id=" + id +
                    '}';
        }

        public int canGoForward() {  // 0: 가능, -1: 벽 충돌, 그 외: 충돌한 로봇 번호
            int ny = y + dy[direction];
            int nx = x + dx[direction];
            if(0 >= ny || ny > b || 0 >= nx || nx > a) return -1;

            if(matrix[ny][nx] != 0) return matrix[ny][nx];
            else return 0;
        }

        public void forward() {  // 전진
            int ny = y + dy[direction];
            int nx = x + dx[direction];
            matrix[ny][nx] = id;
            matrix[y][x] = 0;
            y = ny;
            x = nx;
        }

        public void turnLeft() {  // 좌회전
            direction = (direction + 3) % 4;
        }

        public void turnRight() {  // 우회전
            direction = (direction + 1) % 4;
        }
    }

    private static class Operation {
        int robotId;
        char order;
        int times;

        public Operation(int robotId, char order, int times) {
            this.robotId = robotId;
            this.order = order;
            this.times = times;
        }

        @Override
        public String toString() {
            return "Operation{" +
                    "robotId=" + robotId +
                    ", order=" + order +
                    ", times=" + times +
                    '}';
        }
    }
}
