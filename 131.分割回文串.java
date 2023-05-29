import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> palindrome = new ArrayList<>();
    boolean[][] dp;
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();

        dp = new boolean[n][n];
        // 边界1: 对角线，即单个字符，都是回文
        for(int i = 0; i < n; i++){ 
            dp[i][i] = true;
        }
        // 边界2:对角线上侧紧邻斜线，即两个字符，判断是否相等，相等则为回文
        for(int i = 0; i < n - 1; i++){ 
            dp[i][i + 1] = s.charAt(i) == s.charAt(i+ 1);
        }
        // 从下到上，边界1和边界2确定了两条斜线，所以只需要从倒数第三行开始往上补全右上三角
        for(int i = n - 3; i >= 0; i--){  
            for(int j = i + 2; j < n; j++){ 
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }           

        dfs(s,0);
        return res;
    }

    public void dfs(String s,int i){
        if(i==n){
            res.add(new ArrayList<String>(palindrome));
            return;
        }
        for(int j=i;j<n;j++){
            if(dp[i][j]){
                palindrome.add(s.substring(i,j+1));
                dfs(s,j+1);
                palindrome.remove(palindrome.size()-1);
            }
        }
    }
}
// @lc code=end

