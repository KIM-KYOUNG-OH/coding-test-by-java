package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2594 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isScheduled = new boolean[1320];
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0].substring(2)) + Integer.parseInt(s[0].substring(0, 2)) * 60 - 10;
            if(start < 600) start = 600;
            int end = Integer.parseInt(s[1].substring(2)) + Integer.parseInt(s[1].substring(0, 2)) * 60 + 10;
            if(end >= 1320) end = 1319;

            for(int j = start; j < end; j++) {
                isScheduled[j] = true;
            }
        }

        int maxTerm = 0;
        int temp = 0;
        for(int i = 600; i < 1320; i++) {
            if(!isScheduled[i]) temp++;
            else {
                maxTerm = Math.max(maxTerm, temp);
                temp = 0;
            }
        }
        if(temp != 0) {
            maxTerm = Math.max(maxTerm, temp);
        }

        System.out.println(maxTerm);

        br.close();
    }
}
