package programmers_2024.stackQueue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DevelopFeature {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add(i);
        }

        List<Integer> answer = new ArrayList<>();
        int days = 1;
        int completeCnt = 0;
        while (q.size() > 0) {
            int idx = q.peekFirst();
            int work = speeds[idx] * days;
            boolean isDone = false;

            if (progresses[idx] + work >= 100) {
                completeCnt++;
                q.pollFirst();
                isDone = true;
            } else {
                days++;
            }

            if (completeCnt > 0 && !isDone) {
                answer.add(completeCnt);
                completeCnt = 0;
            }
        }

        if (completeCnt > 0) {
            answer.add(completeCnt);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        DevelopFeature s = new DevelopFeature();
        int[] answer = s.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
