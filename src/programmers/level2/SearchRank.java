package programmers.level2;

import java.util.*;

/**
 * 1차: solution 참고
 */
public class SearchRank {
    Map<String, List<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        int[] result = new int[query.length];
        for(int i = 0; i < info.length; i++) {
            String[] infoArr = info[i].split(" ");
            comb("", 0, infoArr);
        }

        List<String> list = new ArrayList<>(map.keySet());
        for(int i = 0; i < list.size(); i++) {
            List<Integer> temp = map.get(list.get(i));
            Collections.sort(temp);
        }

        int queryIdx = 0;
        for(String condition: query) {
            condition = condition.replace(" and ", "");
            String[] conArr = condition.split(" ");

            result[queryIdx++] = binarySearch(conArr[0], Integer.parseInt(conArr[1]));
        }

        return result;
    }

    private int binarySearch(String condition, int grade) {
        if(!map.containsKey(condition)) return 0;
        List<Integer> list = map.get(condition);
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(grade > list.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return list.size() - start;
    }

    private void comb(String cur, int idx, String[] infoArr) {
        if(idx == 4) {
            if(map.containsKey(cur)) {
                map.get(cur).add(Integer.parseInt(infoArr[idx]));
            }else {
                List<Integer> temp = new ArrayList<>();
                temp.add(Integer.parseInt(infoArr[idx]));
                map.put(cur, temp);
            }
            return;
        }

        comb(cur + "-", idx + 1, infoArr);
        comb(cur + infoArr[idx], idx + 1, infoArr);
    }
}
