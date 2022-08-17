package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class P20301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0];
        int k = s[1];
        int m = s[2];

        int delCount = 0;
        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            q.add(i);
        }

        boolean isClockwise = true;
        while(q.size() > 1) {
            if(isClockwise) {
                for(int i = 0; i < k - 1; i++) {
                    q.addLast(q.pollFirst());
                }
            } else {
                q.addFirst(q.pollLast());
                for(int i = 0; i < k - 1; i++) {
                    q.addFirst(q.pollLast());
                }
            }
            System.out.println(q.poll());
            delCount++;

            if(delCount == m) {
                delCount = 0;
                isClockwise = !isClockwise;
            }
        }

        System.out.println(q.poll());

        br.close();
    }
}
