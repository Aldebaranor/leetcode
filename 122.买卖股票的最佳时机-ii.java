/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int[] purchase = new int[prices.length];
        int[] sold = new int[prices.length];
        if(prices.length==1){
            return 0;
        }
        purchase[0]=-prices[0];
        sold[0]=0;
        for(int i = 1;i < prices.length;i++){
            purchase[i]=purchase[i-1]>sold[i-1]-prices[i]?purchase[i-1]:sold[i-1]-prices[i];
            sold[i]=sold[i-1]>purchase[i-1]+prices[i]?sold[i-1]:purchase[i-1]+prices[i];
        }
        return sold[prices.length-1];
    }
}
// @lc code=end

