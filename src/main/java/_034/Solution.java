package _034;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-12 18:52
 **/
// 找出目标值在排序数组中的开始位置和结束位置
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[right] != target) {
            return res;
        }
        res[0] = right;

        left = right;
        right = n - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        res[1] = right;
        return res;
    }
}