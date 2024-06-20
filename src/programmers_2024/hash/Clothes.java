package programmers_2024.hash;

import java.util.HashMap;
import java.util.Map;

public class Clothes {
    public int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String kind = clothe[1];
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }

        int answer = 1;
        for (int val : map.values()) {
            answer *= (val + 1);
        }
        answer -= 1;

        return answer;
    }
}
