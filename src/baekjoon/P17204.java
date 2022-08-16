package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        List<Integer> history = new ArrayList<>();
        Map<Integer, Integer> point = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            point.put(i, num);
        }

        int cnt = 0;
        int cur = 0;
        history.add(0);
        while(true) {
            cnt++;
            int next = point.get(cur);
            if(next == k) break;
            if(history.contains(next)) {
                cnt = -1;
                break;
            }
            history.add(next);
            cur = next;
        }

        System.out.println(cnt);

        br.close();
    }
}
