/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int len = candidates.length;

        List<List<Integer>> lists = new LinkedList<>();
        if(len==0){
            return lists;
        }

        Arrays.sort(candidates);
        List<Integer> list = new LinkedList<>();
        backtrace(0,candidates,len,target,lists,list);

        return lists;

    }

    public void backtrace(int begin,int[] candidates,int len, int target,List<List<Integer>> lists,List<Integer> list){

        if(target==0){
            lists.add(new LinkedList<>(list));
            return;
        }

        for(int i = begin;i<len;i++){
            if(target - candidates[i]<0){
                break;
            }
            list.add(candidates[i]);
            backtrace(i,candidates,len,target-candidates[i],lists,list);
            list.remove(list.size()-1);            
        }

    }


}
// @lc code=end

