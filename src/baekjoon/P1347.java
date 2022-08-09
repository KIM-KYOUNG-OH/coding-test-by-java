package baekjoon;

import java.io.*;

public class P1347 {
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[] dx = new int[]{0, -1, 0, 1};
    static char[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        matrix = new char[100][100];
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                matrix[i][j] = '#';
            }
        }

        Person person = new Person(50, 50, 0);
        matrix[person.y][person.x] = '.';
        int maxY = 50;
        int minY = 50;
        int maxX = 50;
        int minX = 50;

        for (char c : s.toCharArray()) {
            if(c == 'R') {
                person.turnRight();
            } else if(c == 'L') {
                person.turnLeft();
            } else {
                person.goForward();
                matrix[person.y][person.x] = '.';
                maxY = Math.max(maxY, person.y);
                minY = Math.min(minY, person.y);
                maxX = Math.max(maxX, person.x);
                minX = Math.min(minX, person.x);
            }
        }

        char[][] result = new char[maxY - minY + 1][maxX - minX + 1];
        for(int i = minY; i <= maxY; i++) {
            for(int j = minX; j <= maxX; j++) {
                result[i - minY][j - minX] = matrix[i][j];
            }
        }

        for (char[] chars : result) {
            for (int j = 0; j < result[0].length; j++) {
                bw.write(chars[j]);
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }

    private static class Person {
        int y;
        int x;
        int direction;

        public Person(int y, int x, int direction) {
            this.y = y;
            this.x = x;
            this.direction = direction;
        }

        public void turnRight() {
            direction = (direction + 1) % 4;
        }

        public void turnLeft() {
            direction = (direction + 3) % 4;
        }

        public void goForward() {
            y = y + dy[direction];
            x = x + dx[direction];
        }
    }
}
