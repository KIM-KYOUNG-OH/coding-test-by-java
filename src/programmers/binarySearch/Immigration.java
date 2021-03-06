package programmers.binarySearch;

import java.util.Arrays;

/**
 * 1차: solution 참고
 * 2차: 통과, 사칙연산 upcasting 주의
 */
public class Immigration {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = (long) n * times[times.length - 1];
        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for(int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }
            if(sum < n) {
                left = mid + 1;
            }else {
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
}
