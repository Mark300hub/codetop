package _852PeakIndexinaMountainArray;

/**
 * @Description TODO
 * @ClassName Solution
 * @Author haiyong.huang_sx
 * @Date 2022/6/15 16:33
 * @Version 1.0
 */
// 寻找山脉数组的峰顶，唯一
public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}