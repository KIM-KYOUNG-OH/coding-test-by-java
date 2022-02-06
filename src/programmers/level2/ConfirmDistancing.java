package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1차: solution 참고
 */
public class ConfirmDistancing {
    int[] dy;
    int[] dx;

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        dy = new int[]{-1, 1, 0, 0};
        dx = new int[]{0, 0, -1, 1};

        for(int i = 0; i < places.length; i++) {
            String[] place = places[i];

            int isOk = check(place);
            answer[i] = isOk;
        }

        return answer;
    }

    private int check(String[] place) {
        for(int r = 0; r < 5; r++) {
            for(int c = 0; c < 5; c++) {
                if(place[r].charAt(c) == 'P') {
                    if(!bfs(r, c, place)) return 0;
                }
            }
        }
        return 1;
    }

    private class Coordinate{
        int y;
        int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private boolean bfs(int y, int x, String[] place) {
        Queue<Coordinate> q = new LinkedList<>();
        q.offer(new Coordinate(y, x));

        while(!q.isEmpty()) {
            Coordinate cur = q.poll();

            for(int i = 0; i < 4; i++) {  // 북남서동
                int yy = cur.y + dy[i];
                int xx = cur.x + dx[i];

                if(yy < 0 || 5 <= yy || xx < 0 || 5 <= xx || (yy == y && xx == x)) continue;

                int distance = Math.abs(yy - y) + Math.abs(xx - x);

                if(place[yy].charAt(xx) == 'P' && distance <= 2) return false;
                else if(place[yy].charAt(xx) == 'O' && distance < 2) {
                    q.offer(new Coordinate(yy, xx));
                }
            }
        }

        return true;
    }
}
