package leetcode;

public class P5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String ret = "";
        for(int i = 0; i < s.length(); i++) {
            int len = Math.max(helper(s, i, i), helper(s, i, i + 1));
            if(ret.length() < len) {
                ret = s.substring(i - (len - 1) / 2, i + len / 2 + 1);
            }
        }
        return ret;
    }

    private int helper(String str, int s, int e) {
        if(s < 0 || e >= str.length()) return 0;
        while (s >= 0 && e < str.length() && str.charAt(s) == str.charAt(e)) {
            s--;
            e++;
        }
        return e - s - 1;
    }
}
