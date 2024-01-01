package programmers2024.hash;

import java.util.HashMap;

public class PocketMon {
    public int solution(int[] nums) {
        int answer;
        int pick = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int kinds = map.keySet().size();
        answer = Math.min(kinds, pick);
        return answer;
    }
}
