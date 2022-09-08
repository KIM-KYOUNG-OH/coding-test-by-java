package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P17264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int p = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int w = Integer.parseInt(s[0]);
        int l = Integer.parseInt(s[1]);
        int g = Integer.parseInt(s[2]);
        Map<String, Character> hacking = new HashMap<>();
        for(int i = 0; i < p; i++) {
            String[] ss = br.readLine().split(" ");
            hacking.put(ss[0], ss[1].charAt(0));
        }

        int grade = 0;
        for(int i = 0; i < n; i++) {
            String ss = br.readLine();
            if(!hacking.containsKey(ss)) {
                grade -= l;
                if(grade < 0) {
                    grade = 0;
                }
            } else {
                Character c = hacking.get(ss);
                if(c == 'W') {
                    grade += w;
                } else {
                    grade -= l;
                    if(grade < 0) {
                        grade = 0;
                    }
                }
            }

            if(grade >= g) {
                System.out.println("I AM NOT IRONMAN!!");
                return;
            }
        }

        System.out.println("I AM IRONMAN!!");

        br.close();
    }
}
