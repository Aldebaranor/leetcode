/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums,0,nums.length-1); 
        return nums[nums.length-k];
    }

    public void quickSelect(int[] a,int l,int r){
        if(l < r){
            int q = a[l], i = l, j = r;
            while(i<j){
                while(i < j && a[j] >= q){
                    j--;
                }
                if(i < j){
                    a[i++] = a[j];
                }
                while(i < j && a[i] < q){
                    i++;
                }
                if(i < j){
                    a[j--] = a[i];
                }
            }
            a[i] = q;
            quickSelect(a,l,i-1);
            quickSelect(a,i+1,r);
        }
    }
    
}
// @lc code=end

