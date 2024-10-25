package baekjoon_2024;

import java.io.*;
import java.util.*;

public class P1931 {
    private static class Task {
        private int start;
        private int end;

        private Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        private int getStart() {
            return start;
        }

        private int getEnd() {
            return end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Task> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = s[0];
            int end = s[1];
            list.add(new Task(start, end));
        }

        list.sort(Comparator.comparing(Task::getEnd)
                .thenComparing(Task::getStart));
        int curEnd = 0;
        int answer = 0;
        for (Task task : list) {
            if (curEnd > task.getStart()) continue;

            curEnd = task.getEnd();
            answer++;
        }

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}
