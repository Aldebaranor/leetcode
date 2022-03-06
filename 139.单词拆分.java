import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> words = new HashSet<>(wordDict);

        int n = s.length();

        int maxlen = 0;

        for(String word:words){
            maxlen=(word.length()>maxlen)?word.length():maxlen;
        }

        boolean[] dp = new boolean[n+1];

        dp[0]=true;

        for(int i = 1;i <= n;i++){
            // for(int j =0 ;j < i;j++){
            //     dp[i]=(dp[j]&&words.contains(s.substring(j, i)))?true:false;
            //     if(dp[i]) break;
            // }

            for(int j =i-1 ;j >= 0;j--){
                if((i-j)>maxlen) break;
                dp[i]=(dp[j]&&words.contains(s.substring(j, i)))?true:false;
                if(dp[i]) break;
            }
        }

        return dp[n];
    }

}
// @lc code=end

