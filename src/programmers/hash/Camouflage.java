package programmers.hash;

import java.util.*;

public class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, List<String>> map = new HashMap<>();

        for (String[] cloth : clothes) {
            String name = cloth[0];
            String kind = cloth[1];
            if(map.containsKey(kind)) {
                map.get(kind).add(name);
            }else {
                map.put(kind, new ArrayList<>(Arrays.asList(name)));
            }
        }

        for (String key : map.keySet()) {
            answer *= (map.get(key).size() + 1);
        }

        return answer - 1;
    }
}
