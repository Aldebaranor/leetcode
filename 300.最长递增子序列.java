/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int ans = 1;

        int[] dp = new int[len];
        dp[0]=1;

        for(int i = 1;i < len;i++){
            dp[i]=1;
            for(int j = 0;j < i;j++){

                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            ans = Math.max(dp[i],ans);

        }

        return ans;

    }
}
// @lc code=end

