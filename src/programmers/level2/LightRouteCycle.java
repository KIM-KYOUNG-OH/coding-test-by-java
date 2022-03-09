package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1차: solution 참고
 */
public class LightRouteCycle {
    int n, m;
    int[] dy = new int[]{1, 0, -1, 0};
    int[] dx = new int[]{0, -1, 0, 1};
    boolean[][][] isVisited;  // 아왼위오

    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        n = grid.length;
        m = grid[0].length();
        isVisited = new boolean[n][m][4];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int dir = 0; dir < 4; dir++) {
                    if(!isVisited[i][j][dir]) {
                        answer.add(getDistance(grid, i, j, dir));
                    }
                }
            }
        }
        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }

    private int getDistance(String[] grid, int y, int x, int dir) {
        int distance = 0;

        while (!isVisited[y][x][dir]) {

            distance++;
            isVisited[y][x][dir] = true;

            if (grid[y].charAt(x) == 'L') {
                dir = (dir + 3) % 4;
            } else if (grid[y].charAt(x) == 'R') {
                dir = (dir + 1) % 4;
            }
            y = (y + dy[dir] + n) % n;
            x = (x + dx[dir] + m) % m;
        }

        return distance;
    }
}
