package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        if(n <= k){
            System.out.println(0);
            return;
        }

        for(int i = 0; i < k - 1; i++) {
            int base = -1;
            while(Math.pow(2, base + 1) <= n) {
                base++;
            }

            n -= (int)Math.pow(2, base);

            if(n == 0) {
                System.out.println(0);
                return;
            }
        }

        int base = 0;
        while(Math.pow(2, base) < n){
            base++;
        }

        System.out.println((int)(Math.pow(2, base)) - n);
    }
}
