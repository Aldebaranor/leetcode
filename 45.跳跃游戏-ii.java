/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
<<<<<<< HEAD

		int length = nums.length;
        int end = 0;
        int maxPosition = 0; 
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]); 
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
=======
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
>>>>>>> 5e4e85cafd21d5e48bd50cc130624fbdfe2b663b
    }
}
// @lc code=end

