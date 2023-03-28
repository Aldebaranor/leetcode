/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if(s.equals(""))return res;
        StringBuffer word = new StringBuffer();
        for(int i =0;i<s.length();i++){
            int index = word.toString().indexOf(s.charAt(i));
            if(index<0){
                word.append(s.charAt(i));
                res=res>word.length()?res:word.length();
            }else{
                String temp = word.substring(index+1);
                word = new StringBuffer(temp).append(s.charAt(i));
                res=res> word.length()?res:word.length();
            }
        }
        return res;
    }
}
// @lc code=end

