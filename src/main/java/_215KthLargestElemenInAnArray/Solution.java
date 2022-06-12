package _215KthLargestElemenInAnArray;

import sort.selectionsort.Heap;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-05 19:08
 **/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Heap heap = new Heap(true);
        return heap.getKNums(nums, k)[0];
    }
}