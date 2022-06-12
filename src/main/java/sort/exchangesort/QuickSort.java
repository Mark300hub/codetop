package sort.exchangesort;

import java.util.Random;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-05 22:18
 **/
public class QuickSort {

    private static Random random;

    public static int[] sortArray(int[] nums) {
        random = new Random();
        sort(nums);
        return nums;
    }

    public static void sort(int[] nums) {

        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = random.nextInt(right - left) + left;
        int temp = nums[index];
        nums[index] = nums[left];
        nums[index] = temp;
        int pivot = partition(nums, left, right);
        sort(nums, left, pivot - 1);
        sort(nums, pivot + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int pivotIndex = left;
        while (left < right) {
            //选取left为哨兵：
            // 先从右边扫描比pivot小的值,检索到比pivot大或者等于(一定要是大于或等于)就继续检索，否则停下
            // 假如从左边开始扫描 3,1,2,5,4  结果为 5,1,2,3,4
            // 假设对于等于pivot的值，参与交换？，假如i的指向的值和j指向的值都等于pivot，就会陷入死循环。
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
        }

        nums[pivotIndex] = nums[left];
        nums[left] = pivot;
        return left;
    }
}