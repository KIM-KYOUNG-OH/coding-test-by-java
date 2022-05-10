package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17_LetterCombinationsOfAPhoneNumber {
    Map<Character, String[]> map;
    List<String> result;

    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});

        result = new ArrayList<>();

        if(digits.length() == 0) {
            return result;
        }
        dfs("", 0, digits);

        return result;
    }

    private void dfs(String current, int depth, String digits) {
        if(depth == digits.length()) {
            result.add(current);
            return;
        }

        String[] alps = map.get(digits.charAt(depth));
        for(int i = 0; i < alps.length; i++) {
            dfs(current + alps[i], depth + 1, digits);
        }
    }

}
