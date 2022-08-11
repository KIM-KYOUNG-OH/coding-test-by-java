package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12904 {
    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        while(T.length() > S.length()) {
            char last = T.charAt(T.length() - 1);
            T = T.substring(0, T.length() - 1);
            if (last == 'B') {
                T = reverse(T);
            }
        }

        if(T.equals(S)) System.out.println(1);
        else System.out.println(0);

        br.close();
    }
}
