package sort.selectionsort;

import sort.selectionsort.Heap;

import java.util.Arrays;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-05 18:15
 **/
public class HeapSortTest {
    public static void main(String[] args) {
        Heap heap = new Heap(true);
        int[] arr = {4,7,3,5,6,2,1,10,9,8,20,16,14,23,35};
        heap.sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] kNums = heap.getKNums(arr, 5);
        System.out.println(Arrays.toString(kNums));

    }
}