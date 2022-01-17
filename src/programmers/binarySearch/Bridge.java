package programmers.binarySearch;

import java.util.Arrays;

/**
 * 1차: solution 참고
 * 2차: solution 참고
 * 3차: solution 참고(마지막돌 사이 거리, sorting)
 * 4차: 통과
 */
public class Bridge {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        return binary(distance, rocks, n);
    }

    private int binary(int distance, int[] rocks, int n) {
        long ans = 0;
        long left = 1, right = distance, mid = 0;

        while(left <= right) {
            int delRockCnt = 0;
            int prev = 0;
            mid = (left + right) / 2;  // 돌 사이 거리 최소값

            for (int rock : rocks) {
                if (rock - prev < mid) {
                    delRockCnt++;
                } else {
                    prev = rock;
                }
            }

            if(distance - prev < mid) delRockCnt++;

            if(delRockCnt <= n) {
                ans = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return (int)ans;
    }
}
