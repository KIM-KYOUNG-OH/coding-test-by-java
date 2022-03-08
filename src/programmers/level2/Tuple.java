package programmers.level2;

import java.util.*;

/**
 * 1차: solution 참고
 */
class Tuple {
    public int[] solution(String s) {
        String[] strs = s.replaceAll("[{}]", " ").trim().split(" , ");
        int[] answer = new int[strs.length];
        Set<String> check = new HashSet<>();
        Arrays.sort(strs, (o1, o2) -> o1.length() - o2.length());
        int i = 0;
        for (String str : strs) {
            for (String num : str.split(",")) {
                if(check.contains(num)) continue;
                check.add(num);
                answer[i++] = Integer.parseInt(num);
            }
        }
        return answer;
    }
}
