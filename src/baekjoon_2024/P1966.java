package baekjoon_2024;

import java.io.*;
import java.util.*;

public class P1966 {
    private static class Document {
        private int index;
        private int priority;

        private Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        private int getIndex() {
            return index;
        }

        private int getPriority() {
            return priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = s[0];
            int m = s[1];
            int[] priorities = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Document> q = new LinkedList<>();
            for (int j = 0; j < priorities.length; j++) {
                int priority = priorities[j];
                pq.add(priority);
                q.add(new Document(j, priority));
            }

            int answer = 1;
            while (!q.isEmpty()) {
                Document cur = q.poll();
                if (pq.peek() == cur.getPriority()) {
                    pq.poll();
                    if (cur.getIndex() == m) {
                        break;
                    } else {
                        answer++;
                    }
                } else {
                    q.add(cur);
                }
            }

            bw.write(answer + "\n");
        }

        bw.close();
        br.close();
    }
}
