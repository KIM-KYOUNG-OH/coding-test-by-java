package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if(input.equals("")) {
            System.out.println("Error!");
            return;
        }
        String answer = "";

        if(input.contains("_")) {  // 입력값이 C++
            for (char c : input.toCharArray()) {
                if(c == '_') continue;
                int ascii = (int) c - 'a';
                if(ascii < 0 || ascii > 25) {
                    System.out.println("Error!");
                    return;
                }
            }

            int underBarCount = 0;
            for (char c : input.toCharArray()) {
                if(c == '_') underBarCount++;
            }
            String[] arr = input.split("_");
            if(arr.length <= underBarCount) {
                System.out.println("Error!");
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if(arr[i].length() == 0) {
                    System.out.println("Error!");
                    return;
                }

                if(i == 0) {
                    sb.append(arr[i]);
                } else {
                    sb.append(String.valueOf(arr[i].charAt(0)).toUpperCase());
                    sb.append(arr[i].substring(1));
                }
            }
            answer = sb.toString();
        } else {  // 입력값이 java
            // 소문자 단일 단어인 경우 그냥 출력
            boolean isSingleWord = true;
            for (char c : input.toCharArray()) {
                if(c - 'a' < 0) {
                    isSingleWord = false;
                }
            }

            if(isSingleWord) {
                System.out.println(input);
                return;
            }

            if(input.charAt(0) - 'a' < 0) {
                System.out.println("Error!");
                return;
            }

            StringBuilder sb = new StringBuilder();
            int start = 0;
            for (int i = 1; i < input.length(); i++) {
                if((int) input.charAt(i) - 'a' < 0) {
                    sb.append(input.toLowerCase(), start, i);
                    sb.append("_");
                    start = i;
                }
            }

            sb.append(input.substring(start).toLowerCase());

            answer = sb.toString();
        }

        System.out.println(answer);

        br.close();
    }
}
