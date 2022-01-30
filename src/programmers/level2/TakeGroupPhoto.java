package programmers.level2;

/**
 * 1차: solution 참고
 */
public class TakeGroupPhoto {
    char[] friends;
    boolean[] visited;
    int answer;

    public int solution(int n, String[] data) {
        friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        visited = new boolean[8];
        answer = 0;

        dfs(n, data, "");

        return answer;
    }

    private void dfs(int n, String[] data, String people) {
        if(people.length() == 8) {
            if(isPossible(n ,data, people)) {
                answer++;
            }
            return;
        }

        for(int i = 0; i < 8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(n, data, people + friends[i]);
                visited[i] = false;
            }
        }

        return;
    }

    private boolean isPossible(int n, String[] data, String people) {
        for(int i = 0; i < n; i++) {
            int fromPosition = people.indexOf(data[i].charAt(0));
            int toPosition = people.indexOf(data[i].charAt(2));
            char op = data[i].charAt(3);
            int distance = data[i].charAt(4) - '0';
            if (op == '=') {
                if(!(Math.abs(fromPosition - toPosition) - 1 == distance)) return false;
            }else if(op == '<') {
                if(!(Math.abs(fromPosition - toPosition) - 1 < distance)) return false;
            }else if(op == '>') {
                if(!(Math.abs(fromPosition - toPosition) - 1 > distance)) return false;
            }
        }

        return true;
    }
}
