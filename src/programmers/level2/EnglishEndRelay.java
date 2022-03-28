package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class EnglishEndRelay {
    public int[] solution(int n, String[] words) {
        int[] turns = new int[n + 1];
        char lastWord = 'a';
        int[] answer = new int[2];
        boolean breaker = false;
        Map<String, Integer> duplicatedCheck = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            if(i == 0) {
                turns[1]++;
                lastWord = words[i].charAt(words[i].length() - 1);
                duplicatedCheck.put(words[i], 0);
                continue;
            }

            int ni = i % n + 1;
            if(words[i].charAt(0) == lastWord && !duplicatedCheck.containsKey(words[i])) {
                turns[ni]++;
                lastWord = words[i].charAt(words[i].length() - 1);
                duplicatedCheck.put(words[i], 0);
            } else {
                answer[0] = ni;
                answer[1] = ++turns[ni];
                breaker = true;
                break;
            }
        }

        if(!breaker) {
            answer = new int[]{0, 0};
        }

        return answer;
    }

    public static void main(String[] args) {
        EnglishEndRelay s = new EnglishEndRelay();
        s.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
    }
}
