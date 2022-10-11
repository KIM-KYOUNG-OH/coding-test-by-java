package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class DiscountEvent {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> cur = new HashMap<>();
        for(int i = 0; i < 10; i++) {
            String item = discount[i];
            cur.put(item, cur.getOrDefault(item, 0) + 1);
        }
        if(isPossible(want, number, cur)) {
            answer++;
        }

        int n = discount.length;
        for(int i = 1; i <= n - 10; i++) {
            String prev = discount[i - 1];
            cur.put(prev, cur.get(prev) - 1);
            String next = discount[i + 9];
            cur.put(next, cur.getOrDefault(next, 0) + 1);
            if(isPossible(want, number, cur)) answer++;
        }

        return answer;
    }

    private boolean isPossible(String[] want, int[] number, Map<String, Integer> cur) {
        for (int i = 0; i < want.length; i++) {
            if(cur.getOrDefault(want[i], 0) != number[i]) return false;
        }

        return true;
    }
}
