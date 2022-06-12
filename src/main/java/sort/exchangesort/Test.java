package sort.exchangesort;


import java.util.Arrays;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-05 22:36
 **/
public class Test {
    public static void main(String[] args) {
        int[] arr = {4,7,3,5,6,2,1,10,9,8,20,16,14,23,35};
        QuickSort.sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}