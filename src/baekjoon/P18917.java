package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P18917 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        long sum = 0;
        long xor = 0;
        for(int i = 0 ; i < m; i++) {
            String s = br.readLine();
            int[] operation;
            if(!s.contains(" ")) {
                operation = new int[]{Integer.parseInt(s)};
            } else {
                operation = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            if(operation[0] == 1) {
                sum += operation[1];
                xor ^= operation[1];
            } else if(operation[0] == 2) {
                sum -= operation[1];
                xor ^= operation[1];
            } else if(operation[0] == 3) {
                System.out.println(sum);
            } else if(operation[0] == 4) {
                System.out.println(xor);
            }
        }

        br.close();
    }
}
