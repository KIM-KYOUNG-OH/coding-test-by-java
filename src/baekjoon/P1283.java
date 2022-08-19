package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String s = br.readLine();

            // 1 단계
            String[] arr;
            if(s.contains(" ")) {
                arr = s.split(" ");
            } else {
                arr = new String[]{s};
            }

            boolean breaker = false;
            for (int j = 0; j < arr.length; j++) {
                char c = arr[j].substring(0, 1).toLowerCase().charAt(0);
                if(!map.containsKey(c)) {
                    breaker = true;
                    map.put(c, 0);
                    arr[j] = "[" + arr[j].charAt(0) + "]" + arr[j].substring(1);
                    break;
                }
            }

            if(breaker) {
                for (String ss : arr) {
                    System.out.print(ss + " ");
                }
                System.out.print("\n");
                continue;
            }

            // 2 단계
            String lowerCase = s.toLowerCase();
            int idx = -1;
            for(int j = 0; j < s.length(); j++) {
                char c = lowerCase.charAt(j);
                if(c == ' ') continue;

                if(!map.containsKey(c)) {
                    map.put(c, 0);
                    idx = j;
                    break;
                }
            }

            if(idx == -1) {
                System.out.println(s);
            } else {
                System.out.println(s.substring(0, idx) + "[" + s.charAt(idx) + "]" + s.substring(idx + 1));
            }
        }

        br.close();
    }
}
