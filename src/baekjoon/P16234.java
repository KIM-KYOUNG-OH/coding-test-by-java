package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P16234 {
    static int n;
    static int l;
    static int r;
    static int[][] matrix;
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, -1, 0, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        l = Integer.parseInt(s[1]);
        r = Integer.parseInt(s[2]);
        matrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            String[] ss = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(ss[j]);
            }
        }
        visited = new boolean[n][n];

        int answer = 0;
        while(true) {
            if(movePeople() == 0) {
                break;
            } else {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static int movePeople() {
        int unionCount = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j]) continue;
                Queue<Coordinate> q = new LinkedList<>();
                List<Coordinate> unionComponents = new ArrayList<>();
                q.add(new Coordinate(i, j));
                unionComponents.add(new Coordinate(i, j));
                visited[i][j] = true;

                int unionSum = matrix[i][j];
                while (!q.isEmpty()) {
                    Coordinate current = q.poll();
                    for(int k = 0; k < 4; k++) {
                        int ny = current.y + dy[k];
                        int nx = current.x + dx[k];
                        if(0 <= ny && ny < n && 0 <= nx && nx < n) {
                            if(!visited[ny][nx] && isConnectable(current.y, current.x, ny, nx)) {
                                q.add(new Coordinate(ny, nx));
                                unionSum += matrix[ny][nx];
                                unionCount++;
                                unionComponents.add(new Coordinate(ny, nx));
                                visited[ny][nx] = true;
                            }
                        }
                    }
                }

                if(unionCount > 0) {
                    int aver = unionSum / unionComponents.size();

                    for (Coordinate comp : unionComponents) {
                        matrix[comp.y][comp.x] = aver;
                    }
                }
            }
        }

        visited = new boolean[n][n];

        return unionCount;
    }

    private static boolean isConnectable(int y, int x, int ny, int nx) {
        int diff = Math.abs(matrix[y][x] - matrix[ny][nx]);
        if(diff >= l && diff <= r) return true;
        return false;
    }

    private static class Coordinate{
        int y;
        int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
