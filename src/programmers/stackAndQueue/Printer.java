package programmers.stackAndQueue;

import java.util.*;

public class Printer {
    static class Print {
        int pos;
        int priority;

        public Print(int pos, int priority) {
            this.pos = pos;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {

        Queue<Print> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Print(i, priorities[i]));
        }

        int answer = 1;
        while(!q.isEmpty()) {
            Print p = q.poll();
            boolean flag = true;
            for (Print t : q) {
                if(t.priority > p.priority) {
                    flag = false;
                    break;
                }
            }
            if(!flag) {
                q.add(p);
            }else {
                if(p.pos == location) {
                    break;
                }
                answer++;
            }
        }

        return answer;
    }
}
