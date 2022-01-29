package programmers.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 1차: solution 참고
 */
public class KakaoFriendsColoringBook {
    boolean[][] visited;
    Map<Integer, Integer> sizeOfArea;
    int areaKindCnt;

    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        sizeOfArea = new HashMap<>();
        areaKindCnt = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !visited[i][j]) {
                    bfs(m, n, picture, i , j);
                    areaKindCnt++;
                }
            }
        }

        int[] answer = new int[2];
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(sizeOfArea.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        answer[0] = areaKindCnt;
        answer[1] = entryList.get(0).getValue();

        return answer;
    }

    public class Coordinate {
        int y;
        int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private void bfs(int m, int n, int[][] picture, int curY, int curX) {
        int key = picture[curY][curX];
        visited[curY][curX] = true;
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(curY, curX));
        int cnt = 1;

        int[] dy = new int[]{-1, 0, 1, 0};
        int[] dx = new int[]{0, -1, 0, 1};

        while(!q.isEmpty()) {
            Coordinate cur = q.poll();
            int y = cur.y;
            int x = cur.x;
            for(int i = 0; i < 4; i++) {
                int yy = y + dy[i];
                int xx = x + dx[i];
                if(0 <= yy && yy < m && 0 <= xx && xx < n) {
                    if(!visited[yy][xx] && picture[yy][xx] == key) {
                        visited[yy][xx] = true;
                        cnt++;
                        q.add(new Coordinate(yy, xx));
                    }
                }
            }
        }

        if(!sizeOfArea.containsKey(key)) {
            sizeOfArea.put(key, cnt);
        } else {
            sizeOfArea.put(key, Math.max(cnt, sizeOfArea.get(key)));
        }
    }

    @Test
    public void test() throws Exception {
        KakaoFriendsColoringBook s = new KakaoFriendsColoringBook();
        int[] result = s.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0},
                {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
        int[] answer = new int[]{4, 5};
        Assertions.assertEquals(result[0], answer[0]);
        Assertions.assertEquals(result[1], answer[1]);
    }
}
