package programmers.graph;

import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1차: 메모리 에러, boolean형 배열이 int형 배열보다 메모리크기가 작다.
 */
public class TheFurthestNode {
    private static int[] distances;

    public void bfs(int n, boolean[][] graph) {
        distances = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i = 2; i < n + 1; i++) {
                if(graph[cur][i] && distances[i] == 0) {
                    q.add(i);
                    distances[i] = distances[cur] + 1;
                }
            }
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;

        boolean[][] graph = new boolean[n + 1][n + 1];
        for(int[] v: edge) {
            int from = v[0];
            int to = v[1];
            graph[from][to] = true;
            graph[to][from] = true;
        }

        bfs(n, graph);

        int max = 0;
        for (int distance : distances) {
            max = Math.max(max, distance);
        }

        for (int distance : distances) {
            if(distance == max){
                answer++;
            }
        }

        return answer;
    }
}
