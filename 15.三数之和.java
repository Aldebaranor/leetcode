/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int len = nums.length;

        Arrays.sort(nums);
        for(int i = 0;i < len;i++){
            int k = len-1;
            int target = -nums[i];
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j = i+1;j<len;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                while(j<k&&nums[j]+nums[k]>target){
                    k--;
                }
                if(j==k){
                    break;
                }
                if(target==nums[j]+nums[k]){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                }
            }
        }

        return res;
    }
}
// @lc code=end

