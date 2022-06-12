package _005LongestPalindromicSubstring;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-11 11:43
 **/
// 最长回文字符串
public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];// 代表 子串[i j]是否为回文字符串
        int res = 1;

        int maxLen = 1;
        int i = 0;
        for (int len = 2; len <=  n; len++) {// 子串的长度
            for (int start = 0; start < n; start++) {// 子串起始位置
                int end = start + maxLen - 1;
                if (end >= n) {// 右边界越界
                    break;
                }
                if (s.charAt(start) != s.charAt(end)) {
                    dp[start][end] = false;
                } else {
                    if (end - start < 3) {// 防止 start > end 比如只有两个元素
                        dp[start][end] = true;
                    } else {
                        dp[start][end] = dp[start + 1][end - 1];
                    }
                }
                if (dp[start][end] && (end - start + 1) > maxLen) {
                    i = start;
                    maxLen = end - start + 1;
                }
            }
        }
        return s.substring(i, maxLen + i);
    }
}