package programmers.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * 1차: solution 참고
 * 2차: solution 참고
 */
public class CountOfRoom {
    class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            return this.x == ((Pair)o).x && this.y == ((Pair)o).y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }

    public int solution(int[] arrows) {
        int cnt = 0;

        // 방향관련 배열
        Pair pointHC = new Pair(0, 0);
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

        // 방문 여부 관련 hash
        HashMap<Pair, ArrayList<Pair>> visited = new HashMap<>();

        for(int arrow: arrows) {
            for(int i = 0; i <= 1; i++) {
                Pair newPointHC = new Pair(pointHC.y + dy[arrow], pointHC.x + dx[arrow]);

                if(!visited.containsKey(newPointHC)) {
                    visited.put(newPointHC, makeEdgeList(pointHC));

                    if(visited.get(pointHC) == null) {
                        visited.put(pointHC, makeEdgeList(newPointHC));
                    }else {
                        visited.get(pointHC).add(newPointHC);
                    }
                }else if(visited.containsKey(newPointHC) && !(visited.get(newPointHC).contains(pointHC))) {
                    visited.get(newPointHC).add(pointHC);
                    visited.get(pointHC).add(newPointHC);
                    cnt++;
                }

                pointHC = newPointHC;
            }
        }

        return cnt;
    }

    private static ArrayList<Pair> makeEdgeList(Pair pointHC) {
        ArrayList<Pair> edge = new ArrayList<>();
        edge.add(pointHC);
        return edge;
    }
}
