package programmers.heap;

import java.util.*;

public class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(((o1, o2) -> o1 - o2));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        for (String op : operations) {
            String[] opArr = op.split(" ");
            if(opArr[0].equals("I")) {
                minHeap.offer(Integer.parseInt(opArr[1]));
                maxHeap.offer(Integer.parseInt(opArr[1]));
            }else {
                if(minHeap.isEmpty()) continue;

                if(opArr[1].equals("1")) {
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                }else {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }

        if(minHeap.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }else {
            answer[0] = maxHeap.peek();
            answer[1] = minHeap.peek();
        }

        return answer;
    }
}
