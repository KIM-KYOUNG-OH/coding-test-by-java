package programmers;

import java.util.LinkedList;

public class MakeSameSumOfTwoQueue {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        LinkedList<Integer> q1 = new LinkedList<>();
        for(int element: queue1) {
            q1.add(element);
            sum1 += element;
        }

        LinkedList<Integer> q2 = new LinkedList<>();
        for(int element: queue2) {
            q2.add(element);
            sum2 += element;
        }

        int cnt = 0;

        while(true) {
            if(cnt > (queue1.length + queue2.length) * 2) return -1;
            if(sum1 == sum2) return cnt;

            if(sum1 < sum2) {
                int poll = q2.poll();
                q1.add(poll);
                sum1 += poll;
                sum2 -= poll;
            } else {
                int poll = q1.poll();
                q2.add(poll);
                sum2 += poll;
                sum1 -= poll;
            }
            cnt++;
        }
    }
}
