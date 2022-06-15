package _162FindPeakElement;

/**
 * @Description TODO
 * @ClassName SOlution
 * @Author haiyong.huang_sx
 * @Date 2022/6/15 16:15
 * @Version 1.0
 */
// 寻找山峰数组的峰顶，如果有多个返回一个既可以
public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int left = 0; int right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                right = mid; // mid 可能为峰值
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}