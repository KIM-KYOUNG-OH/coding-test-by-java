package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(arithmeticSequence(Integer.parseInt(br.readLine())));
    }

    public static int arithmeticSequence(int num) {
        int cnt = 0;

        if(num < 100) {
            return num;
        }

        cnt = 99;
        if (num == 1000) {
            num = 999;
        }

        for(int i = 100; i <= num; i++){
            int first = i / 100;
            int second = (i / 10) % 10;
            int third = i % 10;

            if((first - second) == (second - third)) {
                cnt++;
            }
        }

        return cnt;
    }
}
