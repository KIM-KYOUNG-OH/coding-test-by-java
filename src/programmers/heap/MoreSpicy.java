package programmers.heap;

import java.util.PriorityQueue;

public class MoreSpicy {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int s : scoville) {
            heap.offer(s);
        }

        while(heap.peek() < K) {
            int peek = heap.poll();
            if (heap.size() == 0) {
                return -1;
            }
            int nextPeek = heap.poll();
            heap.offer(peek + nextPeek * 2);
            answer++;
        }

        return answer;
    }
}
