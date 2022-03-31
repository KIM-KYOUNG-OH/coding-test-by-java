package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class DividePowerGrid {
    int[][] matrix;

    public int solution(int n, int[][] wires) {
        int answer = 101;
        matrix = new int[n + 1][n + 1];

        for(int[] wire: wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            matrix[v1][v2] = 1;
            matrix[v2][v1] = 1;
        }

        for(int[] wire: wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            matrix[v1][v2] = 0;
            matrix[v2][v1] = 0;

            answer = Math.min(answer, bfs(n, v1));

            matrix[v1][v2] = 1;
            matrix[v2][v1] = 1;
        }

        return answer;
    }

    private int bfs(int n, int start) {
        boolean[] visited = new boolean[n + 1];
        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i = 1; i < n + 1; i++) {
                if(i == cur) continue;
                if(matrix[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    cnt++;
                    q.add(i);
                }
            }
        }

        return Math.abs(n - 2 * cnt);
    }
}
