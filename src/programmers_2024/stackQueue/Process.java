package programmers_2024.stackQueue;

import java.util.Deque;
import java.util.LinkedList;

public class Process {
    public int solution(int[] priorities, int location) {
        int[] cntOfNum = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Deque<Node> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Node(i, priorities[i]));
            cntOfNum[priorities[i]]++;
        }

        int answer = 1;
        while (true) {
            int current = 0;
            for (int i = 9; i > 0; i--) {
                if (cntOfNum[i] > 0) {
                    current = i;
                    break;
                }
            }

            Node node = q.peekFirst();
            if (current != node.getPriority()) {
                q.addLast(q.pollFirst());
            } else {
                Node first = q.pollFirst();
                if (first.getIdx() == location) {
                    break;
                }

                answer++;
                cntOfNum[first.getPriority()]--;
            }
        }

        return answer;
    }

    private class Node {
        private int idx;
        private int priority;

        private Node(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }

        private int getIdx() {
            return idx;
        }

        private int getPriority() {
            return priority;
        }

        public String toString() {
            return getIdx() + ", " + getPriority();
        }
    }

    public static void main(String[] args) {
        Process s = new Process();
        int answer = s.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        System.out.println("answer = " + answer);
    }
}
