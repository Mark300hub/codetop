package _015threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-05 21:31
 **/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int first = nums[i];
            if (first > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = first + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                } else if (sum > 0){
                    while (left < right && nums[right] == nums[--right]);
                } else {
                    while (left < right && nums[left] == nums[++left]);
                }
            }
        }
        return res;
    }
}