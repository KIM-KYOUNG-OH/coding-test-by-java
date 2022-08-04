package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P2659 {
    static Map<String, Integer> map = new HashMap<>();
    static char[] number = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int min = 9999;
        for(int i = 0; i < 4; i++) {
            int num = Integer.parseInt(nums[i] + nums[(i + 1) % 4] + nums[(i + 2) % 4] + nums[(i + 3) % 4]);
            min = Math.min(min, num);
        }

        memoization("");

        System.out.println(map.get(String.valueOf(min)));

        br.close();
    }

    private static void memoization(String cur) {
        if(cur.length() >= 4) {
            String[] candidates = new String[4];
            candidates[0] = cur;
            for (int i = 1; i < 4; i++) {
                String s = "" + cur.charAt(i) + cur.charAt((i + 1) % 4) + cur.charAt((i + 2) % 4) + cur.charAt((i + 3) % 4);
                candidates[i] = s;
            }

            for (String candidate : candidates) {
                if(map.containsKey(candidate)) return;
            }

            map.put(cur, map.size() + 1);
            return;
        }

        for(int i = 0; i < number.length; i++) {
            memoization(cur + number[i]);
        }
    }
}
