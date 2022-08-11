package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P11332 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        for(int i = 0; i < c; i++) {
            String[] s = br.readLine().split(" ");
            String timeComplexity = s[0];
            BigInteger n = new BigInteger(s[1]);
            BigInteger t = new BigInteger(s[2]);
            BigInteger l = new BigInteger(s[3]);
            if(isPossible(timeComplexity, n, t, l)) {
                System.out.println("May Pass.");
            } else {
                System.out.println("TLE!");
            }
        }

        br.close();
    }

    private static boolean isPossible(String timeComplexity, BigInteger n, BigInteger t, BigInteger l) throws IOException {
        BigInteger limit = l.multiply(BigInteger.valueOf(100000000));
        BigInteger tries = null;
        switch (timeComplexity) {
            case "O(N)":
                tries = t.multiply(n);
                break;
            case "O(N^2)":
                tries = t.multiply(n.pow(2));
                break;
            case "O(N^3)":
                tries = t.multiply(n.pow(3));
                break;
            case "O(2^N)":
                tries = t.multiply(BigInteger.valueOf(2).pow(n.intValue()));
                break;
            case "O(N!)":
                int intN = n.intValue();
                while (intN-- > 0) {
                    n = n.multiply(BigInteger.valueOf(intN));

                    if(t.multiply(n).compareTo(limit) == 1) return false;
                }
                tries = t.multiply(n);
                break;
        }

        if(tries.compareTo(limit) == -1 || tries.compareTo(limit) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
