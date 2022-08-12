package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P1614 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int finger = Integer.parseInt(br.readLine());
        int[] fingers = new int[]{1, 2, 3, 4, 5};
        BigInteger use = BigInteger.valueOf(Integer.parseInt(br.readLine()));
        BigInteger answer = null;
        boolean exists = false;
        for (int i : fingers) {
            if(i == finger) exists = true;
        }
        if(!exists) {
            System.out.println(0);
            return;
        }

        switch (finger) {
            case 1:
                answer = use.multiply(BigInteger.valueOf(8));
                break;

            case 2:
                BigInteger multiply = use.divide(BigInteger.valueOf(2)).multiply(BigInteger.valueOf(8));
                if(use.remainder(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(1)) == 0) {
                    answer = multiply.add(BigInteger.valueOf(7));
                } else {
                    answer = multiply.add(BigInteger.valueOf(1));
                }
                break;

            case 3:
                answer = use.subtract(BigInteger.valueOf(1)).multiply(BigInteger.valueOf(4)).add(BigInteger.valueOf(6));
                break;

            case 4:
                if(use.remainder(BigInteger.valueOf(2)).compareTo(BigInteger.valueOf(1)) == 0) {
                    answer = use.divide(BigInteger.valueOf(2)).multiply(BigInteger.valueOf(8)).add(BigInteger.valueOf(5));
                } else {
                    answer = use.divide(BigInteger.valueOf(2)).multiply(BigInteger.valueOf(8)).add(BigInteger.valueOf(3));
                }
                break;

            case 5:
//                answer = 4 + 8 * use;
                answer = use.multiply(BigInteger.valueOf(8)).add(BigInteger.valueOf(4));
                break;
        }

        System.out.println(answer);

        br.close();
    }
}
