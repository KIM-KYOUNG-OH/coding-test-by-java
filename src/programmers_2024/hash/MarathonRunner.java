package programmers_2024.hash;

import java.util.HashMap;
import java.util.Map;

public class MarathonRunner {
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> pMap = new HashMap<>();
        for (String name : participant) {
            pMap.put(name, pMap.getOrDefault(name, 0) + 1);
        }

        Map<String, Integer> cMap = new HashMap<>();
        for (String name : completion) {
            cMap.put(name, cMap.getOrDefault(name, 0) + 1);
        }

        for (String key : cMap.keySet()) {
            Integer pCnt = pMap.get(key);
            Integer cCnt = cMap.get(key);

            if (pCnt == null) {
                return key;
            } else if (pCnt - cCnt > 0) {
                return key;
            }

            pMap.remove(key);
        }

        String answer = "";
        for (String s : pMap.keySet()) {
            answer = s;
            break;
        }

        return answer;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        int test = map.get("test");
        System.out.println("test = " + test);
    }
}
