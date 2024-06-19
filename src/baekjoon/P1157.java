package baekjoon;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;

public class P1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine().toUpperCase();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String ch = s.substring(i, i + 1);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int max = Collections.max(map.values());
        String result = "?";
        for (String str : map.keySet()) {
            if (map.get(str) == max) {
                if (!result.equals("?")) {
                    result = "?";
                    break;
                }

                result = str;
            }
        }

        bw.write(result);

        bw.flush();
        br.close();
    }
}
