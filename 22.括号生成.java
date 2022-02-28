/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();

        if(n==0){
            return res;
        }

        backtrack(res,n,1,new StringBuffer());

        return res;
    }

    public void backtrack(List<String> res, int n, int i, StringBuffer sb){
        if(i==n+1){
            if(!res.contains(sb.toString())) {
                res.add(sb.toString());
            }
        }else {

            for (int j = 0;j < 2 * i - 1; j++) {

                sb.insert(j, "()");
                backtrack(res, n, i + 1, sb);
                sb.delete(j, j + 2);
            }

        }
    }

}
// @lc code=end

