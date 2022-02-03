package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1차: solution 참고
 * 2차: solution 참고
 */
public class MenuRenewal {
//    Map<String, Integer> map;
//    int max;
//
//    public String[] solution(String[] orders, int[] course) {
//        PriorityQueue<String> pq = new PriorityQueue<>();
//        for(int i = 0; i < course.length; i++) {
//            map = new HashMap<>();
//            max = 0;
//
//            for(int j = 0; j < orders.length; j++) {
//                find(0, "", course[i], 0, orders[j]);
//            }
//
//            for(String s: map.keySet()) {
//                if(map.get(s) == max && max > 1) {
//                    pq.offer(s);
//                }
//            }
//        }
//
//        String[] answer = new String[pq.size()];
//        int k = 0;
//        while(!pq.isEmpty()) {
//            answer[k++] = pq.poll();
//        }
//        return answer;
//    }
//
//    private void find(int curCnt, String curStr, int targetLength, int curIdx, String order) {
//        if(curCnt == targetLength) {
//            char[] chars = curStr.toCharArray();
//            Arrays.sort(chars);
//            String temps = "";
//            for(int i = 0; i < chars.length; i++) temps += chars[i];
//            map.put(temps, map.getOrDefault(temps, 0) + 1);
//            max = Math.max(max, map.get(temps));
//            return;
//        }
//
//        for(int i = curIdx; i < order.length(); i++) {
//            char now = order.charAt(i);
//            find(curCnt + 1, curStr + now, targetLength, i + 1, order);
//        }
//    }
    Map<String, Integer> map;
    int max;

    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<>();

        for(int len: course) {
            map = new HashMap<>();
            max = 0;
            for(int i = 0; i < orders.length; i++) {
                find("", len, 0, orders[i]);
            }

            for(String key: map.keySet()) {
                if(map.get(key) == max && max > 1) {
                    pq.offer(key);
                }
            }
        }

        int k = 0;
        String[] result = new String[pq.size()];
        while(!pq.isEmpty()) {
            result[k++] = pq.poll();
        }

        return result;
    }

    private void find(String curStr, int targetLen, int idx, String order) {
        if(curStr.length() == targetLen) {
            char[] alps = curStr.toCharArray();
            Arrays.sort(alps);
            String temp = "";
            for(int i = 0; i < alps.length; i++) temp += alps[i];
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            max = Math.max(max, map.get(temp));
            return;
        }

        for(int i = idx; i < order.length(); i++) {
            char now = order.charAt(i);
            find(curStr + now, targetLen, i + 1, order);
        }
    }
}
