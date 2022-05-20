/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
      int[] bits = new int[n+1];
      for(int i = 0;i < n+1;i++){
        bits[i]=count1(i); 
      }
      return bits;
    }
    public int count1(int n){
      int res = 0;
      while(n!=0){
        n=n&(n-1);
        res++;
      }
      return res;
    }
}
// @lc code=end

