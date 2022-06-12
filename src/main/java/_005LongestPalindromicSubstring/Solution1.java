package _005LongestPalindromicSubstring;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-11 13:34
 **/
public class Solution1 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        boolean[][] dp = new boolean[n][n];

        int maxLen = 1;
        int left = 0;
        // dp[start][end] 依赖于 dp[start + 1][end - 1]
        // 所以start从后向前遍历， end从前向后遍历
        for (int start = n - 1; start >= 0; start--) {
            for (int end = start; end < n; end++) {
                if (start == end) {
                    dp[start][end] = true;
                    continue;
                }
                if (s.charAt(start) != s.charAt(end)) {
                    continue;
                }
                if (end - start < 3) {
                    dp[start][end] = true;
                } else {
                    dp[start][end] = dp[start + 1][end - 1];
                }
                if (dp[start][end] && (end - start + 1) > maxLen) {
                    left = start;
                    maxLen = end - start + 1;
                }
            }
        }
        return s.substring(left, maxLen + left);
    }
}