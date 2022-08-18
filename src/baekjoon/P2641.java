package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2641 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        StringBuilder str = new StringBuilder();
        for (String alp : s) {
            str.append(alp);
        }

        StringBuilder reverseStr = new StringBuilder();
        for(int i = n - 1; i >= 0; i--) {
            int num = Integer.parseInt(s[i]);
            num = ((num + 2) % 4) == 0 ? 4 : (num + 2) % 4;
            reverseStr.append(num);
        }

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            str.append(str.charAt(0));
            str.delete(0, 1);
            reverseStr.append(reverseStr.charAt(0));
            reverseStr.delete(0, 1);
            map.put(str.toString(), 0);
            map.put(reverseStr.toString(), 0);
        }

        int m = Integer.parseInt(br.readLine());
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            String word = br.readLine();
            String ss = word.replace(" ", "");
            if(map.containsKey(ss)) {
                answer.add(word);
            }
        }

        System.out.println(answer.size());
        for (String ans : answer) {
            System.out.println(ans);
        }

        br.close();
    }
}
