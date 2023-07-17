/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
      int a = binary(nums,target);
      int b = binary(nums,target+1);
      if(a!=nums.length&&nums[a]==target){
        return new int[]{a,b-1};
      }
      return new int[]{-1,-1};
      
    }
    public int binary(int[] nums,int target){
      int l=0,r=nums.length-1;
      while(l<=r){
        int mid = (l+r)/2;
        if(nums[mid]>=target){
          r=mid-1;
        }else{
          l=mid+1;
        }
      }
      return l;
    }
}
// @lc code=end

