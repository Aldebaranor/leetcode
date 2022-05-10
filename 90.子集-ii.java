/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> n = new ArrayList<>();
        list.add(n);
        if(nums.length==0){
            return list;
        }
        return func(nums,list,0);
    }

    public List<List<Integer>> func(int[] nums,List<List<Integer>> list,int n){

        if(n==nums.length){
            return list;
        }

        int len = list.size();


        for(int i = 0;i < len;i++){
            List<Integer> temp=new ArrayList<>(list.get(i));
            temp.add(nums[n]);
            temp.sort(Comparator.naturalOrder());
            if(!list.contains(temp)){
                list.add(temp);
            }
        }

        return func(nums,list,n+1);
    }
}
// @lc code=end

