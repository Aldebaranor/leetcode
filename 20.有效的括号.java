/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
      int len = s.length();
      if(len%2!=0){
        return false;
      }

      Stack<Character> st = new Stack<>();

      for(int i = 0;i < len;i++){
        char c = s.charAt(i);
        if(c=='('||c=='{'||c=='['){
          st.push(c);
        }else if(st.isEmpty()||(c==')'&&st.pop()!='(')||(c=='}'&&st.pop()!='{')||(c==']'&&st.pop()!='[')){
          return false;
        }
      }

      return st.isEmpty();

    }
}
// @lc code=end

