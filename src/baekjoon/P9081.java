package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9081 {
    static char[] charArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            charArr = br.readLine().toCharArray();

            next();

            for(int j = 0; j < charArr.length; j++) {
                sb.append(charArr[j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static void next() {
        int i = charArr.length - 1;
        while (i > 0 && charArr[i - 1] >= charArr[i]) i--;
        if(i == 0) return;
        i--;

        int j = charArr.length - 1;
        while (charArr[i] >= charArr[j]) j--;

        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;

        int k = charArr.length - 1;
        i++;
        while(i < k) {
            temp = charArr[i];
            charArr[i] = charArr[k];
            charArr[k] = temp;
            i++;
            k--;
        }
    }
}
