/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
              if(nums.length<k){
            return new int[]{};
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
            @Override
            public int compare(Map.Entry<Integer,Integer> o1,Map.Entry<Integer,Integer> o2){
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]=list.get(list.size()-1-i).getKey();
        }
        return res;
    }
}
// @lc code=end

