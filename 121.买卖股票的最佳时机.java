/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {

        int res=0;
        int n = prices.length;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<n;++i){
            if(prices[i]<min){
                min = prices[i];
            }
            if(res<prices[i]-min){
                res=prices[i]-min;
            }
        }

            return res;

    }
}
// @lc code=end

