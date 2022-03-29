/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int n = height.length;
        int i = 0,j = n-1;
        while(i<j){
            int area = (j-i)*Math.min(height[i], height[j]);
            maxWater=area>maxWater?area:maxWater;
            if(height[i]>=height[j]){
                j--;
            }else{
                i++;
            }
        }

        return maxWater;
    }
}
// @lc code=end

