package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P2636 {
    static int n;
    static int m;
    static int[][] matrix;
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, -1, 0, 1};
    static boolean[][] melting;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        matrix = new int[n][m];
        for(int i = 0; i < n; i ++) {
            String[] ss = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(ss[j]);
            }
        }

        int time = calculateMeltTime(0);
        int piecesCount = getPiecesCountBeforeOneHourFromDone();

        System.out.println(time);
        System.out.println(piecesCount);

        br.close();
    }

    private static int getPiecesCountBeforeOneHourFromDone() {
        int count = 0;

        for(int i = 1; i < n - 1; i++) {
            for(int j = 1; j < m - 1; j++) {
                if(melting[i][j]) count++;
            }
        }

        return count;
    }

    private static int calculateMeltTime(int time) {
        if(isCheeseAbsent()) {
            return time;
        }

        predicateMeltingPoint();
        melt();

        return calculateMeltTime(time + 1);
    }

    private static boolean isCheeseAbsent() {
        for(int i = 1; i < n - 1; i++) {
            for(int j = 1; j < m - 1; j++) {
                if(matrix[i][j] == 1) return false;
            }
        }

        return true;
    }

    private static void melt() {
        for (int i = 1; i < n - 1; i++) {
            for(int j = 1; j < m - 1; j++) {
                if(melting[i][j]) matrix[i][j] = 0;
            }
        }
    }

    private static void predicateMeltingPoint() {
        melting = new boolean[n][m];
        boolean[][] unairable = predicateUnairablePoint();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) continue;
                int exposureCount = 0;
                for(int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(unairable[ny][nx]) continue;
                    else if(0 <= ny && ny < n && 0 <= nx && nx < m && matrix[ny][nx] == 0) {
                         exposureCount++;
                         break;
                    }
                }

                if(exposureCount > 0) melting[i][j] = true;
            }
        }
    }

    private static boolean[][] predicateUnairablePoint() {
        boolean[][] unairable = new boolean[n][m];
        boolean[][] visited = new boolean[n][m];
        boolean isUnairable;
        List<Coordinate> list = new ArrayList<>();
        List<Coordinate> temp;
        LinkedList<Coordinate> q = new LinkedList<>();

        for (int i = 2; i < n - 2; i++) {
            for(int j = 2; j < m - 2; j++) {
                if(matrix[i][j] == 1 || visited[i][j]) continue;
                temp = new ArrayList<>();
                isUnairable = true;
                q.add(new Coordinate(i, j));
                visited[i][j] = true;
                while(!q.isEmpty()) {
                    Coordinate cur = q.poll();
                    temp.add(cur);
                    for(int k = 0; k < 4; k++) {
                        int ny = cur.y + dy[k];
                        int nx = cur.x + dx[k];
                        if(0 <= ny && ny < n && 0 <= nx && nx < m) {
                            if(!visited[ny][nx] && matrix[ny][nx] == 0) {
                                q.add(new Coordinate(ny, nx));
                                visited[ny][nx] = true;
                                temp.add(new Coordinate(ny, nx));
                            }
                        }

                        if(ny == 0 || ny == n - 1 || nx == 0 || nx == m - 1) isUnairable = false;
                    }
                }

                if (isUnairable) list.addAll(temp);
            }
        }

        for (Coordinate coordinate : list) {
            unairable[coordinate.y][coordinate.x] = true;
        }

        return unairable;
    }

    private static class Coordinate {
        int y;
        int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
