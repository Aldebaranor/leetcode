/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 */

// @lc code=start
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
      List<String> res = new ArrayList<>();
      if(turnedOn>8){
        return res;
      }
      for(int i = 0;i < 12;i++){
        for(int j = 0;j < 60;j++){
          if((count(i)+count(j)) == turnedOn){
            String s = String.valueOf(i).concat(":").concat((j<10)?"0":"").concat(String.valueOf(j));
            res.add(s); 
          }       
        }
      }
      return res;
    }

    public int count(int i){
      int num =0;
      while(i!=0){
        num+=i & 1;
        i>>=1;
      }
      return num;
    }

}
// @lc code=end

