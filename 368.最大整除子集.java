/*
 * @lc app=leetcode.cn id=368 lang=java
 *
 * [368] 最大整除子集
 */

// @lc code=start
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
      int len = nums.length;
      Arrays.sort(nums);
      int[] dp = new int[len];
      Arrays.fill(dp,1);
      int maxSize = 0;
      int maxValue = 0;

      for(int i = 0;i < len;i++){
        for(int j = 0;j < i;j++){
          if(nums[i]%nums[j]==0){
            dp[i]=Math.max(dp[i],dp[j]+1);
          }
        }
        if(dp[i]>maxSize){
          maxSize=dp[i];
          maxValue=nums[i];
        }
      }

      List<Integer> list = new ArrayList<Integer>();
      if(maxSize==1){
        list.add(nums[0]);
        return list;
      }

      for(int i = len-1;i >= 0 && maxSize > 0;i--){
        if(dp[i]==maxSize && maxValue%nums[i]==0){
          list.add(nums[i]);
          maxSize--;
          maxValue=nums[i];
        }
      }

      return list;
    }
}
// @lc code=end

