package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class P2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<String> in = new LinkedList<>();
        LinkedList<String> out = new LinkedList<>();
        Map<String, Integer> passed = new HashMap<>();

        for(int i = 0; i < n; i++) {
            in.add(br.readLine());
        }

        for(int i = 0; i < n; i++) {
            out.add(br.readLine());
        }

        int answer = 0;
        while (!in.isEmpty()) {
            if(passed.containsKey(in.peek())) in.poll();
            else {
                if(in.peek().equals(out.peek())) {
                    in.poll();
                    String poll = out.poll();
                    passed.put(poll, 0);
                } else {
                    answer++;
                    String poll = out.poll();
                    passed.put(poll, 0);
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}
