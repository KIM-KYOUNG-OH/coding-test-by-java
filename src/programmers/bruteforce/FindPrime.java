package programmers.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPrime {
    int answer = 0;
    boolean[] check = new boolean[7];
    List<Integer> list = new ArrayList<>();

    void dfs(String numbers, String cur, int targetLength) {
        if(cur.length() == targetLength) {
            int num = Integer.parseInt(cur);
            if(!list.contains(num)) {
                list.add(num);
            }
            return;
        }else{
            for(int i = 0; i < numbers.length(); i++) {
                if(!check[i]) {
                    check[i] = true;
                    dfs(numbers, cur + numbers.charAt(i), targetLength);
                    check[i] = false;
                }
            }
        }
    }

    public int solution(String numbers) {
        int answer = 0;

        boolean[] isPrime = new boolean[10000000];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i < (int)Math.pow(isPrime.length, 0.5) + 1; i++) {
            for(int j = i + i; j < isPrime.length; j += i) {
                if(!isPrime[j]) continue;
                isPrime[j] = false;
            }
        }

        String cur = "";
        for(int i = 0; i < numbers.length(); i++) {
            dfs(numbers, cur, i + 1);
        }

        for(int i = 0; i < list.size(); i++) {
            if(isPrime[list.get(i)]) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        FindPrime s = new FindPrime();
        System.out.println(s.solution("17"));
    }
}
