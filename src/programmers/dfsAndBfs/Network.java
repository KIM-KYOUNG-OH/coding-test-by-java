package programmers.dfsAndBfs;

/**
 * 1차: dfs solution 참고, union-find 방법은 실패(맞게 짠거 같은데 도저히 모르겠음)
 */
public class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!check[i]) {
                dfs(computers, i, check);
                answer++;
            }
        }
        return answer;
    }

    private boolean[] dfs(int[][] computers, int i, boolean[] check) {
        check[i] = true;

        for(int j = 0; j < computers.length; j++) {
            if(i != j && computers[i][j] == 1 && check[j] == false) {
                check = dfs(computers, j, check);
            }
        }

        return check;
    }
}
