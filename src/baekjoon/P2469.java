package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2469 {
    static int k;
    static int n;
    static char[][] matrix;
    static char[] chars;
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        matrix = new char[n][k - 1];
        for(int i = 0; i < n; i++) {
            String ss = br.readLine();
            for(int j = 0; j < k - 1; j++) {
                matrix[i][j] = ss.charAt(j);
            }
        }

        char[] prev = new char[k];
        for(int i = 0; i < k; i++) {
            prev[i] = (char) (i + 65);
        }

        for(int i = 0; i < n; i++) {
            if(matrix[i][0] == '?') break;
            for(int j = 0; j < k - 1; j++) {
                if(matrix[i][j] == '-') {
                    char temp = prev[j];
                    prev[j] = prev[j + 1];
                    prev[j + 1] = temp;
                }
            }
        }

        char[] next = s.toCharArray();
        for(int i = n - 1; i >= 0; i--) {
            if(matrix[i][0] == '?') break;
            for(int j = 0; j < k - 1; j++) {
                if(matrix[i][j] == '-') {
                    char temp = next[j];
                    next[j] = next[j + 1];
                    next[j + 1] = temp;
                }
            }
        }

//        System.out.println("prev = ");
//        for(int i = 0; i < k; i++) {
//            System.out.print(prev[i]);
//        }
//        System.out.println();
//
//        System.out.println("next = ");
//        for(int i = 0; i < k; i++) {
//            System.out.print(next[i]);
//        }
//        System.out.println();

        chars = new char[]{'*', '-'};
        answer = "";
        for(int i = 0; i < k - 1; i++) {
            answer += "x";
        }

        recursive(k, prev, next, "");

        System.out.println(answer);

        br.close();
    }

    private static void recursive(int k, char[] prev, char[] next, String cur) {
        if(cur.length() == k - 1) {
            char[] copy = new char[k];
            for(int i = 0; i < k; i++) {
                copy[i] = prev[i];
            }

            for(int i = 0; i < k - 1; i++) {
                if(cur.charAt(i) == '-') {
                    char temp = copy[i];
                    copy[i] = copy[i + 1];
                    copy[i + 1] = temp;
                }
            }

            String fix = String.valueOf(copy);
            if(fix.equals(String.valueOf(next))) answer = cur;

            return;
        }

        if(cur.length() > 1 && cur.charAt(cur.length() - 1) == '-') {
            recursive(k, prev, next, cur + '*');
        } else {
            for(int i = 0; i < 2; i++) {
                recursive(k, prev, next, cur + chars[i]);
            }
        }
    }
}
