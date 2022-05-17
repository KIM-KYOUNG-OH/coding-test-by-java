package leetcode;

import java.util.HashMap;
import java.util.Map;

public class P3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;

        int result = 1;

        int n = s.length();
        for(int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            map.put(s.charAt(i), 1);
            for (int j = i + 1; j < n; j++) {
                char pointer2 = s.charAt(j);
                if(map.containsKey(pointer2)) {
                    result = Math.max(result, j - i);
                    break;
                }
                map.put(pointer2, 1);
                if(j == n - 1) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        P3_LongestSubstringWithoutRepeatingCharacters s = new P3_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
    }
}
