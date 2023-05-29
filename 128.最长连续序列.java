import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==0){
            return 0;
        }
        int res = 1;
        int len = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                len++;
            }else if(nums[i]==nums[i-1]){
                continue;
            }else{
                len=1;
            }
            res=res>len?res:len;
        }
        return res;
    }
}
// @lc code=end

