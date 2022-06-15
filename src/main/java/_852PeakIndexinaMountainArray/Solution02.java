package _852PeakIndexinaMountainArray;

/**
 * @Description TODO
 * @ClassName Solution02
 * @Author haiyong.huang_sx
 * @Date 2022/6/15 16:38
 * @Version 1.0
 */
public class Solution02 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (arr[mid] > arr[mid - 1]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}