package programmers.level2;

public class CountPrime {
    private static boolean isPrime(long num) {
        if (num <= 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;
//        int len = 1000000;
//        boolean[] isPrime = new boolean[len];
//        Arrays.fill(isPrime, true);
//        findPrime(len, isPrime);

        String num = toKnum(n, k);
//        int j = 0;
//        for(int i = 0; i < num.length() - 1; i = j) {
//            for(j = i + 1; j < num.length(); j++) {
//                if(num.charAt(j) == '0') break;
//            }
//            if(isPrime(Long.parseLong(num.substring(i, j)))) answer++;
//        }
        String[] numbers = num.split("0");
        for (String number : numbers) {
            if (!number.equals("")) {
                if (isPrime(Long.parseLong(number))) answer++;
            }
        }

        return answer;
    }

    private String toKnum(int n, int k) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            res.insert(0, n % k);
            n /= k;
        }
        return res.toString();
    }
//    private void findPrime(int len, boolean[] isPrime) {
//        isPrime[0] = false;
//        isPrime[1] = false;
//        for(int i = 2; i <= Math.sqrt(len); i++) {
//            for(int j = i + i; j < len; j += i) {
//                isPrime[j] = false;
//            }
//        }
//    }
}
