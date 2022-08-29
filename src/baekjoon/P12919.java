package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12919 {
    static String s;
    static String t;
    static boolean isPossible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        isPossible = false;

        recursive(t);

        if (isPossible) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        br.close();
    }

    private static void recursive(String cur) {
        if(isPossible) return;
        else if(cur.length() == s.length()) {
            if(cur.equals(s)) isPossible = true;
            return;
        }

        if(cur.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder();
            for(int i = cur.length() - 1; i >= 1; i--) {
                sb.append(cur.charAt(i));
            }
            recursive(sb.toString());
        }

        if(cur.charAt(cur.length() - 1) == 'A') {
            recursive(cur.substring(0, cur.length() - 1));
        }
    }
}
