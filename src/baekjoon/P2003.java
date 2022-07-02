package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String[] stringArr = br.readLine().split(" ");
        int[] arr = Arrays.stream(stringArr).mapToInt(Integer::parseInt).toArray();

        int answer = 0;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                if(sum > m) break;
                sum += arr[j];
                if(sum == m) {
                    answer += 1;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
