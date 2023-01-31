import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        int m = g.length,n = s.length;
        for(int i = 0,j = 0;i < m && j < n;i++,j++){
            while(j < n && g[i]>s[j]){
                j++;
            }
            if(j < n){
                count++;
            }            
        }

        return count;
    }
}
// @lc code=end

