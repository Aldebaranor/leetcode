/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n=triangle.size();

        int res[][] = new int[n][n];

        res[0][0]=triangle.get(0).get(0);

        for(int i =1;i<n;i++){
            res[i][0]=res[i-1][0]+triangle.get(i).get(0);
            for(int j=1;j<triangle.get(i).size();j++){

                res[i][j]=Math.min(res[i-1][j-1],res[i-1][j])+triangle.get(i).get(j);

            }
            res[i][i]=res[i-1][i-1]+triangle.get(i).get(i);
        }

        int minTotal = res[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, res[n - 1][i]);
        }
        return minTotal;

    }
}
// @lc code=end

