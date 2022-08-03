package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P15685 {
    static boolean[][] visited;
    static int[] dy = new int[]{0, -1, 0, 1};
    static int[] dx = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[101][101];

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int d = Integer.parseInt(s[2]);
            int g = Integer.parseInt(s[3]);

            curve(x, y, d, g);
        }

        int answer = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(visited[i][j] && visited[i][j + 1] && visited[i + 1][j] && visited[i + 1][j + 1]) answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }

    private static void curve(int x, int y, int d, int g) {
        List<Integer> list = new ArrayList<>();
        list.add(d);

        for(int i = 0; i < g; i++) {
            for(int j = list.size() - 1; j >= 0; j--) {
                list.add((list.get(j) + 1) % 4);
            }
        }

        visited[y][x] = true;
        for (Integer direction : list) {
            y = y + dy[direction];
            x = x + dx[direction];
            visited[y][x] = true;
        }
    }
}
