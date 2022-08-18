package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P1972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while(!(s = br.readLine()).equals("*")) {
            if(isSurprisedWord(s)) {
                System.out.println(s + " is surprising.");
            } else {
                System.out.println(s + " is NOT surprising.");
            }
        }

        br.close();
    }

    private static boolean isSurprisedWord(String s) {
        int n = s.length();
        Map<String, Integer> map;
        for(int diff = 1; diff < n; diff++) {
            map = new HashMap<>();
            for(int i = 0; i < n - diff; i++) {
                String temp = s.charAt(i) + "" + s.charAt(i + diff);
//                System.out.println("temp = " + temp);
                if(map.containsKey(temp)) return false;
                map.put(temp, 0);
            }
        }

        return true;
    }
}
