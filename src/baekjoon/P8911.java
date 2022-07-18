package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P8911 {
    public static void main(String[] args) throws IOException {
        int[] dy = new int[]{1, 0, -1, 0};
        int[] dx = new int[]{0, 1, 0, -1};


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String s = br.readLine();

            int direction = 0;
            int y = 0;
            int x = 0;
            int minX = 0;
            int maxX = 0;
            int minY = 0;
            int maxY = 0;

            for (char ch : s.toCharArray()) {
                if(ch == 'F') {
                    y = y + dy[direction];
                    x = x + dx[direction];
                } else if(ch == 'B') {
                    y = y + dy[(direction + 2) % 4];
                    x = x + dx[(direction + 2) % 4];
                } else if(ch == 'L') {
                    direction = (direction + 3) % 4;
                } else if(ch == 'R') {
                    direction = (direction + 1) % 4;
                }

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);

            }

            int width = maxX - minX;
            int height = maxY - minY;
            int area = width * height;
            System.out.println(area);
        }

        br.close();
    }
}
