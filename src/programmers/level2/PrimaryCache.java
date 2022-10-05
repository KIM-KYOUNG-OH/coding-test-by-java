package programmers.level2;

import java.util.LinkedList;

public class PrimaryCache {
    public int solution(int cacheSize, String[] cities) {
        int executionTime = 0;
        LinkedList<String> list = new LinkedList<>();

        if(cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            String name = city.toLowerCase();
            if(list.contains(name)) {
                executionTime += 1;
                list.remove(name);
                list.add(name);
            } else {
                executionTime += 5;
                if(list.size() >= cacheSize) {
                    list.remove(0);
                }
                list.add(name);
            }
        }

        return executionTime;
    }

    public static void main(String[] args) {
        PrimaryCache s = new PrimaryCache();
        s.solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
    }
}
