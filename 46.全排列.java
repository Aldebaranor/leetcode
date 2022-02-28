/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {


        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        for(int num:nums){
            list.add(num);
        }
        int n = nums.length;

        backtrace(n,0,lists,list);

        return lists;

    }

    public void backtrace(int n,int len,List<List<Integer>> lists,List<Integer> list){

        if(len==n){
            lists.add(new LinkedList<>(list));
            return;
        }

        for(int i =len;i<n;i++){
            Collections.swap(list,len,i);
            backtrace(n,len+1,lists,list);
            Collections.swap(list,len,i);
        }

    }
}
// @lc code=end

