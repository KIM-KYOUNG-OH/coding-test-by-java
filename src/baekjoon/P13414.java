package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int k = Integer.parseInt(s[0]);
        int l = Integer.parseInt(s[1]);
        List<String> orders = new ArrayList<>();
        List<String> waiting = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < l; i++) {
            String studentNumber = br.readLine();
            orders.add(studentNumber);
        }

        for (String studentNumber : orders) {
            if(map.containsKey(studentNumber)) {
                waiting.set(map.get(studentNumber), "-1");
            }
            waiting.add(studentNumber);
            map.put(studentNumber, waiting.size() - 1);
        }

        int announceCount = 0;
        for (String num : waiting) {
            if (announceCount >= k) break;
            else if (num.equals("-1")) continue;

            System.out.println(num);
            announceCount++;
        }

        br.close();
    }

}
