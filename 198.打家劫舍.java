/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int length = nums.length;

        int[] dp = new int[length+2];
        dp[0]=dp[1]=0;

        for(int i = 2;i < length+2;++i){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-2]);
        }
        return dp[length+1];
    }
}
// @lc code=end

