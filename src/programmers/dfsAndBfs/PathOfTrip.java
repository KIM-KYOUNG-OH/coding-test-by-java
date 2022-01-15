package programmers.dfsAndBfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1차: solution 참고
 * 2차: solution 참고
 * 3차: 통과
 */
public class PathOfTrip {
    boolean[] visited;
    ArrayList<String> answers;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answers = new ArrayList<>();
        int count = 0;
        dfs(count, "ICN", "ICN", tickets);
        Collections.sort(answers);
        return answers.get(0).split(" ");
    }

    private void dfs(int count, String cur, String answer, String[][] tickets) {
        if(count == tickets.length) {
            answers.add(answer);
            return;
        }
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(cur)) {
                visited[i] = true;
                dfs(count + 1, tickets[i][1], answer + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}
