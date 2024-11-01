package baekjoon_2024;

import java.io.*;

public class P9663 {
    private static int n;
    private static int[] arr;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        answer = 0;

        nQueen(0);

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }

    private static void nQueen(int depth) {
        if (depth == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if (isPossible(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    private static boolean isPossible(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[i] == arr[depth]) {
                return false;
            }

            if (Math.abs(i - depth) == Math.abs(arr[i] - arr[depth])) {
                return false;
            }
        }

        return true;
    }
}
