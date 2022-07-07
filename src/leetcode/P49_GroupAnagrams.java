package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] arrangedStrs = new String[strs.length];
        for(int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            arrangedStrs[i] = String.valueOf(temp);
        }

        List<List<String>> answer = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        for(int i = 0; i < strs.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;

            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            for(int j = 0; j < strs.length; j++) {
                if(visited[j]) continue;

                if(arrangedStrs[i].equals(arrangedStrs[j])) {
                    temp.add(strs[j]);
                    visited[j] = true;
                }
            }

            if(temp.size() > 0) answer.add(temp);
        }

        return answer;
    }

    public static void main(String[] args) {
        P49_GroupAnagrams s = new P49_GroupAnagrams();
        s.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}
