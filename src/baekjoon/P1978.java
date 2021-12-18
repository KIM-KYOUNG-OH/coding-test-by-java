package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        bf.readLine();
        StringTokenizer numbers = new StringTokenizer(bf.readLine(), " ");

        boolean[] isPrime = new boolean[1001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i <= Math.sqrt(1000); i++) {
            for(int j = i * 2; j < 1001; j += i) {
                if(isPrime[j]) {
                    isPrime[j] = false;
                }
            }
        }

        int answer = 0;
        while(numbers.hasMoreTokens()) {
            int num = Integer.parseInt(numbers.nextToken());
            if(isPrime[num]) {
                answer++;
            }
        }

        bf.close();
        System.out.println(answer);
    }
}
