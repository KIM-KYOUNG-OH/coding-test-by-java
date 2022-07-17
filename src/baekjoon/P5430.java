package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class P5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String p = br.readLine().replace("RR", "");
            int n = Integer.parseInt(br.readLine());
            LinkedList<Integer> list = new LinkedList<>();
            String arrStr = br.readLine();
            if(n > 0) {
                int[] arr = Arrays.stream(arrStr.substring(1, arrStr.length() - 1).split(","))
                                    .mapToInt(Integer::parseInt).toArray();
                for (int num : arr) {
                    list.add(num);
                }
            }

            boolean breaker = false;
            boolean cursor = true;
            for (char ch : p.toCharArray()) {
                if(ch == 'R') {
                    cursor = !cursor;
                    continue;
                }

                if(list.size() == 0) {
                    bw.write("error\n");
                    breaker = true;
                    break;
                }

                if(cursor) {
                    list.removeFirst();
                } else {
                    list.removeLast();
                }
            }

            if(breaker) {
                continue;
            }

            if(list.size() == 0) {
                bw.write("[]\n");
                continue;
            }

            StringBuilder answer = new StringBuilder("[");
            if(!cursor) Collections.reverse(list);
            while(list.size() > 0) {
                answer.append(list.removeFirst());
                if(list.size() == 0) {
                    answer.append("]");
                } else {
                    answer.append(",");
                }
            }

            bw.write(answer + "\n");
        }

        br.close();
        bw.close();
    }
}
