package _300LongestIncreasingSubsequence;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-14 22:35
 **/
public class Test {
    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(solution02.lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }
}