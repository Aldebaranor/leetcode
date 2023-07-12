/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
      if(k==0){
        return false;
      }
      HashMap<Integer,Integer> map = new HashMap();
      for(int i=0;i<nums.length;i++){
        if(map.containsKey(nums[i])&&(Math.abs(map.get(nums[i])-i)<=k)){
          return true;
        }else{
          map.put(nums[i],i);
        }
      }
      return false;
    }
}
// @lc code=end

