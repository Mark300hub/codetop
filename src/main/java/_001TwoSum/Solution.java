package _001TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-06 21:29
 **/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }
}