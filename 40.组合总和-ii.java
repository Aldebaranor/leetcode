/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> lists = new LinkedList<>();

        List<Integer> list = new LinkedList<>();

        int len = candidates.length;
        if(len==0){
            return lists;
        }

        Arrays.sort(candidates);

        backtrace(0,len,candidates,target,lists,list);

        System.out.println(lists);
        return lists;
    }

    public void backtrace(int begin,int len,int[] candidates,int target,List<List<Integer>> lists,List<Integer> list){

        if(target==0){
            lists.add(new LinkedList<>(list));
            return;
        }

        for(int i =begin;i<len;i++){
            if(target-candidates[i]<0) {
                break;
            }
            if(i>begin&&candidates[i]==candidates[i-1]){
                continue;
            }
            list.add(candidates[i]);
            backtrace(i+1,len,candidates,target-candidates[i],lists,list);
            list.remove(list.size()-1);

        }

    }

}
// @lc code=end

