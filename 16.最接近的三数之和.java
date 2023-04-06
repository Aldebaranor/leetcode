import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int gap=Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0;i < len;i++){

            for(int j = i+1;j<len;j++){
                int k = len-1;
                while(j<k){
                    int abs = Math.abs(target-(nums[i]+nums[j]+nums[k]));
                    if(gap>abs){
                        gap = abs;
                        res = nums[i]+nums[j]+nums[k];
                    }
                    k--;
                }
            }
        }

        return res;
    }
}
// @lc code=end

