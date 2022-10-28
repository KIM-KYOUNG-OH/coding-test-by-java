package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compression {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            map.put(String.valueOf((char)(i + 65)), map.size() + 1);
        }

        List<Integer> answer = new ArrayList<>();
        int i = 0;
        while(i < msg.length()) {
            StringBuilder w = new StringBuilder();
            char start = msg.charAt(i);
            w.append(start);
            int j = i + 1;
            while(j < msg.length()) {
                char c = msg.charAt(j);
                w.append(c);
                if(!map.containsKey(w.toString())) {
                    break;
                }
                j++;
            }

            if(j == msg.length()) {
                answer.add(map.get(w.toString()));
                break;
            }

            map.put(w.toString(), map.size() + 1);
            w.deleteCharAt(w.length() - 1);
            answer.add(map.get(w.toString()));
            i = j;
        }

        int[] arr = new int[answer.size()];
        int k = 0;
        for (int num : answer) {
            arr[k++] = num;
        }

        return arr;
    }

    public static void main(String[] args) {
        Compression s = new Compression();
        s.solution("ABABABABABABABAB");
    }
}
