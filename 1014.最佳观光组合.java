/*
 * @lc app=leetcode.cn id=1014 lang=java
 *
 * [1014] 最佳观光组合
 */

// @lc code=start
class Solution {
    public int maxScoreSightseeingPair(int[] values) {

        int n = values.length;

        int[] points = new int[n];

        points[0]=0;

        int ans = 0;

        int maxstart = values[0]+0;

        for(int i = 1;i < n; i++){
           points[i]=maxstart+values[i]-i;
           maxstart = (maxstart>values[i]+i)?maxstart:values[i]+i;
        }

        for(int point:points){
            ans=(point>ans)?point:ans;
        }

        return ans;
    }
}
// @lc code=end

