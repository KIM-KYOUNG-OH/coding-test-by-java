package programmers.level2;

/**
 * 1차: solution 참고, upcasting은 시간복잡도에 영향을 줌
 */
public class NumberOf123Land {
    public String solution(int n) {
        String[] numbers = new String[]{"4", "1", "2"};
        String answer = "";

        while(n > 0) {
            int remain = n % 3;
            answer = numbers[remain] + answer;
            n = (n - 1) / 3;
        }

        return answer;
    }
}
