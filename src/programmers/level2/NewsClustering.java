package programmers.level2;

import java.util.*;

/**
 * 1차: 통과
 */
public class NewsClustering {
    public int solution(String str1, String str2) {
        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();

        for(int i = 0; i < str1.length() - 1; i++) {
            String temp = str1.substring(i, i + 2);
            if(!isAlphabet(temp)) continue;
            temp = temp.toUpperCase();
            str1List.add(temp);
        }

        for(int i = 0; i < str2.length() - 1; i++) {
            String temp = str2.substring(i, i + 2);
            if(!isAlphabet(temp)) continue;
            temp = temp.toUpperCase();
            str2List.add(temp);
        }

        Map<String, Integer> str1Map = new HashMap<>();
        Map<String, Integer> str2Map = new HashMap<>();

        for(String s: str1List) str1Map.put(s, str1Map.getOrDefault(s, 0) + 1);
        for(String s: str2List) str2Map.put(s, str2Map.getOrDefault(s, 0) + 1);

        int intersectionSize = 0;
        int unionSize = 0;
        List<String> intersection = new ArrayList<>();
        for(String s: str1Map.keySet()) {
            if(str2Map.containsKey(s)) {
                intersection.add(s);
                intersectionSize += Math.min(str1Map.get(s), str2Map.get(s));
                unionSize += Math.max(str1Map.get(s), str2Map.get(s));
                continue;
            }
            unionSize += str1Map.get(s);
        }

        for(String s: str2Map.keySet()) {
            if(!intersection.contains(s)) {
                unionSize += str2Map.get(s);
            }
        }

        if(unionSize == 0 && intersectionSize == 0) return 65536;

        double answer = (double)intersectionSize / unionSize;
        return (int)(answer * 65536);
    }

    private boolean isAlphabet(String str) {
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z')) continue;
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NewsClustering s =new NewsClustering();
        System.out.println(s.solution("FRANCE", "french"));
    }
}
