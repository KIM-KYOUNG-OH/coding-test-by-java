package programmers.level2;

import java.util.LinkedList;
import java.util.Stack;

public class DeliveryBox {
    public int solution(int[] order) {
        LinkedList<Integer> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int i = 1; i <= order.length; i++) {
            q.add(i);
        }

        for (int ord : order) {
            boolean isDone = false;
            while(true) {
                if(q.size() == 0 && stack.peek() != ord) {
                    isDone = true;
                    break;
                }

                if(!q.isEmpty() && q.getFirst() == ord) {
                    q.poll();
                    answer++;
                    break;
                } else if(!stack.isEmpty() && stack.peek() == ord) {
                    stack.pop();
                    answer++;
                    break;
                }

                stack.add(q.poll());
            }

            if(isDone) break;
        }

        return answer;
    }
}
