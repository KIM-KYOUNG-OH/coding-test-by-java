package programmers.stackAndQueue;

import java.util.*;

public class DevelopFunction {
    public int[] solution(int[] progresses, int[] speeds) {

        // restWorkDuringDay = ceiling((100 - grogress) / speed)으로 배열 생성
        // 순차적으로 내림차순된 개수들 반환
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++) {
            int remainDay = (int) Math.ceil((100 - progresses[i]) / (double)speeds[i]);

            if (!q.isEmpty() && q.peek() < remainDay) {
                answerList.add(q.size());
                q.clear();
            }

            q.add(remainDay);
        }

        answerList.add(q.size());

        int[] answerArray = new int[answerList.size()];
        for (int i = 0; i < answerArray.length; i++) {
            answerArray[i] = answerList.get(i);
        }

        return answerArray;
    }

}
