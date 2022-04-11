package programmers.level2;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();

        if(cacheSize == 0) {
            return 5 * cities.length;
        }

        for (String city : cities) {
            city = city.toLowerCase();
            if(q.contains(city)) {  // cache hit
                q.remove(city);
                q.add(city);
                answer += 1;
            } else {  // cache miss
                if(q.size() == cacheSize) {
                    q.poll();
                }
                q.add(city);
                answer += 5;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Cache s = new Cache();
        s.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"});
    }
}
