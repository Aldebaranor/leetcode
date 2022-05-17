/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if(length==1){
          return nums[0];
        }

        int[] nums1 = new int[length-1];
        int[] nums2 = new int[length-1];
        for(int i = 0;i<length-1;i++){
            nums1[i]=nums[i];
            nums2[i]=nums[length-1-i];
        }

        int[] dp = new int[length+1];
        dp[0]=dp[1]=0;

        int[] dp1 = new int[length+1];
        dp1[0]=dp1[1]=0;

        for(int i = 2;i < length+1;++i){

            dp[i] = Math.max(dp[i-1],dp[i-2]+nums1[i-2]);
        }

        for(int i = 2;i < length+1;++i){

            dp1[i] = Math.max(dp1[i-1],dp1[i-2]+nums2[i-2]);
        }

        return Math.max(dp[length],dp1[length]);
    }
}
// @lc code=end

