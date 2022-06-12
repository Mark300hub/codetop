package _088MergeSortedArray;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-11 15:39
 **/
// 以O(m + n)的时间复杂度合并两个有序数组
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }
}