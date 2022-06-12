package _033SearchinRotatedSortedArray;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-12 12:49
 **/
// 搜索旋转排序数组
//      整数数组 nums 按升序排列，数组中的值 互不相同 。
public class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[left] <= nums[mid]) { // 左边有序
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // 右边有序
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}