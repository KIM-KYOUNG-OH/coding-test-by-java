package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P13901 {
    static int r;
    static int c;
    static boolean[][] visited;
    static int[] dy = new int[]{0, -1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, 0, -1, 1};
    static int[] directionSeq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        visited = new boolean[r][c];

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            String[] ss = br.readLine().split(" ");
            int vr = Integer.parseInt(ss[0]);
            int vc = Integer.parseInt(ss[1]);
            visited[vr][vc] = true;
        }

        s = br.readLine().split(" ");
        int curR = Integer.parseInt(s[0]);
        int curC = Integer.parseInt(s[1]);
        visited[curR][curC] = true;

        directionSeq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cantMoveCnt = 0;
        int idx = 0;
        while (cantMoveCnt < 4) {
            int direction = directionSeq[idx];
            int ny = curR + dy[direction];
            int nx = curC + dx[direction];
            if(ny < 0 || ny >= r || nx < 0 || nx >= c) cantMoveCnt++;
            else {
                if(visited[ny][nx]) cantMoveCnt++;
                else {
                    visited[ny][nx] = true;
                    curR = ny;
                    curC = nx;
                    cantMoveCnt = 0;
                    continue;
                }
            }
            idx = (idx + 1) % 4;
        }

        System.out.println(curR + " " + curC);

        br.close();
    }
}
