package offer._040theSmallestNumberOfK;

import sort.selectionsort.Heap;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-05 17:06
 **/
public class Solution {

    public int[] getLeastKNumbers(int[] arr, int k) {
        Heap heap = new Heap(true);
        return heap.getKNums(arr, k);
    }
}