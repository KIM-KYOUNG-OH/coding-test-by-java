package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1091 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] matrix = new int[n];
        for(int i = 0; i < n; i++) {
            matrix[i] = i;
        }

        int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] changeRule = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;

        int[] temp;
        StringBuilder sb = new StringBuilder();
        for (int i : matrix) {
            sb.append(i);
        }
        String first = sb.toString();
        while(true) {
            if(isCorrect(target, matrix)) {
                break;
            }

            temp = new int[n];
            for(int i = 0; i < n; i++) {
                temp[changeRule[i]] = matrix[i];
            }
            matrix = temp;
            sb.delete(0, sb.length());
            for (int i : matrix) {
                sb.append(i);
            }

            if(first.equals(sb.toString())) {
                System.out.println(-1);
                return;
            }
            answer++;
        }

        System.out.println(answer);

        br.close();
    }

    private static boolean isCorrect(int[] target, int[] matrix) {
        int[] cur = new int[n];
        for(int i = 0; i < n; i++) {
            int card = matrix[i];
            int host = i % 3;
            cur[card] = host;
        }

        return Arrays.toString(target).equals(Arrays.toString(cur));
    }
}
