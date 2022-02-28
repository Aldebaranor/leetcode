/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        int left=0,right=0,maxlength=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                maxlength=maxlength<right*2?right*2:maxlength;    
            }
            if(right>left){
                right=left=0;
            }
            
        }

        left=right=0;

        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==')'){
                right++;
            }else{
                left++;
            }
            if(left==right){
                maxlength=maxlength<left*2?left*2:maxlength;    
            }
            if(left>right){
                right=left=0;
            }
        }

        return maxlength;

    }
}
// @lc code=end

