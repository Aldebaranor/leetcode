/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {

        int max=0;
        int temp=0;

        int rows = matrix.length;

        if(rows==0){
            return 0;
        }

        int cols = matrix[0].length;



        int[][] left = new int[rows][cols];
        int[][] area = new int[rows][cols];

        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){

                area[i][j]=0;

                if(matrix[i][j]=='1'){
                    for(int k=j;k>-1;k--){
                        if(matrix[i][k]!='0'){
                            left[i][j]++;
                        }else break;
                    }

                    for(int k=i,high=0,width=left[i][j];k>-1;k--){
                        if(left[k][j]!='0'){
                            high++;
                            width=Math.min(width,left[k][j]);
                            temp=width*high;
                            area[i][j]=Math.max(temp,area[i][j]);
                        }
                    }

                    max=Math.max(area[i][j],max);

                }else{
                    left[i][j]=0;
                }
            }
        }

        return max;
    }
}
// @lc code=end

