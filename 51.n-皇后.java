/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List total = new ArrayList<List>();
        List res = new ArrayList<String>();
        for(int i = 0;i < n;i++){
            StringBuffer sb = new StringBuffer("");
            for(int j = 0;j < n;j++){
                sb.append('.');
            }
            res.add(sb);
        }

        return backtrace(total,res,0);
    }

    public List<List<String>>backtrace(List total,List res,int col){
        if(col==res.size()){
            List ans = new ArrayList<String>(res);
            total.add(ans);
            return total;
        }

        for(int i = 0;i < res.size();i++){

            if(coorect(res,col,i)) {

                StringBuffer sb = new StringBuffer(res.get(col).toString());
                sb.setCharAt(i, 'Q');
                res.set(col, sb.toString());
                col++;
                backtrace(total, res, col);
                col--;
                sb.setCharAt(i, '.');
                res.set(col, sb.toString());
            }

        }

        return total;
    }

    public Boolean coorect(List list,int col,int row){
        int n = list.size();
        char[][] matrix = new char[n][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                String str = list.get(i).toString();
                matrix[i][j]=str.charAt(j);
            }
        }

        for(int i = 0;i < n;i++){
            if(i!=row) {
                if(matrix[col][i]=='Q'){
                    return false;
                }
            }
            if(i!=col){
                if(matrix[i][row]=='Q'){
                    return false;
                }
            }
        }
        int sum = col+row;
        if(sum>=n-1){
            for(int i = n-1;i>=sum-n+1;i--){
                if(i!=row){
                    if(matrix[sum-i][i]=='Q'){
                        return false;
                    }
                }
            }
        }else{
            for(int i =0;i<=sum;i++){
                if(i!=col){
                    if(matrix[i][sum-i]=='Q'){
                        return false;
                    }
                }
            }
        }

        int dif = col-row;
        if(dif>=0){
            for(int i = dif;i<=n-1;i++){
                if(i!=col){
                    if(matrix[i][i-dif]=='Q'){
                        return false;
                    }
                }
            }
        }else {
            for(int i = n-1;i>=-dif;i--){
                if(i!=row){
                    if(matrix[i+dif][i]=='Q'){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
// @lc code=end

