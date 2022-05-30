/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
      List<Integer> list = new ArrayList();
      list.add(1);
      list.add(1);
      list.add(2);
      list.add(4);
      list.add(6);
      list.add(9);
      
      if(n > 6){
          for(int i = 6;i < n;i++){
              int ans = 0;
              for(int j = 2;j <= i/2;j++){
                  int temp = j*list.get(i-j);
                  ans=(ans>temp)?ans:temp;
              }
              list.add(ans);
          }
      }    

      return list.get(n-1);
    }
}
// @lc code=end

