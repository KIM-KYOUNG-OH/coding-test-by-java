package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistance {
    int[] dy = new int[]{-1, 0, 1, 0};
    int[] dx = new int[]{0, -1, 0, 1};
    int[][] matrix;
    boolean[][] visited;

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        matrix = new int[n + 1][m + 1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i + 1][j + 1] = maps[i][j];
            }
        }

        return bfs(n, m);
    }

    public int bfs(int n, int m) {
        visited = new boolean[n + 1][m + 1];
        int distance = -1;
        Queue<Coordinate> q = new LinkedList<>();
        visited[1][1] = true;
        q.add(new Coordinate(1, 1, 1));
        while(!q.isEmpty()) {
            Coordinate cur = q.poll();
            int d = cur.d;
            if(cur.y == n && cur.x == m) {
                distance = d;
                break;
            }
            for(int k = 0; k < 4; k++) {
                int ny = cur.y + dy[k];
                int nx = cur.x + dx[k];
                if(0 < ny && ny <= n && 0 < nx && nx <= m) {
                    if(!visited[ny][nx] && matrix[ny][nx] == 1) {
                        q.add(new Coordinate(ny, nx, d + 1));
                        visited[ny][nx] = true;
                    }
                }
            }
        }

        return distance;
    }

    private class Coordinate {
        int y;
        int x;
        int d;

        public Coordinate(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
}
