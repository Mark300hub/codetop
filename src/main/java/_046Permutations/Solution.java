package _046Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @ClassName Solution
 * @Author haiyong.huang_sx
 * @Date 2022/6/14 10:29
 * @Version 1.0
 */
// 全排列
public class Solution {
    private List<List<Integer>> res;
    private int[] nums;
    private boolean[] isVisited;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        this.nums = nums;
        isVisited = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        dfs(0, path);
        return res;
    }

    private void dfs(int n, List<Integer> path) {
        if (n == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isVisited[i]) {
                path.add(nums[i]);
                isVisited[i] = true;
                dfs(n + 1, path);
                isVisited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}