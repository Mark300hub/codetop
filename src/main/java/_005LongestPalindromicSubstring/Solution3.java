package _005LongestPalindromicSubstring;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-11 14:30
 **/
public class Solution3 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            int oldLen = expandAroundCenter(s, i, i);
            int evenLen = expandAroundCenter(s, i, i + 1);
            int temp = Math.max(oldLen, evenLen);
            if (temp > maxLen) {
                maxLen = temp;
                start = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(start, maxLen + start);
    }

    private int expandAroundCenter(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}