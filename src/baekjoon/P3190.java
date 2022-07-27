package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P3190 {
    static int n;
    static int k;
    static int answer;
    static int[][] matrix;
    static int l;
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] dx = new int[]{1, 0, -1, 0};
    static Queue<Turn> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        answer = 0;
        matrix = new int[n + 1][n + 1];
        Snake snake = new Snake();

        // 사과 입력받기(사과는 2)
        for(int i = 0; i < k; i++) {
            String[] s = br.readLine().split(" ");
            int r = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);
            matrix[r][c] = 2;
        }

        l = Integer.parseInt(br.readLine());
        for(int i = 0; i < l; i++) {
            String[] s = br.readLine().split(" ");
            int second = Integer.parseInt(s[0]);
            char turn = s[1].charAt(0);
            q.add(new Turn(second, turn));
        }

        if(snake.moveAndCheckIsDone()) {
            System.out.println(answer);
            return;
        }

        System.out.println(answer);

        br.close();
    }

    private static class Snake {
        LinkedList<Coordinate> components = new LinkedList<>();
        int direction;

        public Snake() {
            components.add(new Coordinate(1, 1));
            matrix[1][1] = 1;
            this.direction = 0;
        }

        public boolean moveAndCheckIsDone() {
            while(true) {
                answer++;
                Coordinate head = components.getLast();
                Coordinate tail = components.peek();
                Coordinate next = new Coordinate(head.y + dy[direction], head.x + dx[direction]);

                if(next.y <= 0 || next.y > n || next.x <= 0 || next.x > n) return true;

                if(matrix[next.y][next.x] == 1) {  // 뱀
                    return true;
                } else if (matrix[next.y][next.x] == 2) {  // 사과
                    matrix[next.y][next.x] = 1;
                    components.add(next);
                } else {  // 빈 칸
                    matrix[next.y][next.x] = 1;
                    components.add(next);
                    matrix[tail.y][tail.x] = 0;
                    components.remove(0);
                }

                // 방향 전환
                if(!q.isEmpty()) {
                    if(answer == q.peek().second) {
                        Turn turn = q.poll();
                        if(turn.direction == 'L') {
                            direction = (direction + 3) % 4;
                        } else if(turn.direction == 'D') {
                            direction = (direction + 1) % 4;
                        }
                    }
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

    private static class Turn {
        int second;
        char direction;

        public Turn(int second, char direction) {
            this.second = second;
            this.direction = direction;
        }
    }
}
