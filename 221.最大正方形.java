/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp =new int[m+2][n+2];
        for (int i = 0;i< m+2;i++){
            dp[i][0]=0;
            dp[i][n+1]=0;
        }
        for (int i = 0;i< n+2;i++){
            dp[0][i]=0;
            dp[m+1][i]=0;
        }

        for(int i = 1;i < m+1;i++){
            for(int j = 1;j < n+1;j++){
                if(matrix[i-1][j-1]!='0'){
                    if(max<1){
                        max=1;
                    }
                    if(dp[i-1][j-1]!=0){
                        int len = 0;
                        boolean flag = false;
                        for(int k = 1;k <= dp[i-1][j-1];k++){
                            if(matrix[i-1][j-1-k]!='0'&&matrix[i-1-k][j-1]!='0'){
                                flag = true;
                                len++;
                            }else {
                                break;
                            }
                        }
                        if(flag) {
                            dp[i][j] = len+1;
                            int area = dp[i][j] * dp[i][j];
                            max = (max > area) ? max : area;
                        }else {
                            dp[i][j]=1;
                        }

                    }else dp[i][j]=1;

                }else dp[i][j]=0;
            }
        }

        return max;

    }
}
// @lc code=end

