import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> arr = new LinkedList<>();
        boolean used[] = new boolean[nums.length];
        return backtrace(nums,used, 0,ans,arr);
    }

    public List<List<Integer>> backtrace(int[] nums,boolean[] used,int n,List<List<Integer>> ans,List<Integer> arr){
        if(n==nums.length){
            if(!ans.contains(arr)){
                ans.add(new ArrayList<>(arr));
            }
            return ans;
        }
        for(int i = 0;i < nums.length; ++i){
            if(!used[i]){
                used[i]=true;
                arr.add(nums[i]);
                backtrace(nums,used,n+1,ans,arr);
                used[i]=false;
                arr.remove(n);
            }
        }

        return ans;
    }
}
// @lc code=end

