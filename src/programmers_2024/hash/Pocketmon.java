package programmers_2024.hash;

import java.util.HashMap;
import java.util.Map;

public class Pocketmon {
    public int solution(int[] nums) {

        int len = nums.length;
        int pick = len / 2;
        Map<Integer, Boolean> hash = new HashMap<>();

        for (int num : nums) {
            hash.put(num, true);
        }
        int kindCnt = hash.size();

        int answer = 0;
        if (pick > kindCnt) {
            answer = kindCnt;
        } else {
            answer = pick;
        }

        return answer;
    }
}
