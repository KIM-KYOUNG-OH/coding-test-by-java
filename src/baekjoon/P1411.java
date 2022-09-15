package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P1411 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for(int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        int len = words[0].length();
        int cnt = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                String word1 = words[i];
                String word2 = words[j];
                Map<Character, Character> exchangedAlps = new HashMap<>();
                boolean isPossible = true;
                for(int k = 0; k < len; k++) {
                    char alp1 = word1.charAt(k);
                    char alp2 = word2.charAt(k);
                    if(exchangedAlps.containsKey(alp1)) {
                        if(alp2 != exchangedAlps.get(alp1)) {
                            isPossible = false;
                            break;
                        }
                    } else {
                        if(exchangedAlps.containsValue(alp2)) {
                            isPossible = false;
                            break;
                        }
                    }

                    exchangedAlps.put(alp1, alp2);
                }

                if (isPossible) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

        br.close();
    }
}
