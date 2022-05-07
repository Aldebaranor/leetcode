/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> n = new ArrayList<>();
        list.add(n);
        if(nums.length==0){
            return list;
        }
//        List<Integer>  list1 = new ArrayList<>();
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
            list.add(temp);
        }

        return func(nums,list,n+1);
    }
}
// @lc code=end

