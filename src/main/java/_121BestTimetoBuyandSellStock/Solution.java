package _121BestTimetoBuyandSellStock;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-07 21:52
 **/
public class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}