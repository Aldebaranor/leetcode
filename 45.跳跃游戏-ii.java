/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
      int steps =0;
      int len = nums.length-1;
      while(len>0){
        for(int i =0;i<len;i++){
          if(nums[i]+i>=len){
            steps++;
            len=i;
            break;
          }
        }
      }
      return steps;
    }
}
// @lc code=end

