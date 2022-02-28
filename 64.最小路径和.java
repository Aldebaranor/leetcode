/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[m-1].length;

        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            dp[i][0]=1000;
        }
        for(int i=0;i<n+1;i++){
            dp[0][i]=1000;
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(i==1&&j==1){
                    dp[1][1]=grid[0][0];
                } else {
                    dp[i][j]=1000;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + grid[i-1][j-1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + grid[i-1][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}
// @lc code=end

