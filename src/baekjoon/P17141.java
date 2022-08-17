package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P17141 {
    static int n;
    static int m;
    static char[][] matrix;
    static List<Coordinate> list;
    static int minTime = Integer.MAX_VALUE;
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        matrix = new char[n][n];
        list = new ArrayList<>();

        // 입력
        int emptyCnt = 0;
        for(int i = 0; i < n; i++) {
            String[] ss = br.readLine().split(" ");
            for(int j = 0; j < n; j++) {
                char c = ss[j].charAt(0);
                matrix[i][j] = c;
                if(c == '2') {
                    list.add(new Coordinate(i, j));
                } else if(c == '0') {
                    emptyCnt++;
                }
            }
        }

        if(list.size() < m) {
            System.out.println(-1);
            return;
        }

        if(emptyCnt + list.size() - m == 0) {
            System.out.println(0);
            return;
        }

        // 바이러스 위치 조합
        combination(0, new ArrayList<>());

        if(minTime != Integer.MAX_VALUE) {
            System.out.println(minTime);
        } else {
            System.out.println(-1);
        }

        br.close();
    }

    private static void combination(int start, List<Coordinate> cur) {
        if(cur.size() == m) {
            spreadVirus(cur);
            return;
        }

        for(int i = start; i < list.size(); i++) {
            cur.add(list.get(i));
            combination(i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }

    private static void spreadVirus(List<Coordinate> virusPositions) {
        char[][] field = new char[n][n];
        int emptyCnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '0' || matrix[i][j] == '2') {
                    field[i][j] = '.';
                    emptyCnt++;
                } else if(matrix[i][j] == '1') {
                    field[i][j] = '-';
                }
            }
        }

        LinkedList<Virus> q = new LinkedList<>();
        int infectCnt = 0;
        for(int i = 0; i < virusPositions.size(); i++) {
            Coordinate coordinate = virusPositions.get(i);
            q.add(new Virus(coordinate.y, coordinate.x, 0));
            field[coordinate.y][coordinate.x] = 'v';
            infectCnt++;
        }

        int time = 0;
        while (!q.isEmpty()) {
            if(time >= minTime) break;
            Virus cur = q.poll();

            for(int k = 0; k < 4; k++) {
                int ny = cur.y + dy[k];
                int nx = cur.x + dx[k];
                if(0 <= ny && ny < n && 0 <= nx && nx < n) {
                    if(field[ny][nx] == '.') {
                        infectCnt++;
                        field[ny][nx] = 'v';
                        q.add(new Virus(ny, nx, cur.time + 1));
                    }
                }
            }

            time = cur.time;
        }

        if(infectCnt == emptyCnt) {
            minTime = time;
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

    private static class Virus {
        int y;
        int x;
        int time;

        public Virus(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
}
