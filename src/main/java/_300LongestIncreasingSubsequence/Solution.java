package _300LongestIncreasingSubsequence;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-14 21:50
 **/

/**
 * 注意的一个点：
 *    dp[i] 不止需要dp[i - 1]，它需要的是前面所有的结果
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 1;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return dp[n - 1];
    }
}