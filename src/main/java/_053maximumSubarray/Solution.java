package _053maximumSubarray;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-06 20:54
 **/
// 最大子序列和
public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}