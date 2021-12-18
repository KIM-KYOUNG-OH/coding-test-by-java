package baekjoon;

import java.util.Arrays;

public class P4673 {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();

        boolean[] isSelfNumber = new boolean[10001];
        Arrays.fill(isSelfNumber, Boolean.TRUE);

        for(int i = 1; i < 10001; i++) {
            int sum = getSum(i);

            if(sum < 10001) {
                isSelfNumber[sum] = false;
            }
        }

        for(int i = 1; i < 10001; i++) {
            if(isSelfNumber[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int getSum(int number) {

        int sum = number;

        while(number != 0) {
            sum = sum + (number % 10);
            number = number / 10;
        }

        return sum;
    }
}

