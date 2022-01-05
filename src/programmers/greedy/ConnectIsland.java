package programmers.greedy;

import java.util.Arrays;

/**
 * 1차 : solution 참고
 * 2차 : union-find 로직 이해부족
 */
public class ConnectIsland {
    // Minimum Spanning Tree : 최소 신장 트리
    // 가중치 무방향 그래프에서 사이클이 존재하지 않는 트리구조

    // Kruskal Algorithm: 크루스칼 알고리즘
    // MST를 찾는 알고리즘
    // Greedy Algorithm에 속함

    // Union Find
    // 임의의 두 원소를 선택했을 때 그 두 원소가 같은 집합에 속하는지 판별하는 방법

    // 사이클 발생 조건
    // 같은 집합(그래프)에 속한 두 노드를 연결했을 때 발생
    // 크루스칼 알고리즈에서 특정 간선이 연결하는 두 노드의 부모가 같다면 사이클이 발생하므로 그 간선은 선택하지 않는다.

    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        // 가중치순 오름차순 정렬
        Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2] - c2[2]);

        // Union Find를 사용하기 위해 parent 배열 초기화
        parent = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            int fromParent = findAndSetParent(from);
            int toParent = findAndSetParent(to);

            // 부모노드가 같다면 해당 간선을 선택하지 않는다.
            if(fromParent == toParent) continue;

            answer += cost;

            // 간선을 연결해 두 노드가 같은 그래프에 속하게 되었으므로 부모 노드를 갱신
            // 더 작은 값을 root로 지정
            parent[toParent] = Math.min(fromParent, toParent);
            parent[fromParent] = Math.min(fromParent, toParent);
        }

        return answer;
    }

    // 부모노드가 자기자신과 같은 노드를 찾을 때까지 깊이 탐색
    // 부모노드 조회와 동시에 같은 그래프에 속한 노드들 root값 수정(재귀이므로 root부터 node까지 차례로 수정됨)
    private int findAndSetParent(int node) {
        if(parent[node] == node) return node;
        return parent[node] = findAndSetParent(parent[node]);
    }

}
