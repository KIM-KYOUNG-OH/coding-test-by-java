package programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class MasterOfPlayAlone {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    static boolean[] visited;

    public int solution(int[] cards) {
        int n = cards.length;
        visited = new boolean[n];
        pq.offer(0);
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;

            dfs(cards, i, 0);
        }

        int first = pq.poll();
        int second = pq.poll();

        System.out.println(first * second);
        return first * second;
    }

    private void dfs(int[] cards, int i, int depth) {
        if(visited[i]) {
            pq.offer(depth);
            return;
        }

        visited[i] = true;
        int next = cards[i] - 1;
        dfs(cards, next, depth + 1);
    }

    public static void main(String[] args) {
        MasterOfPlayAlone s = new MasterOfPlayAlone();
        s.solution(new int[]{8,6,3,7,2,5,1,4});
    }
}
