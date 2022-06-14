package _300LongestIncreasingSubsequence;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-14 22:22
 **/

/**
 * 我们尽可能的减缓子序列的上升速度
 * nums[i] 只能覆盖tail[]，但是不能插入
 * 比如现在有的tail
 *          0
 *          0 2
 *          0 2 4
 *          0 2 4 8
 *          这时候来个3
 *          只能是
 *          0
 *          0 2
 *          0 2 3  不能是 0 2 3 4
 *          0 2 4 8
 */
public class Solution02 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tail = new int[n + 1]; //代表长度为i的最大子序列和的最后一个元素的最小值
        tail[1] = nums[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > tail[len]) {
                tail[++len] = nums[i];
            } else {
                // 需要找到一个值 小于tail[n] && 大于tail[n - 1]
                int index = binaryFind(tail, nums[i], 1, len);
                tail[index] = nums[i];
            }
        }
        return len;
    }

    /*
     * @Description //TODO 找出target所在的位置，如果不存在需要找到
     *                 小于tail[i] && 大于等于tail[i - 1]  则i就为其位置
     *                 tail[left] <= target < tail[right]
     * @Param tail:
     * @param target:
     * @param left:
     * @param right:
     * @return : int
     **/
    private int binaryFind(int[] tail, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (tail[mid] == target) {
                return mid;
            } else if (tail[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}